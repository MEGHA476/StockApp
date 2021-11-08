package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.IPOdetailEntity;



@Repository
public interface IpodetailRepo extends JpaRepository<IPOdetailEntity, Long>{
 
}
