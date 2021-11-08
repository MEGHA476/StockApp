package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.StockExchangeEntity;


@Repository
public interface stockExchangeRepo extends JpaRepository<StockExchangeEntity, Long> {

	public StockExchangeEntity findBystock(String stock);
	
}
