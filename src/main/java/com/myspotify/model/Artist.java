package com.myspotify.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tb_artist")
public class Artist extends BaseEntitiy {

	@Column(name = "code",nullable = false,unique = true)
	private String code;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	
	@Column(name = "debut_date",nullable = true)
	private Date tanggalDebut;
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getTanggalDebut() {
		return tanggalDebut;
	}


	public void setTanggalDebut(Date tanggalDebut) {
		this.tanggalDebut = tanggalDebut;
	}
	
	
	
}
