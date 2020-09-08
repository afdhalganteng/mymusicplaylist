package com.myspotify.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspotify.dao.AlbumDao;
import com.myspotify.dao.LaguDao;
import com.myspotify.model.Album;
import com.myspotify.model.Lagu;
import com.myspotify.pojo.PojoLagu;

@Service
public class LaguService {
	
	@Autowired
	private LaguDao laguDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	
	public void validasiAdd(Lagu lagu) throws Exception{
		if(lagu.getId() != null) {
			throw new Exception("ID Must Be Null");
		}
		if(lagu.getTitle() == null) {
			throw new Exception("Title cannot be null");
		}
		Album album = albumDao.getById(lagu.getAlbum().getId());
		if(album.getCode() == null) {
			throw new Exception("Album not Find");
		}
		
	}
	public void validasiEdit(Lagu lagu) throws Exception{
		if(lagu.getId() == null) {
			throw new Exception("ID Cannot Be Null");
		}
		if(lagu.getTitle() == null) {
			throw new Exception("Title cannot be null");
		}
		
		Album album = albumDao.getById(lagu.getId());
		if(album.getCode() == null) {
			throw new Exception("Album not Find");
		}
		
	}
	
	public void edit(Lagu lagu) throws Exception{
		try {
			
			validasiEdit(lagu);
			laguDao.edit(lagu);
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	public void add(Lagu lagu) throws Exception {
		try {
			validasiAdd(lagu);
			albumDao.save(lagu);
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void delete(String id)  throws Exception{
	try {
		Lagu lg = laguDao.getLaguById(id);
		if(lg.getTitle() != null) {
			laguDao.delete(lg);
		}
		else {
			throw new Exception("Data Not Found");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}	
	}
	
	public Lagu getById(String id) {
		return laguDao.getLaguById(id);
	}
	
	public List<Lagu> getLagubyTitle(String title){
		return laguDao.getLagubyTitle(title);
	}
	
	public List<Lagu> getAll(){
		return laguDao.getLaguAll();
	}
	
	public List<PojoLagu> getLagubyArtistName(String name){
		List<PojoLagu> lagu = new ArrayList<PojoLagu>();
		
		for(Object[] o : laguDao.getLaguByArtistName(name)) {
			PojoLagu pj = new PojoLagu();
			pj.setId((String)o[0]);
			pj.setArtist((String)o[1]);
			pj.setAlbum((String)o[2]);
			pj.setRelease((Date)o[3]);
			pj.setDuration((String)o[4]);
			pj.setTitle((String)o[5]);
			lagu.add(pj);
		}
		
		return lagu;
	}

}
