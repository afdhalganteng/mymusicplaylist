package com.myspotify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspotify.dao.ArtistDao;
import com.myspotify.model.Artist;

@Service
public class ArtistService {
	@Autowired
	private ArtistDao artisDao;
	
	
	public void validasiAdd(Artist artist) throws Exception {
		Artist artist2 = artisDao.getArtistByCode(artist.getCode());
		if(artist2.getCode() != null) {
			throw new Exception("Code Is Contain");
		}
		if(artist.getCode() == null) {
			throw new Exception("Code Must Be Filled");
		}
		if(artist.getName() == null) {
			throw new Exception("Name Must Be Filled");
		}
		if(artist.getId() != null) {
			throw new Exception("ID Must Be Null");
		}
	}
	public void validasiEdit(Artist artist) throws Exception {
		Artist oldArtist = artisDao.getArtistById(artist.getId());
		if(artist.getId() == null) {
			throw new Exception("ID Cannot Be Null");
		}
		if(!oldArtist.getCode().equals(artist.getCode())) {
			throw new Exception("Code Not Be Changed");
		}
		if(artist.getName() == null) {
			throw new Exception("Name Must Be Filled");
		}
	}
	
	public void add(Artist artist) throws Exception {
		try {
			validasiAdd(artist);
			artisDao.save(artist);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void edit(Artist artist) throws Exception {
		try {
			
			validasiEdit(artist);
			artisDao.edit(artist);
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void deleteArtist(String id) throws Exception {
		
		try {
			Artist artist = artisDao.getArtistById(id);
			if(artist.getCode() != null) {
				artisDao.delete(artist);
				
			}
			else {
				throw new Exception("Data not Find");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public List<Artist> getAll(){
		return artisDao.getAllArtist();
	}
	
	public List<Artist> getArtistByName(String name){
		return artisDao.getArtistByName(name);
	}
	
	
	public Artist getArtistbyId(String id) {
		return artisDao.getArtistById(id);
	}

}
