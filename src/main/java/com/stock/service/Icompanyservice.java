package com.stock.service;

import org.springframework.stereotype.Service;

import com.stock.entity.Company;
import com.stock.repo.companystockexRepo;

@Service
public interface Icompanyservice {
	
	public Company addcompany(Company company);
	public Company updatecompany(Company company);
	public String deactivate(long id);


}
