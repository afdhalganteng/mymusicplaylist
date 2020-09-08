package com.myspotify.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tb_lagu")
public class Lagu extends BaseEntitiy{
	
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
	private Date release;
	
	@Column(name = "duration")
	private String duration;
	
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getRelease() {
		return release;
	}


	public void setRelease(Date release) {
		this.release = release;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}
	
	

}
