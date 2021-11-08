package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.StockPriceEntity;


@Repository
public interface stockpriceRepo extends JpaRepository<StockPriceEntity, Long>{

}
