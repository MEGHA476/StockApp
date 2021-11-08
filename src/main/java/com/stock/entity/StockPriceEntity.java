package com.stock.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Stock_price")
public class StockPriceEntity {


	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String Company_Code;
	
	private String Stock_Ex;
	
	private float current_Price;
	
	private Date date;
	
	private Time time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany_Code() {
		return Company_Code;
	}

	public void setCompany_Code(String company_Code) {
		Company_Code = company_Code;
	}

	public String getStock_Ex() {
		return Stock_Ex;
	}

	public void setStock_Ex(String stock_Ex) {
		Stock_Ex = stock_Ex;
	}

	public float getCurrent_Price() {
		return current_Price;
	}

	public void setCurrent_Price(float current_Price) {
		this.current_Price = current_Price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

/*	public StockPriceEntity(long id, String company_Code, String stock_Ex, float current_Price, Date date, Time time) {
		super();
		this.id = id;
		Company_Code = company_Code;
		Stock_Ex = stock_Ex;
		this.current_Price = current_Price;
		this.date = date;
		this.time = time;
		
	}

	public StockPriceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	*/
}
