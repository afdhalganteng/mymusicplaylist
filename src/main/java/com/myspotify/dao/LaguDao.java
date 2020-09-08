package com.myspotify.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myspotify.model.Lagu;


@Repository("tb_lagu")
@Transactional
public class LaguDao extends BaseDao implements BaseMasterDao{
	
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
	public Lagu getLaguById(String id) {
		List<Lagu> lagu = em.createQuery("FROM Lagu where id=:id")
							.setParameter("id",id)
							.getResultList();
		
		return lagu.isEmpty() ? new Lagu() : lagu.get(0);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Lagu> getLaguAll() {
		List<Lagu> lagu = em.createQuery("FROM Lagu")
							.getResultList();
		
		return lagu;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lagu> getLagubyTitle(String title) {
		List<Lagu> lagu = em.createQuery("FROM Lagu where lower(title) like :title ")
							.setParameter("title","%"+title.toLowerCase()+"%")
							.getResultList();
		
		return lagu;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getLaguByArtistName(String name){
		List<Object[]> lagu = em.createNativeQuery("select tl.id ,ar.\"name\",ta.album,tl.release_date,tl.duration,tl.title \r\n" + 
				"from tb_lagu tl join tb_album ta on tl.album_id = ta.id \r\n" + 
				"join tb_artist ar on ar.id = ta.artist_id\r\n" + 
				"where lower(ar.name) like :name")
				.setParameter("name", "%"+name.toLowerCase()+"%")
				.getResultList();
		
		return lagu;
	}

}
