package com.myspotify.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao {
	
	@PersistenceContext
	protected EntityManager em;

}
