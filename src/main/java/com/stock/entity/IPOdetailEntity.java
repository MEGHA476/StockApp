package com.stock.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="IPO_details")
public class IPOdetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ipoid;
	
	private String company_name;
	
	private String stock_ex;
	
	private float price_per_stock;
	
	private int num_of_stocks;
	
	
	
	private String remarks;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="c_name")
	private Company company;

	@ManyToMany
	@JoinColumn(name="stock")
	private List<StockExchangeEntity> stockExchanges = new ArrayList<>();


	public long getId() {
		return ipoid;
	}

	public void setId(long id) {
		this.ipoid = id;
	}

	public String getCompanyname() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getStock_ex() {
		return stock_ex;
	}

	public void setStock_ex(String stock_ex) {
		this.stock_ex = stock_ex;
	}

	public float getPrice_per_stock() {
		return price_per_stock;
	}

	public void setPrice_per_stock(float price_per_stock) {
		this.price_per_stock = price_per_stock;
	}

	public int getNum_of_stocks() {
		return num_of_stocks;
	}

	public void setNum_of_stocks(int num_of_stocks) {
		this.num_of_stocks = num_of_stocks;
	}


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
		public IPOdetailEntity(long ipoid, String companyname, String stock_ex, float price_per_stock, int num_of_stocks,
			 String remarks) {
		super();
		this.ipoid = ipoid;
		this.company_name = companyname;
		this.stock_ex = stock_ex;
		this.price_per_stock = price_per_stock;
		this.num_of_stocks = num_of_stocks;
		this.remarks = remarks;
	}

	public long getIpoid() {
			return ipoid;
		}

		public void setIpoid(long ipoid) {
			this.ipoid = ipoid;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public List<StockExchangeEntity> getStockExchanges() {
			return stockExchanges;
		}

		public void setStockExchanges(List<StockExchangeEntity> stockExchanges) {
			this.stockExchanges = stockExchanges;
		}

	public IPOdetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
