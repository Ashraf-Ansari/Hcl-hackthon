package com.hcl.hackathon.hcl.dao;

import com.hcl.hackathon.hcl.repository.CurrencyEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDaoService {

    @Autowired CurrencyEntityRepo currencyEntityRepo;
}
