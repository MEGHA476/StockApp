package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.Company;
import com.stock.exception.IdNotFoundException;
import com.stock.repo.CompanyRepo;

@Service
public class CompService implements Icompanyservice{

	@Autowired
	CompanyRepo repo;
	
	@Override
	public Company addcompany(Company company) {
		return repo.save(company);
	}
	

	@Override
	public Company updatecompany(Company company) {
		
		long id=company.getId();
		System.out.println(id);
		if(repo.existsById(id))
		{
			repo.save(company);
			return company;
		}
		else
			throw new IdNotFoundException();
    		
	}

	@Override
	public String deactivate(long id) {
		
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return "Deactivated";
		}
		else
			throw new IdNotFoundException();
    		
	}

	

}
