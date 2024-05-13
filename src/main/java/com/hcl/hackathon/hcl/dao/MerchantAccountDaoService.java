package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.devlopment.exception.UserNotFoundException;
import com.hcl.hackathon.hcl.entity.MerchantAccountEntity;
import com.hcl.hackathon.hcl.repository.MerchantAccountEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantAccountDaoService {

    @Autowired MerchantAccountEntityRepo merchantAccountEntityRepo;
    
    public List<MerchantAccountEntity> findAll(int pageSize, int offset) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("id").ascending());
        return merchantAccountEntityRepo.findAll(pageable).getContent();
    }
    
    public MerchantAccountEntity save(MerchantAccountEntity userEntity) {
        return merchantAccountEntityRepo.save(userEntity);
    }
    
    public MerchantAccountEntity findById(Long id) throws UserNotFoundException {
        return merchantAccountEntityRepo.findById(id).orElseThrow(() -> new UserNotFoundException("merchant account not found with id: " + id));
    }
}
