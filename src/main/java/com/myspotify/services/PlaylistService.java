package com.myspotify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspotify.dao.PlaylistDao;
import com.myspotify.model.Playlist;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistDao playlistDao;
	
	
	public void validasiAdd(Playlist playlist) throws Exception {
		if(playlist.getTitle() == null) {
			throw new Exception("Title Must Be Filled");
		}
		if(playlist.getId() != null) {
			throw new Exception("ID Must Be Null");
		}
		
	}
	
	public void validasiEdit(Playlist playlist) throws Exception {
		if(playlist.getTitle() == null) {
			throw new Exception("Title Must Be Filled");
		}
		if(playlist.getId() == null) {
			throw new Exception("ID Cannot Be Null");
		}
		
	}
	public void add(Playlist pl) throws Exception {
		try {
			validasiAdd(pl);
			playlistDao.save(pl);
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void edit(Playlist pl) throws Exception {
		try {
			validasiEdit(pl);
			playlistDao.edit(pl);
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void delete(String id) throws Exception{
		try {
			Playlist pl = playlistDao.getById(id);
			if(pl.getTitle() != null) {
				playlistDao.delete(pl);
			}else {
				throw new Exception("Data Not Found");
			}
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		
	}
	
	public Playlist getById(String id) {
		return playlistDao.getById(id);
	}
	
	public List<Playlist> getAll(){
		return playlistDao.getAll();
	}

}
