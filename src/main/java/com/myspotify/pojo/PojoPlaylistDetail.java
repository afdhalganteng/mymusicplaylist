package com.myspotify.pojo;

import java.util.List;

public class PojoPlaylistDetail {
	
	private String title;
	private String id;
	private String description;
	private List<PojoLagu> lagu;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PojoLagu> getLagu() {
		return lagu;
	}

	public void setLagu(List<PojoLagu> lagu) {
		this.lagu = lagu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
