package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.hcl.entity.MerchantTransactionEntity;
import com.hcl.hackathon.hcl.repository.MerchantTransactionEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantTransactionDaoService {
    
    @Autowired MerchantTransactionEntityRepo merchantTransactionEntityRepo;

    public void save(MerchantTransactionEntity merchantTransactionEntity) {
        merchantTransactionEntityRepo.save(merchantTransactionEntity);
    }
}
