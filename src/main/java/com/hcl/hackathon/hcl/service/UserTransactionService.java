package com.hcl.hackathon.hcl.service;

import com.hcl.hackathon.hcl.dao.UserTransactionDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransactionService {
    
    @Autowired UserTransactionDaoService userTransactionDaoService;
}
