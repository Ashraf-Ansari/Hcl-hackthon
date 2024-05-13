package com.hcl.hackathon.hcl.service;

import com.hcl.hackathon.hcl.dao.UserDaoService;
import com.hcl.hackathon.hcl.entity.UserEntity;
import com.hcl.hackathon.devlopment.exception.ApiResponse;
import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class UserService {

    @Autowired UserDaoService userDaoService;
    
    public ResponseEntity<Object> findAll(int pageSize, int offset) {
        List<UserEntity> userEntities =  userDaoService.findAll(pageSize, offset);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, userEntities), HttpStatus.OK);
    }
    
    public ResponseEntity<Object> save(UserEntity userEntity) {
        UserEntity user = userDaoService.save(userEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        ApiResponse apiResponse = new ApiResponse(HttpStatus.CREATED, location.toString());
        return ResponseEntity.created(location).body(apiResponse);
    }
    
    public ResponseEntity<Object> findById(Long id) throws UserNotFoundException {
        UserEntity user = userDaoService.findById(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, user), HttpStatus.OK);
    }
    
}
