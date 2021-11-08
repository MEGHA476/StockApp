package com.stock.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CompanyStockexchangemap")
public class Companystockexchangemap {


	@Id
	//@GeneratedValue
	private long id;
	

	private String CompanyCode;
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY)
	private StockExchangeEntity stockexchange;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return CompanyCode;
	}
	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public StockExchangeEntity getStockexchange() {
		return stockexchange;
	}
	public void setStockexchange(StockExchangeEntity stockexchange) {
		this.stockexchange = stockexchange;
	}
	/*public Companystockexchangemap(long id, String companyCode, Company company,
			StockExchangeEntity stockexchange) {
		super();
		this.id = id;
		CompanyCode = companyCode;
		this.company = company;
		this.stockexchange = stockexchange;
	}
	
		public Companystockexchangemap() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	
}