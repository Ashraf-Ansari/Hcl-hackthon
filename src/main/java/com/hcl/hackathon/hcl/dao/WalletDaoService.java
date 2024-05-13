package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.WalletEntity;
import com.hcl.hackathon.hcl.repository.WalletEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletDaoService {

    @Autowired WalletEntityRepo walletEntityRepo;
    
    public WalletEntity findByUserId(Long userId){
        return walletEntityRepo.findByUserId(userId);
    }
    public WalletEntity save(WalletEntity walletEntity) {
        return walletEntityRepo.save(walletEntity);
    }
    public List<WalletEntity> findAll(int pageSize, int offset) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("id").ascending());
        return walletEntityRepo.findAll(pageable).getContent();
    }
    
    public WalletEntity findById(Long id) throws UserNotFoundException {
        return walletEntityRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
