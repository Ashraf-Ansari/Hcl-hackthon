package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.hcl.entity.UserEntity;
import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {

    @Autowired UserEntityRepo userEntityRepo;
    
    public List<UserEntity> findAll(int pageSize, int offset) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("id").ascending());
        return userEntityRepo.findAll(pageable).getContent();
    }
    
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepo.save(userEntity);
    }
    
    public UserEntity findById(Long id) throws UserNotFoundException {
        return userEntityRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
