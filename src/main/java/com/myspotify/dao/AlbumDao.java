package com.myspotify.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myspotify.model.Album;

@Repository("tb_album")
@Transactional
public class AlbumDao extends BaseDao implements BaseMasterDao {

	@Override
	public <T> void save(T entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		
	}

	@Override
	public <T> void edit(T entity) throws Exception {
		// TODO Auto-generated method stu
		em.merge(entity);
		
	}

	@Override
	public <T> void delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(entity);
		
	}
	
	@SuppressWarnings("unchecked")
	public Album getById(String id) {
		List<Album> album = em.createQuery("FROM Album where id=:id")
							.setParameter("id", id)
							.getResultList();
		
		return album.isEmpty() ? new Album() : album.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Album getByCode(String code) {
		List<Album> album = em.createQuery("FROM Album where code=:code")
							.setParameter("code", code)
							.getResultList();
		
		return album.isEmpty() ? new Album() : album.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> getAlbumByName(String album) {
		List<Album> data = em.createQuery("FROM Album where lower(album) like:album")
							.setParameter("album", "%"+album.toLowerCase()+"%")
							.getResultList();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAlbumByArtistName(String name) {
		List<Object[]> data = em.createNativeQuery("select ar.name ,ta.album ,ta.release_date,ta.id \r\n" + 
				"from tb_album ta join tb_artist ar on ar.id = ta.artist_id\r\n" + 
				"where lower(ar.name) like :name")
							.setParameter("name", "%"+name.toLowerCase()+"%")
							.getResultList();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> getAlbumAll() {
		List<Album> data = em.createQuery("FROM Album")
							.getResultList();
		return data;
	}


}
