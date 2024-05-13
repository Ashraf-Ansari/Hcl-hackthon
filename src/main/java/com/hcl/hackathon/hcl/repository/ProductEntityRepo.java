package com.hcl.hackathon.hcl.repository;

import com.hcl.hackathon.hcl.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepo extends JpaRepository<ProductEntity, Long> {

}
