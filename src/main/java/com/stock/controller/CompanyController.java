package com.stock.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Company;
import com.stock.repo.CompanyRepo;
import com.stock.service.Icompanyservice;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/company")
@Transactional
public class CompanyController {
	
	@Autowired
	Icompanyservice service;
	
	@Autowired
	CompanyRepo repo;
	
	
	@PostMapping(value = "/addcomp")
	public ResponseEntity<String> addcompany( @RequestBody Company company){
		service.addcompany(company);
		return new ResponseEntity<>("company added", HttpStatus.OK);	
	}
	
	@PutMapping(value="/updatecomp")
	public ResponseEntity<String> updatecompany( @RequestBody Company comp)
	{
		service.updatecompany(comp);
		return new ResponseEntity<>("company updated", HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public String deletebyid(@PathVariable int id) {
		 service.deactivate(id);
		 return "deleted";
}
	
	@GetMapping(value = "/list")
	public List<Company> listall(){
		return repo.findAll();
	}

}
