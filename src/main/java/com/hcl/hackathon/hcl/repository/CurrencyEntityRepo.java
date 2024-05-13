package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyEntityRepo extends JpaRepository<CurrencyEntity, Long> {

     public CurrencyEntity findByCurrencyCode(String currencyCode);
     
}
