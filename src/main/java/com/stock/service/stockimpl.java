package com.stock.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockExchangeEntity;
import com.stock.repo.stockExchangeRepo;

@Service
public class stockimpl implements IStockExcg {

	@Autowired
	stockExchangeRepo repo;
	
	@Override
	public StockExchangeEntity addNewStock(StockExchangeEntity stock) {
		return repo.save(stock);
	}

	@Override
	public List<StockExchangeEntity> listall() {
		return repo.findAll();
	}

	@Override
	public String deleteStock(String stock) {
		StockExchangeEntity stk=repo.findBystock(stock);
      repo.delete(stk);
      return "deleted";
	}
	
	 public void save(MultipartFile file) {
		    try {
		      List<StockExchangeEntity> stocks = ExcelHelper.excelToimportdata(file.getInputStream());
		      repo.saveAll(stocks);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }
	
}
	


