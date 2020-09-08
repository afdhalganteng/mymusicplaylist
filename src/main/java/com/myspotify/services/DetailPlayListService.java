package com.myspotify.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspotify.dao.DetailPlaylistDao;
import com.myspotify.model.DetailPlaylist;
import com.myspotify.model.Lagu;
import com.myspotify.model.Playlist;
import com.myspotify.pojo.PojoLagu;
import com.myspotify.pojo.PojoPlaylistDetail;

@Service
public class DetailPlayListService {
	
	
	@Autowired
	private DetailPlaylistDao detailDao;
	
	@Autowired
	private PlaylistService plService;
	
	
	@Autowired
	private LaguService laguService;
	public void validasiAdd(DetailPlaylist dtl) throws Exception {
		Playlist pl = plService.getById(dtl.getPlaylist().getId());
		Lagu lg = laguService.getById(dtl.getLagu().getId());
		if(dtl.getId() != null) {
			throw new Exception("ID Must Be Null");
			
		}
		if(pl.getTitle() == null) {
			throw new Exception("PlayList not Found");
			
		}
		
		if(lg.getTitle() == null) {
			throw new Exception("Lagu not Found");
			
		}
		
	}
	
	public void validasiEdit(DetailPlaylist dtl) throws Exception {
		Playlist pl = plService.getById(dtl.getPlaylist().getId());
		Lagu lg = laguService.getById(dtl.getLagu().getId());
		if(dtl.getId() == null) {
			throw new Exception("ID Cannot be Null");
			
		}
		if(pl.getTitle() == null) {
			throw new Exception("PlayList not Found");
			
		}
		
		if(lg.getTitle() == null) {
			throw new Exception("Lagu not Found");
			
		}
		
	}
	
	public void add(DetailPlaylist dtl) throws Exception {
		try {
			validasiAdd(dtl);
			detailDao.save(dtl);
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	
	
	public void edit(DetailPlaylist dtl) throws Exception {
		try {
			validasiEdit(dtl);
			detailDao.edit(dtl);
			
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	public void delete(String id) throws Exception{
		try {
			DetailPlaylist dtl = detailDao.getById(id);
			if(dtl.getLagu() != null) {
				detailDao.delete(dtl);
			}else {
				throw new Exception("Data not Found");
			}
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}
	public PojoPlaylistDetail getPlaylistDetail(String id) {
		PojoPlaylistDetail pojo = new PojoPlaylistDetail();
		List<PojoLagu> song = new ArrayList<PojoLagu>();
		for(Object[] o:detailDao.getAllSongfromPlayList(id)) {
			pojo.setTitle((String)o[6]);
			pojo.setDescription((String)o[7]);
			pojo.setId((String)o[0]);
			PojoLagu pj = new PojoLagu();
			pj.setId((String)o[8]);
			pj.setArtist((String)o[5]);
			pj.setAlbum((String)o[1]);
			pj.setRelease((Date)o[3]);
			pj.setDuration((String)o[4]);
			pj.setTitle((String)o[2]);
			song.add(pj);
		}
		pojo.setLagu(song);
		
		return pojo;
	}
	

}
