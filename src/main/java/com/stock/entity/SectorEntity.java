package com.stock.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Sectors")
public class SectorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sectid;
	
	private String sector_name;
	
	private String sector_brief;
	
	@OneToMany(mappedBy = "sector")
	@JsonIgnore
	private List<Company> companies = new ArrayList<>();



	public String getSector_brief() {
		return sector_brief;
	}

	public void setSector_brief(String sector_brief) {
		this.sector_brief = sector_brief;
	}

	public long getId() {
		return sectid;
	}

	public void setId(long id) {
		this.sectid = id;
	}

	public String getSector_name() {
		return sector_name;
	}

	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}

	public SectorEntity(long sectid, String sector_name,String sector_brief) {
		super();
		this.sectid = sectid;
		this.sector_name = sector_name;
		this.sector_brief=sector_brief;
	}

	public SectorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
