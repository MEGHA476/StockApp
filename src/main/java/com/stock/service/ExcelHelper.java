package com.stock.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockExchangeEntity;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "stockid", "brief", "contact_address", "remarks","stock" };
	  static String SHEET = "sheet";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<StockExchangeEntity> excelToimportdata(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
	      Iterator<Row> rows = sheet.iterator();

	      List<StockExchangeEntity> stocks = new ArrayList<StockExchangeEntity>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        StockExchangeEntity stock = new StockExchangeEntity();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();

	          switch (cellIdx) {
	          case 0:
	            stock.setId((long) currentCell.getNumericCellValue());
	            break;

	          case 1:
	            stock.setBrief(currentCell.getStringCellValue());
	            break;

	          case 2:
	            stock.setContact_address(currentCell.getStringCellValue());
	            break;

	          case 3:
	            stock.setRemarks(currentCell.getStringCellValue());
	            break;
	            
	          case 4:
	        	  stock.setStock(currentCell.getStringCellValue());
	            break;

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        stocks.add(stock);
	      }

	      workbook.close();

	      return stocks;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }

}
