package com.hit.j2ee.sshTemplate.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

import com.hit.j2ee.sshTemplate.dao.BaseDao;
import com.hit.j2ee.sshTemplate.service.BaseService;

@Service("baseService")//没有指定value的话，默认是第一个字母小写的类名,可以看做是xml中的bean的id
public class BaseServiceImpl<T, PK extends Serializable,BD extends BaseDao<T,PK>> implements BaseService<T, PK> {

	protected BD baseDao;

	protected Class<?> clazz;//存储了具体操作的类,

	protected void setClazz(Class<?> clazz){
		this.clazz = clazz;
	}
	
	@Override
	public T load(PK id) {
		return (T) baseDao.load(id);
	}

	@Override
	public T get(PK id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public void persist(T entity) {
		baseDao.persist(entity);
	}

	@Override
	public PK save(T entity) {
		return (PK) baseDao.save(entity);
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(PK id) {
		baseDao.delete(id);
	}

	@Override
	public void flush() {
		baseDao.flush();
	}

}
