package com.stock.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stockex")
public class StockExchangeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stockid;
	
	@OneToMany(targetEntity = Companystockexchangemap.class)
	private List<Companystockexchangemap> compstockmap;

	public List<Companystockexchangemap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<Companystockexchangemap> compstockmap) {
		this.compstockmap = compstockmap;
	}


	
	@Column(nullable = false)
	private String brief;
	
	public long getId() {
		return stockid;
	}





	public void setId(long id) {
		this.stockid = id;
	}





	public String getBrief() {
		return brief;
	}





	public void setBrief(String brief) {
		this.brief = brief;
	}





	public String getContact_address() {
		return contact_address;
	}





	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}





	public String getStock() {
		return stock;
	}





	public void setStock(String stock) {
		this.stock = stock;
	}





	public String getRemarks() {
		return remarks;
	}





	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}





	@Column(nullable = false)
	private String contact_address;
	
	
	private String stock;
	
	private String remarks;


	public StockExchangeEntity() {
	}

	public StockExchangeEntity(long id, List<Companystockexchangemap> compstockmap, String brief,
			String contact_address, String stock, String remarks) {
		super();
		this.stockid = id;
		this.compstockmap = compstockmap;
		this.brief = brief;
		this.contact_address = contact_address;
		this.stock = stock;
		this.remarks = remarks;
	}
	
	

}
