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

import com.stock.entity.SectorEntity;
import com.stock.repo.SectorRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sector")
@Transactional
public class SectorController {
	
	@Autowired
	SectorRepo repo;
	
	@PostMapping(value = "/addsector")
	public ResponseEntity<String> addsector( @RequestBody SectorEntity sector){
		repo.save(sector);
		return new ResponseEntity<>("sector added", HttpStatus.OK);	
	}
	

}
