package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="medium_format")
public class MediumFormat  {

	@Column(name = "NAME")
	private String name; 
	@Column(name = "YEAR")
	private String year; 
	
	public MediumFormat() { 
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
