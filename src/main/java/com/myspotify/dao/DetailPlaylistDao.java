package com.myspotify.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myspotify.model.DetailPlaylist;

@Repository("tb_detail_playlist")
@Transactional
public class DetailPlaylistDao extends BaseDao implements BaseMasterDao{
	@Override
	public <T> void save(T entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		
	}

	@Override
	public <T> void edit(T entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		
	}

	@Override
	public <T> void delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(entity);
		
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllSongfromPlayList(String id){
		
		List<Object[]> data = em.createNativeQuery("select tdp.id,ta.album,tl.title as lagu_title,tl.release_date,tl.duration,ar.name,pl.title ,pl.description,tl.id as lagu_id \r\n" + 
				"from tb_detail_playlist tdp join tb_playlist pl on pl.id = tdp.playlist_id \r\n" + 
				"join tb_lagu tl on tl.id = tdp.lagu_id\r\n" + 
				"join tb_album ta on ta.id = tl.album_id \r\n" + 
				"join tb_artist ar on ta.artist_id = ar.id\r\n" + 
				"where pl.id = :id")
				.setParameter("id", id)
				.getResultList();
		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public DetailPlaylist getById(String id) {
		
		List<DetailPlaylist> dtl = em.createQuery("FROM DetailPlaylist where id=:id")
									.setParameter("id", id)
									.getResultList();
		
		return dtl.isEmpty() ? new DetailPlaylist() : dtl.get(0);
		
	}
}
