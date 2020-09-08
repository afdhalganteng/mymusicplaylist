package com.myspotify.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_detail_playlist",uniqueConstraints = @UniqueConstraint(columnNames = {"lagu_id","playlist_id"}))
public class DetailPlaylist extends BaseEntitiy {
	
	@ManyToOne
	@JoinColumn(name = "lagu_id",referencedColumnName = "id")
	private Lagu lagu;
	
	@ManyToOne
	@JoinColumn(name = "playlist_id",referencedColumnName = "id")
	private Playlist playlist;

	public Lagu getLagu() {
		return lagu;
	}

	public void setLagu(Lagu lagu) {
		this.lagu = lagu;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	
	
}
