package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Company;


@Repository
public interface CompanyRepo extends JpaRepository<Company, Long>{

}
