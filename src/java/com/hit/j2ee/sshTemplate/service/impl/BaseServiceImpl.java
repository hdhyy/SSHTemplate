package com.hit.j2ee.sshTemplate.service.impl;

import java.io.Serializable;
import java.util.List;

import com.hit.j2ee.sshTemplate.service.BaseService;

public class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T, PK>{

	@Override
	public T load(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PK save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

}
