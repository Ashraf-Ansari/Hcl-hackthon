package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountEntityRepo extends JpaRepository<UserAccountEntity, Long> {

    UserAccountEntity findByUserId(Long userId);
}
