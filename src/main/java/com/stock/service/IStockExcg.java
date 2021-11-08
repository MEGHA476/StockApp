package com.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockExchangeEntity;

@Service
public interface IStockExcg {
	
	public StockExchangeEntity addNewStock(StockExchangeEntity stock);
	public List<StockExchangeEntity> listall();
	public String deleteStock(String stock);
	public void save(MultipartFile file);

}
