package com.myspotify.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_album")
public class Album extends BaseEntitiy{
	
	
	@Column(name = "code",unique = true,nullable = false)
	private String code;
	
	@Column(name = "album",nullable = false)
	private String album;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
	
	
}
