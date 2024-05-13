package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.MerchantAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantAccountEntityRepo extends JpaRepository<MerchantAccountEntity, Long> {

}
