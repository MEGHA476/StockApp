package com.stock.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.IPOdetailEntity;
import com.stock.repo.IpodetailRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ipo")
@Transactional
public class IpoController {
	
	@Autowired
	IpodetailRepo repo;
	
	@PostMapping(value = "/addipo")
	public ResponseEntity<String> addipo( @RequestBody IPOdetailEntity ipo){
		repo.save(ipo);
		return new ResponseEntity<>("ipo added", HttpStatus.OK);	
	}
	

}
