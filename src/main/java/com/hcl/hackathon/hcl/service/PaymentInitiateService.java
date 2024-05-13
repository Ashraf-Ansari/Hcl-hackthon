package com.hcl.hackathon.hcl.service;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.devlopment.exception.ValidationException;
import com.hcl.hackathon.hcl.dao.MerchantAccountDaoService;
import com.hcl.hackathon.hcl.dao.MerchantTransactionDaoService;
import com.hcl.hackathon.hcl.dao.ProductDaoService;
import com.hcl.hackathon.hcl.dao.UserAccountDaoService;
import com.hcl.hackathon.hcl.dao.UserDaoService;
import com.hcl.hackathon.hcl.dao.UserTransactionDaoService;
import com.hcl.hackathon.hcl.dao.WalletDaoService;
import com.hcl.hackathon.hcl.entity.MerchantAccountEntity;
import com.hcl.hackathon.hcl.entity.MerchantTransactionEntity;
import com.hcl.hackathon.hcl.entity.ProductEntity;
import com.hcl.hackathon.hcl.entity.UserAccountEntity;
import com.hcl.hackathon.hcl.entity.UserEntity;
import com.hcl.hackathon.hcl.entity.UserTransactionEntity;
import com.hcl.hackathon.hcl.entity.WalletEntity;
import com.hcl.hackathon.hcl.pojo.PurchaseRequest;
import com.hcl.hackathon.hcl.util.CommonHelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PaymentInitiateService {
    
    @Autowired ProductDaoService productDaoService;
    @Autowired UserDaoService userDaoService;
    @Autowired MerchantAccountDaoService merchantAccountDaoService;
    @Autowired WalletDaoService walletDaoService;
    @Autowired UserAccountDaoService userAccountDaoService;
    @Autowired UserTransactionDaoService userTransactionDaoService;
    @Autowired MerchantTransactionDaoService merchantTransactionDaoService;
    @Autowired KafkaTemplate<String, String> kafkaTemplate;
    
    
    
    public void purchaseInitiationService(PurchaseRequest purchaseRequest)
        throws UserNotFoundException, ValidationException {
        // initiate payment
        Long quantity = purchaseRequest.getQuantity();
        Long productId = purchaseRequest.getProductId();
        Long merchantId = purchaseRequest.getMerchantId();
        Long userId = purchaseRequest.getUserId();
        // initiate payment
        ProductEntity product = productDaoService.findById(productId);
        UserEntity user = userDaoService.findById(userId);
        
        WalletEntity wallet = walletDaoService.findByUserId(userId);
        Integer userAge = user.getAge();
        String userCountry = user.getCountry();
        
        if(userAge < product.getAgeRestriction() && userCountry.equalsIgnoreCase("UK")) {
            throw new ValidationException("User is not eligible to purchase the product");
        }
        
        BigDecimal purchaseAmount = product.getProductCost().multiply(CommonHelperFunctions.getBigDecimalValue(quantity));
        if(wallet.getBalance().compareTo(purchaseAmount) < 0) {
            throw new ValidationException("Insufficient balance in wallet");
        }
        
        if(product.isHarmful()){
            throw new ValidationException("Product is harmful");
        }
        
        doPayment(wallet, purchaseAmount, userId, merchantId, productId);
        
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    private synchronized void doPayment(WalletEntity wallet, BigDecimal purchaseAmount,Long userId,Long merchantId,Long productId)
        throws UserNotFoundException {
        // do payment
        BigDecimal walletRemaingAmount = wallet.getBalance().subtract(purchaseAmount);
        wallet.setBalance(walletRemaingAmount);
        wallet.setLastUpdated(new Date());
        walletDaoService.save(wallet);
        UserAccountEntity userAccountDetails = userAccountDaoService.findByUserId(userId);
        userAccountDetails.setLastUpdated(new Date());
        BigDecimal userAccountBalance = userAccountDetails.getBalance().subtract(purchaseAmount);
        userAccountDetails.setBalance(userAccountBalance);
        userAccountDaoService.save(userAccountDetails);
        MerchantAccountEntity merchantAccount = merchantAccountDaoService.findById(merchantId);
        merchantAccount.setLastUpdated(new Date());
        merchantAccount.setBalance(merchantAccount.getBalance().add(purchaseAmount));
        merchantAccountDaoService.save(merchantAccount);
        String transactionUUID = CommonHelperFunctions.getTransactionUUID();
        UserTransactionEntity userTransactionEntity = new UserTransactionEntity();
        userTransactionEntity.setAmount(purchaseAmount);
        userTransactionEntity.setTransactionType("DEBIT");
        userTransactionEntity.setUserID(CommonHelperFunctions.getIntegerValue(userId));
        userTransactionEntity.setTimestamp(new Date());
        userTransactionEntity.setStatus("SUCCESS");
        userTransactionEntity.setTransactionDescription("Payment to merchant");
        userTransactionEntity.setProductID(CommonHelperFunctions.getIntegerValue(productId));
        userTransactionEntity.setTransactionID(transactionUUID);
        userTransactionDaoService.save(userTransactionEntity);
        MerchantTransactionEntity merchantTransactionEntity = new MerchantTransactionEntity();
        merchantTransactionEntity.setAmount(purchaseAmount);
        merchantTransactionEntity.setTransactionType("CREDIT");
        merchantTransactionEntity.setUserID(CommonHelperFunctions.getIntegerValue(userId));
        merchantTransactionEntity.setTimestamp(new Date());
        merchantTransactionEntity.setStatus("SUCCESS");
        merchantTransactionEntity.setTransactionDescription("Payment from user");
        merchantTransactionEntity.setProductID(CommonHelperFunctions.getIntegerValue(productId));
        merchantTransactionEntity.setTransactionID(transactionUUID);
        merchantTransactionDaoService.save(merchantTransactionEntity);
        kafkaTemplate.send("TransactionDataTopic",userTransactionEntity.toString());
    }

}
