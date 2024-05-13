package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.ProductEntity;
import com.hcl.hackathon.hcl.repository.ProductEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoService {

    @Autowired ProductEntityRepo productEntityRepo;
    
    public List<ProductEntity> findAll(int pageSize, int offset) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("id").ascending());
        return productEntityRepo.findAll(pageable).getContent();
    }
    
    public ProductEntity save(ProductEntity userEntity) {
        return productEntityRepo.save(userEntity);
    }
    
    public ProductEntity findById(Long id) throws UserNotFoundException {
        return productEntityRepo.findById(id).orElseThrow(() -> new UserNotFoundException("product not found with id: " + id));
    }
}
