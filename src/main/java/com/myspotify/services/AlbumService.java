package com.myspotify.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspotify.dao.AlbumDao;
import com.myspotify.model.Album;
import com.myspotify.model.Artist;
import com.myspotify.pojo.PojoAlbum;

@Service
public class AlbumService {

	@Autowired 
	private AlbumDao albumDao;
	
	@Autowired
	private ArtistService artisService;
	
	public void validasiAdd(Album album) throws Exception {
		Artist artist = artisService.getArtistbyId(album.getArtist().getId());
		Album albumOld = albumDao.getByCode(album.getCode());
		if(artist.getCode() == null) {
			throw new Exception("Artist Not Find");
		}
		if(album.getCode() == null) {
			throw new Exception("Code Cannot be Null");
		}
		if(albumOld.getCode() != null) {
			throw new Exception("Code is Exist");
		}
		if(album.getId() != null) {
			throw new Exception("ID Must Be Null");
		}
		if(album.getAlbum() == null) {
			throw new Exception("Album Name Must Be Filled");
		}
		
	}
	
	public void add(Album album) throws Exception{
		try {
			validasiAdd(album);
			albumDao.save(album);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public void edit(Album album) throws Exception{
		try {
			validasiEdit(album);
			albumDao.edit(album);
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	public void validasiEdit(Album album) throws Exception {
		Album oldAlbum = albumDao.getById(album.getId());
		if(album.getId() == null) {
			throw new Exception("ID Cannot Be Null");
		}
		if(!oldAlbum.getCode().equals(album.getCode())) {
			throw new Exception("Code Cannot be changed");
		}
		if(album.getAlbum() == null) {
			throw new Exception("Album Name Must Be Filled");
		}
		
		
	}
	
	public Album getAlbumbyId(String id) {
		return albumDao.getById(id);
	}
	
	public void delete(String id) throws Exception{
		Album album = albumDao.getById(id);
		if(album.getCode() != null) {
			albumDao.delete(album);
		}else {
			throw new Exception("Data Not Found");
		}
	}
	
	public List<Album> getAlbumByName(String album){
		return albumDao.getAlbumByName(album);
	}
	
	public List<PojoAlbum> getAlbumByArtistName(String name){
		List<PojoAlbum> rtData = new ArrayList<PojoAlbum>();
		for(Object[] o:albumDao.getAlbumByArtistName(name)) {
			PojoAlbum pj = new PojoAlbum();
			pj.setAlbum((String)o[1]);
			pj.setArtist((String)o[0]);
			pj.setReleaseDate((Date)o[2]);
			pj.setId((String)o[3]);
			rtData.add(pj);
		}
		return rtData;
	}
	public List<PojoAlbum> getAlbumByArtistNameandAlbum(String album,String name){
		List<PojoAlbum> rtData = new ArrayList<PojoAlbum>();
		for(Object[] o:albumDao.getAlbumByArtistandName(album, name)) {
			PojoAlbum pj = new PojoAlbum();
			pj.setAlbum((String)o[1]);
			pj.setArtist((String)o[0]);
			pj.setReleaseDate((Date)o[2]);
			pj.setId((String)o[3]);
			rtData.add(pj);
		}
		return rtData;
	}
	
	public List<Album> getAll(){
		return albumDao.getAlbumAll();
	}
	
}
