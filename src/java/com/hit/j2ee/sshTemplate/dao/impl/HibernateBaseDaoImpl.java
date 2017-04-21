package com.hit.j2ee.sshTemplate.dao.impl;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.ComponentType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.hit.j2ee.sshTemplate.common.log.Logs;
import com.hit.j2ee.sshTemplate.common.utils.*;
import com.hit.j2ee.sshTemplate.dao.HibernateBaseDao;

import com.hit.j2ee.sshTemplate.common.utils.ReflectionUtils;

import javax.annotation.Resource;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Repository("hbaseDao")
public class HibernateBaseDaoImpl<T, PK extends Serializable>  implements HibernateBaseDao<T, PK> {


    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;


    /**
     * <p>用于Dao层子类使用的构造函数</p>
     * <p>通过子类的泛型定义取得对象类型Class.</p>
     * <p>eg.</p>
     * <p>public class UserDao extends HibernateBaseDao<User, Long></p>
     * @param entityClass
     */
    public HibernateBaseDaoImpl() {

        this.entityClass = ReflectionUtils.getSuperClassGenricType(this.getClass());
    }

    /**
     * <p>用于用于省略Dao层, 在Service层直接使用通用SimpleHibernateDao的构造函数.</p>
     * <p>在构造函数中定义对象类型Class</p>
     * <p>eg.</p>
     * <p>SimpleHibernateDao<User, Long> userDao = new SimpleHibernateDao<User, Long>(sessionFactory, User.class);</p>
     * @param sessionFactory
     * @param entityClass
     */
    public HibernateBaseDaoImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityClass = ReflectionUtils.getSuperClassGenricType(this.getClass());
    }

    /**
     * 取得sessionFactory
     * @return
     * SessionFactory
     */
    public SessionFactory getSessionFactory()
    {
        return this.sessionFactory;
    }

    /**
     * 采用@Resource(name="xxx")按名称注入SessionFactory, 当有多个SesionFactory的时候Override本函数.
     */
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }



    /**
     *	取得当前Session.
     */
    public Session getSession()
    {

        return sessionFactory.getCurrentSession();
    }

    /* (非 Javadoc)
    * <p>Title: save</p>
    * <p>Description: </p>
    * @param entity
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#save(java.lang.Object)
    */
    public Serializable save(T entity) {
        // TODO Auto-generated method stub
        Assert.notNull(entity, "entity 不能为空");
        return getSession().save(entity);
    }

    /* (非 Javadoc)
    * <p>Title: save</p>
    * <p>Description: </p>
    * @param entities
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#save(java.util.Collection)
    */
    public Collection<Serializable> save(Collection<T> entities) {
        // TODO Auto-generated method stub
        Assert.notNull(entities,"entities 不能为空");
        Collection<Serializable> coll=new ArrayList<Serializable>();
        for(T entity:entities)
            coll.add(save(entity));

        return coll;
    }

    /* (非 Javadoc)
    * <p>Title: save</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#save(java.lang.String)
    */
    public int save(String hqlQuery) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Query query = getSession().createQuery(hqlQuery);
        return query.executeUpdate();
    }

    /* (非 Javadoc)
    * <p>Title: merge</p>
    * <p>Description: </p>
    * @param entity
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#merge(java.lang.Object)
    */
    @SuppressWarnings("unchecked")
	public T merge(T entity) {
        // TODO Auto-generated method stub
        Assert.notNull(entity, "entity不能为空");
        return (T) getSession().merge(entity);
    }

    /* (非 Javadoc)
    * <p>Title: merge</p>
    * <p>Description: </p>
    * @param entities
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#merge(java.util.Collection)
    */
    @SuppressWarnings("unchecked")
	public Collection<T> merge(Collection<T> entities) {
        // TODO Auto-generated method stub
        Assert.notNull(entities, "entities不能为空");
        Collection<T> coll=new ArrayList<T>();
        for(T entity:entities)
            coll.add((T)getSession().merge(entity));
        return coll;
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param entity
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#delete(java.lang.Object)
    */
    public void delete(T entity) {
        // TODO Auto-generated method stub
        Assert.notNull(entity, "entity不能为空");
        getSession().delete(entity);
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param ids
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#delete(PK[])
    */
    @SuppressWarnings("unchecked")
	public void delete(PK... ids) {
        // TODO Auto-generated method stub
        Assert.notNull(ids, "主键数组不能为空");
        for(PK id:ids)
            delete(get(id));
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param entities
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#delete(java.util.Collection)
    */
    public void delete(Collection<T> entities) {
        // TODO Auto-generated method stub
        Assert.notNull(entities, "entities不能为空");
        for(T entity :entities)
            delete(entity);
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param paraSetter
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#delete(com.werun.template.util.common.QueryParameterSetter)
    */
    public void delete(QueryParameterSetter paraSetter) {
        // TODO Auto-generated method stub
        List<T> list = findAll(paraSetter,null);
        delete(list);
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#delete(java.lang.String)
    */
    public int delete(String hqlQuery) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Query query = getSession().createQuery(hqlQuery);
        return query.executeUpdate();
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param entity
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#update(java.lang.Object)
    */
    public void update(T entity) {
        // TODO Auto-generated method stub
        Assert.notNull(entity, "entity不能为空");
        getSession().update(entity);
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param entities
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#update(java.util.Collection)
    */
    public void update(Collection<T> entities) {
        // TODO Auto-generated method stub
        Assert.notNull(entities, "entities不能为空");
        for(T entity:entities)
            update(entity);
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#update(java.lang.String)
    */
    public int update(String hqlQuery) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Query query = getSession().createQuery(hqlQuery);
        return query.executeUpdate();
    }

    /* (非 Javadoc)
    * <p>Title: get</p>
    * <p>Description: </p>
    * @param id
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#get(java.io.Serializable)
    */
    @SuppressWarnings("unchecked")
	public T get(Serializable id) {
        // TODO Auto-generated method stub
        Assert.notNull(id, "id不能为空");
        return (T) getSession().load(entityClass, id);
    }

    /* (非 Javadoc)
    * <p>Title: getTotalCount</p>
    * <p>Description: </p>
    * @param paraSetter
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#getTotalCount(com.werun.template.util.common.QueryParameterSetter)
    */
    public long getTotalCount(QueryParameterSetter paraSetter) {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        if (paraSetter != null)
            paraSetter.setParameters(dc);
        return getTotalCount(dc);
    }

    /* (非 Javadoc)
    * <p>Title: getTotalCount</p>
    * <p>Description: </p>
    * @param detachedCriteria
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#getTotalCount(org.hibernate.criterion.DetachedCriteria)
    */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public long getTotalCount(DetachedCriteria detachedCriteria) {
        // TODO Auto-generated method stub
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        CriteriaImpl impl = (CriteriaImpl) criteria;

        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();

        List<CriteriaImpl.OrderEntry> orderEntries = null;
        try {
            orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
            ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
        } catch (Exception e) {
            Logs.error("不可能抛出的异常:{}",new Object[]{ e.getMessage()});
        }
        criteria.setProjection(Projections.count(getIdName())).setCacheable(true);
        Object count= criteria.uniqueResult();
        //		Logs.debug("the count type is : {},the count is : {}",new Object[]{count.getClass(), count});
        // 将之前的Projection,ResultTransformer和OrderBy条件重新设回去
        criteria.setProjection(projection);

        if (projection == null) {
            criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (transformer != null) {
            criteria.setResultTransformer(transformer);
        }
        try {
            ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
        } catch (Exception e) {
            Logs.error("不可能抛出的异常:{}",new Object[]{  e.getMessage()});
        }
        return ((Number) count).longValue();
    }

    /* (非 Javadoc)
    * <p>Title: getTotalCount</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#getTotalCount(java.lang.String, java.lang.Object[])
    */
    public long getTotalCount(String hqlQuery, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        Query query = AssembleHQL.createQuery(getSession(), setHQLTotalCount(hqlQuery), values);
        Object count=  query.uniqueResult();
        return ((Number) count).longValue();
    }

	/* (non-Javadoc)
	 * @see org.werun.fanghh.dao.HibernateBaseDao#getTotalCount(java.lang.String, java.util.Map)
	 */
	@Override
	public long getTotalCount(String hqlQuery, Map<String, ?> values) {
		// TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        Query query = AssembleHQL.createQuery(getSession(), setHQLTotalCount(hqlQuery), values);
        Object count=  query.uniqueResult();
        return ((Number) count).longValue();
	}
	
    /* (非 Javadoc)
    * <p>Title: setHQLTotalCount</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#setHQLTotalCount(java.lang.String)
    */
    public String setHQLTotalCount(String hqlQuery) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        return "select count(*) from "+ OperateUtils.substringAfter(hqlQuery," from");
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll()
    */
    public List<T> findAll() {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        return findAll(dc);
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @param paraSetter
    * @param sorter
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll(com.werun.template.util.common.QueryParameterSetter, com.werun.template.util.common.Sorter)
    */
    public List<T> findAll(QueryParameterSetter paraSetter, Sorter sorter) {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        paraSetter.setParameters(dc);
        if (sorter!=null && !DetectionUtils.isEmpty(sorter.getOrder())){
            for(Order order:sorter.getOrder())
                dc.addOrder(order);
        }

        return findAll(dc);
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @param detachedCriteria
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll(org.hibernate.criterion.DetachedCriteria)
    */
    @SuppressWarnings("unchecked")
	public List<T> findAll(DetachedCriteria detachedCriteria) {
        // TODO Auto-generated method stub
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession()).setCacheable(true);
        return criteria.list();
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll(java.lang.String, java.lang.Object[])
    */
    public List<?> findAll(String hqlQuery, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createQuery(getSession(), hqlQuery, values).setCacheable(true).list();
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll(java.lang.String, java.util.Map)
    */
    public List<?> findAll(String hqlQuery, Map<String, ?> values) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createQuery(getSession(), hqlQuery, values).setCacheable(true).list();

    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @param namedQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findAll(java.lang.String, java.lang.String[])
    */
    public List<?> findAll(String namedQuery, String... values) {
        // TODO Auto-generated method stub
        Assert.hasText(namedQuery, "namedQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createSQLQuery(getSession(), namedQuery, values).setCacheable(true).list();

    }


    public void findPageList(QueryParameterSetter paraSetter, Sorter sorter,
                             Page<T> page) {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        if (paraSetter != null)
            paraSetter.setParameters(dc);
        if (sorter!=null && !DetectionUtils.isEmpty(sorter.getOrder())){
            for(Order order:sorter.getOrder())
                dc.addOrder(order);
        }
        findPageList(dc,page);
    }


    public void findPageList(DetachedCriteria detachedCriteria, Page<T> page) {
        // TODO Auto-generated method stub
        if (page.isAutoCount()) {
            long totalCount = getTotalCount(detachedCriteria);
            page.setTotalCount(totalCount);
        }
        Criteria criteria = detachedCriteria.getExecutableCriteria(
                getSession()).setFirstResult(page.getFirst() - 1)
                .setMaxResults(page.getPageSize());

        page.setResult(criteria.list());

    }


    public void findPageList(String hqlQuery, Object[] objs, Page<?> page) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(objs, "objs不能为空");
        Query query = AssembleHQL.createQuery(getSession(),hqlQuery,objs).setCacheable(true).
                setFirstResult(page.getFirst() - 1).setMaxResults(page.getPageSize());
        if (page.isAutoCount()) {
            long totalCount = getTotalCount(hqlQuery,objs);
            page.setTotalCount(totalCount);
        }

        page.setResult(query.list());

    }

	/* (non-Javadoc)
	 * @see org.werun.fanghh.dao.HibernateBaseDao#findPageList(java.lang.String, java.util.Map, org.werun.fanghh.common.utils.Page)
	 */
	@Override
	public void findPageList(String hqlQuery, Map<String, ?> map, Page<?> page) {
		// TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(map, "map不能为空");
        Query query = AssembleHQL.createQuery(getSession(), hqlQuery, map).setCacheable(true).
                setFirstResult(page.getFirst() - 1).setMaxResults(page.getPageSize());
        if (page.isAutoCount()) {
            long totalCount = getTotalCount(hqlQuery,map);
            page.setTotalCount(totalCount);
        }

        page.setResult(query.list());
		
	}
	
    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique()
    */
    public T findUnique() {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        return findUnique(dc);
    }

    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @param paraSetter
    * @param sorter
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique(com.werun.template.util.common.QueryParameterSetter, com.werun.template.util.common.Sorter)
    */
    public T findUnique(QueryParameterSetter paraSetter, Sorter sorter) {
        // TODO Auto-generated method stub
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        paraSetter.setParameters(dc);
        if (!DetectionUtils.isEmpty(sorter.getOrder())){
            for(Order order:sorter.getOrder())
                dc.addOrder(order);
        }

        return findUnique(dc);
    }

    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @param detachedCriteria
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique(org.hibernate.criterion.DetachedCriteria)
    */
    @SuppressWarnings("unchecked")
	public T findUnique(DetachedCriteria detachedCriteria) {
        // TODO Auto-generated method stub
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession()).setCacheable(true).setMaxResults(1);
        return (T) criteria.uniqueResult();
    }

    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique(java.lang.String, java.lang.Object[])
    */
    public Object findUnique(String hqlQuery, Object... values) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createQuery(getSession(), hqlQuery, values).setCacheable(true).setMaxResults(1).uniqueResult();
    }

    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique(java.lang.String, java.util.Map)
    */
    public Object findUnique(String hqlQuery, Map<String, ?> values) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createQuery(getSession(), hqlQuery, values).setCacheable(true).setMaxResults(1).uniqueResult();
    }

    /* (非 Javadoc)
    * <p>Title: findUnique</p>
    * <p>Description: </p>
    * @param namedQuery
    * @param values
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#findUnique(java.lang.String, java.lang.String[])
    */
    public Object findUnique(String namedQuery, String... values) {
        // TODO Auto-generated method stub
        Assert.hasText(namedQuery, "namedQuery不能为空");
        Assert.notNull(values, "values不能为空");
        return AssembleHQL.createSQLQuery(getSession(), namedQuery, values).setCacheable(true).setMaxResults(1).uniqueResult();
    }

    /* (非 Javadoc)
    * <p>Title: getIdName</p>
    * <p>Description: </p>
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#getIdName()
    */
    public String getIdName() {
        // TODO Auto-generated method stub
        ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
        Type identifierType = meta.getIdentifierType();
        if(identifierType  instanceof ComponentType){

            ComponentType ct = (ComponentType)identifierType;
            String[] pkPropertyNames = ct.getPropertyNames();
            return meta.getIdentifierPropertyName()+"."+pkPropertyNames[0];
        }
        return meta.getIdentifierPropertyName();
    }


    /* (非 Javadoc)
    * <p>Title: getId</p>
    * <p>Description: </p>
    * @param entity
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#getId(java.lang.Object)
    */
    public Serializable getId(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // TODO Auto-generated method stub
        Assert.notNull(entity,"entity不能为空");
        return (Serializable) PropertyUtils.getProperty(entity, getIdName());
    }

    /* (非 Javadoc)
    * <p>Title: contains</p>
    * <p>Description: </p>
    * @param t
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#contains(java.lang.Object)
    */
    public boolean contains(T entity) {
        // TODO Auto-generated method stub
        Assert.notNull(entity,"entity不能为空");
        return getSession().contains(entity);
    }


    /* (非 Javadoc)
    * <p>Title: HQL2SQL</p>
    * <p>Description: </p>
    * @param hqlQuery
    * @return
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#HQL2SQL(java.lang.String)
    */
    public String HQL2SQL(String hqlQuery) {
        // TODO Auto-generated method stub
        Assert.hasText(hqlQuery, "hqlQuery不能为空");
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hqlQuery, hqlQuery, Collections.EMPTY_MAP,
                (SessionFactoryImplementor)getSessionFactory());
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        return queryTranslator.getSQLString();
    }

    /* (非 Javadoc)
    * <p>Title: flush</p>
    * <p>Description: </p>
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#flush()
    */
    public void flush() {
        // TODO Auto-generated method stub
        getSession().flush();
    }

    /* (非 Javadoc)
    * <p>Title: clear</p>
    * <p>Description: </p>
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#clear()
    */
    public void clear() {
        // TODO Auto-generated method stub
        getSession().clear();
    }

    /* (非 Javadoc)
    * <p>Title: close</p>
    * <p>Description: </p>
    * @see com.werun.template.hibernate.db.IHibernateBaseDao#close()
    */
    public void close() {
        // TODO Auto-generated method stub
        getSession().close();
    }




}