package com.myspotify.pojo;

import java.util.Date;

public class PojoAlbum {
	
	private String id;
	private String album;
	private Date releaseDate;
	private String artist;
	
	public String getAlbum() {
		return album;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	

}
