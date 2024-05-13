package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.hcl.entity.UserTransactionEntity;
import com.hcl.hackathon.hcl.repository.UserTransactionEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransactionDaoService {

    @Autowired UserTransactionEntityRepo userTransactionEntityRepo;
    
    public void save(UserTransactionEntity userTransactionEntity) {
        userTransactionEntityRepo.save(userTransactionEntity);
    }
}
