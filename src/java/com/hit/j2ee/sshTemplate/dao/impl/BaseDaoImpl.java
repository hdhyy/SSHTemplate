package com.hit.j2ee.sshTemplate.dao.impl;

import java.io.Serializable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hit.j2ee.sshTemplate.common.utils.ReflectionUtils;
import com.hit.j2ee.sshTemplate.dao.BaseDao;


//继承Spring的hibernate实现类，将hibernate交给Spring管理
@Repository("baseDao")
public class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PK> {

	private Class<?> entityClass = ReflectionUtils.getSuperClassGenricType(this.getClass());

	// 注入spring容器中的SessionFactory实例
	@Resource(name = "sessionFactory")
	public void setSessionFactory4Spring(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;

	}

	private Session getCurrentSession() {

		return super.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(PK id) {
		return (T) this.getCurrentSession().load(entityClass.getClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		return (T) this.getCurrentSession().get(entityClass.getClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.findByCondition(null, null, null, false);
	}

	@Override
	public void persist(T entity) {
		this.getHibernateTemplate().persist(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T entity) {
		return (PK)this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);

	}

	@Override
	public void delete(PK id) {
		Object entity = this.getHibernateTemplate().get(entityClass,id);
		if(entity != null){
			this.getHibernateTemplate().delete(entity);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteByIds(PK... ids) {
		if(ids != null && ids.length >0){
			for(PK id:ids){
				Object entity = this.getHibernateTemplate().get(entityClass,id);
				if(entity != null){
					this.getHibernateTemplate().delete(entity);
				}
			}
		}

	}

	@Override
	public void deleteAll(Collection<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);

	}

	@Override
	public void flush() {
		this.getHibernateTemplate().flush();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		
		return (T)this.getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findByCondition(String whereHql, Object[] params, Map<String, String> orderBy, boolean cacheable) {
		// 方便其他方法调用，设置永远为真的条件
		String hql = "select o from " + entityClass.getSimpleName() + " o where 1=1 ";

		if (StringUtils.isNotBlank(whereHql)) {
			hql += whereHql;
		}
		// 根据参数构造orderby字符串
		String orderByStr = this.buildOrderBy(orderBy);
		hql += orderByStr;
		final String _hql = hql;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(_hql);
				if (cacheable) {
					query.setCacheable(true);
				}
				setParams(query, params);
				return query.list();
			}
		});
		return list;
	}

	private void setParams(Query query, Object[] params) {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	}

	private String buildOrderBy(Map<String, String> orderBy) {

		StringBuffer buf = new StringBuffer();
		if (orderBy != null && !orderBy.isEmpty()) {
			buf.append(" order by ");
			for (Map.Entry<String, String> em : orderBy.entrySet()) {
				buf.append(em.getKey() + " " + em.getValue() + ",");
			}
			buf.deleteCharAt(buf.length() - 1);
		}
		return buf.toString();
	}

	@Override
	public List<T> findByCondition(String whereHql, Object[] params, boolean cacheable) {

		return this.findByCondition(whereHql, params, null, cacheable);
	}

	@Override
	public List<T> findAll(boolean cacheable) {
		return this.findByCondition(null, null, null, cacheable);
	}

	@Override
	public T findFirstByCondition(String whereHql, Object[] params, boolean cacheable) {

		List<T> list = this.findByCondition(whereHql, params, cacheable);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findByConditionWithPaging(String whereHql, Object[] params, Map<String, String> orderBy, int offset,
			int length) {
		// 方便其他方法调用，设置永远为真的条件
		String hql = "select o from " + entityClass.getSimpleName() + " o where 1=1 ";

		if (StringUtils.isNotBlank(whereHql)) {
			hql += whereHql;
		}
		// 根据参数构造orderby字符串
		String orderByStr = this.buildOrderBy(orderBy);
		hql += orderByStr;
		final String _hql = hql;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(_hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				setParams(query, params);
				return query.list();
			}
		});
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int getRowCount(String whereHql, Object[] params) {
		// 方便其他方法调用，设置永远为真的条件
		String hql = "select count(*) from " + entityClass.getSimpleName() + " o where 1=1 ";

		if (StringUtils.isNotBlank(whereHql)) {
			hql += whereHql;
		}
		final String _hql = hql;
		long count = (long) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(_hql);

				setParams(query, params);
				return query.uniqueResult();
			}
		});
		return (int)count;
	}

	@Override
	public List<T> findByCondition(Map<String, String> orderBy, boolean cacheable) {

		return this.findByCondition(null, null, orderBy, cacheable);
	}

}
