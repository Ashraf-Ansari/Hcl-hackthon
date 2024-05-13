package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.UserAccountEntity;
import com.hcl.hackathon.hcl.repository.UserAccountEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountDaoService {

    @Autowired UserAccountEntityRepo userAccountEntityRepo;
    
    public List<UserAccountEntity> findAll(int pageSize, int offset) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("id").ascending());
        return userAccountEntityRepo.findAll(pageable).getContent();
    }
    
    public UserAccountEntity save(UserAccountEntity userEntity) {
        return userAccountEntityRepo.save(userEntity);
    }
    
    public UserAccountEntity findById(Long id) throws UserNotFoundException {
        return userAccountEntityRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User account not found with id: " + id));
    }
    public UserAccountEntity findByUserId(Long userId){
        return userAccountEntityRepo.findByUserId(userId);
    }
}
