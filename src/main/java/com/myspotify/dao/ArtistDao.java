package com.myspotify.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myspotify.model.Artist;
@Transactional
@Repository("tb_artist")
public class ArtistDao extends BaseDao implements BaseMasterDao {
	
		 
		

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
	public List<Artist> getAllArtist(){
		
		List<Artist> data = em.createQuery("FROM Artist").getResultList();
		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public Artist getArtistById(String id) {
		List<Artist> data = em.createQuery("FROM Artist where id=:id")
							.setParameter("id", id)
							.getResultList();
		return data.isEmpty() ? new Artist() : data.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Artist getArtistByCode(String code) {
		List<Artist> data = em.createQuery("FROM Artist where code=:code")
							.setParameter("code", code)
							.getResultList();
		return data.isEmpty() ? new Artist() : data.get(0);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Artist> getArtistByName(String name) {
		List<Artist> data = em.createQuery("FROM Artist where lower(name) like:name")
							.setParameter("name", "%"+name.toLowerCase()+"%")
							.getResultList();
		return data;
	}
	
}
