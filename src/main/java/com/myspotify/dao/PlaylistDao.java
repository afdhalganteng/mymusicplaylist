package com.myspotify.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myspotify.model.Playlist;

@Repository("tb_playlist")
@Transactional
public class PlaylistDao extends BaseDao implements BaseMasterDao{
	
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
	public Playlist getById(String id) {
		
		List<Playlist> data = em.createQuery("FROM Playlist where id=:id")
							.setParameter("id", id)
							.getResultList();
		
		return data.isEmpty() ? new Playlist() : data.get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Playlist> getAll(){
		
		List<Playlist> data = em.createQuery("FROM Playlist")
				.getResultList();
		
		return data;
		
	}

}
