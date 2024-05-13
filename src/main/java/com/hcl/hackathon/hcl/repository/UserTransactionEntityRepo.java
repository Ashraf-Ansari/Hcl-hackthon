package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.UserTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionEntityRepo extends JpaRepository<UserTransactionEntity, Long> {

}
