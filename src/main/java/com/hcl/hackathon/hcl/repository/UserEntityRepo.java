package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();
}
