package com.hcl.hackathon.hcl.service;

import com.hcl.hackathon.hcl.dao.MerchantTransactionDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantTransactionService {

    @Autowired MerchantTransactionDaoService merchantTransactionDaoService;
}
