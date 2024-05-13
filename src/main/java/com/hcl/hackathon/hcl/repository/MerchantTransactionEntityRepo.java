package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.MerchantTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTransactionEntityRepo extends JpaRepository<MerchantTransactionEntity, Long> {

}
