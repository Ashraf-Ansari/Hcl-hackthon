package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletEntityRepo extends JpaRepository<WalletEntity, Long>{

    WalletEntity findByUserId(Long userId);
}
