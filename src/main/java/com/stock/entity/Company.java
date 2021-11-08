package com.stock.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String cname;
	
	private float turnover;

	private String ceo;

	private String bodir;
	
	private String stockcode;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE)
	@JoinColumn(name="ipoid")
	private IPOdetailEntity ipo;
	
	@OneToMany(targetEntity = StockExchangeEntity.class)
	private List<Companystockexchangemap> compstockmap;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private SectorEntity sector;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBodir() {
		return bodir;
	}

	public void setBodir(String bodir) {
		this.bodir = bodir;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public IPOdetailEntity getIpo() {
		return ipo;
	}

	public void setIpo(IPOdetailEntity ipo) {
		this.ipo = ipo;
	}

	public List<Companystockexchangemap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<Companystockexchangemap> compstockmap) {
		this.compstockmap = compstockmap;
	}

	public SectorEntity getSector() {
		return sector;
	}

	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
