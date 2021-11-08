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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockExchangeEntity;
import com.stock.service.ExcelHelper;
import com.stock.service.IStockExcg;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stock")
@Transactional
public class StockController {
	
	@Autowired
	IStockExcg stockService;
	
	@PostMapping(value = "/addStock")
	public ResponseEntity<String> addAccount( @RequestBody StockExchangeEntity stock){
		stockService.addNewStock(stock);
		return new ResponseEntity<>("Stock added", HttpStatus.OK);	
	}
	
	@GetMapping(value = "/listall")
	public List<StockExchangeEntity> listall(){
		return stockService.listall();
	}
	
	@DeleteMapping(value="/delete/{stock}")
	public String deleteByStock(@PathVariable String stock) {
		 stockService.deleteStock(stock);
		 return "deleted";
}
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile( MultipartFile file) {
	    String message = "";
	    stockService.save(file);
	    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    /*if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	        stockService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + " !";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));*/
	  }

}
