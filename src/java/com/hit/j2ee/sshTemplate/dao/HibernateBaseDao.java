package com.hit.j2ee.sshTemplate.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.hit.j2ee.sshTemplate.common.utils.Page;
import com.hit.j2ee.sshTemplate.common.utils.QueryParameterSetter;
import com.hit.j2ee.sshTemplate.common.utils.Sorter;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface HibernateBaseDao<T, PK extends Serializable>  {
    /*************************************增加****************************************************/
    /**
     * 保存数据
     * @param entity
     * void
     */
    public Serializable save(T entity);
    /**
     * 保存批量数据
     * @param entity
     * void
     */
    public Collection<Serializable> save(Collection<T> entities);

    public int save(String hqlQuery);

    /**
     * 合并数据
     * @param entity
     * @return
     * Object
     */
    public T merge(T entity);

    public Collection<T> merge(Collection<T> entities);

    /*************************************删除****************************************************/
    /**
     * 删除数据
     * @param entity
     * void
     */
    public void delete(T entity);

    /**
     * 根据主键数组删除数据
     * @param ids
     * void
     */
    @SuppressWarnings("unchecked")
	public void delete(PK... ids);

    /**
     * 根据集合删除数据
     * @param entities
     * void
     */
    public void delete(Collection<T> entities);

    /**
     * 按Criteria方式删除数据
     * @param detachedCriteria
     * void
     */
    public void delete(QueryParameterSetter paraSetter);

    public int delete(String hqlQuery);

    /********修改**********/
    /**
     * 修改数据
     * @param entity
     * void
     */
    public void update(T entity);

    /**
     * 根据集合修改数据
     * @param entities
     * void
     */
    public void update(Collection<T> entities) ;

    /**
     * 根据hql方式修改数据
     * @param hql
     * @return
     * int
     */
    public int update(String hqlQuery) ;

    /********查询**********/

    /**
     * 按主键查询数据
     * @param id
     * @return
     * Object
     */
    public T get(final Serializable id) ;



    /**
     * 根据参数条件获取记录数
     * @param paraSetter
     * @return
     * int
     */
    public long getTotalCount(QueryParameterSetter paraSetter) ;

    /**
     * 按Criteria方式获取记录数
     * @param detachedCriteria
     * @return
     * int
     */
    public long getTotalCount(DetachedCriteria detachedCriteria);



    /**
     * 按HQL方式获取记录数
     * @param hql
     * @return
     * int
     */
    public long getTotalCount(String hqlQuery, Object... values) ;

    /**
     * 按HQL方式获取记录数
     * @param hql
     * @return
     * int
     */
    public long getTotalCount(String hqlQuery, Map<String,?> values) ;

    /**
     * 将语句设置为selcet count(*) 方式输出
     * @param hql
     * @return
     * String
     */
    public String setHQLTotalCount(String hqlQuery) ;


    /**
     * 单体查询所有数据
     * @return
     * List<?>
     */
    public List<T> findAll() ;

    /**
     * 按条件或排序方式获取所有单体数据
     * @param paraSetter
     * @param sorter
     * @return
     * List<?>
     */
    public List<T> findAll(QueryParameterSetter paraSetter, Sorter sorter) ;

    /**
     * 按Criteria方式获取所有单体数据
     * @param detachedCriteria
     * @return
     * List<?>
     */
    public List<T> findAll(DetachedCriteria detachedCriteria) ;


    /**
     * hql方式获取所有复合数据
     * @param hql
     * @param values
     * @return
     * List<?>
     */
    public List<?> findAll(String hqlQuery, Object... values) ;

    /**
     * hql方式获取所有复合数据
     * @param hql
     * @param values
     * @return
     * List<?>
     */
    public List<?> findAll(String hqlQuery, Map<String, ?> values) ;

    /**
     * sql方式获取所有复合数据
     * @param namedQuery
     * @param values
     * @return
     * List<?>
     */
    public List<?> findAll(String namedQuery, String... values) ;


    /**
     * 带条件、排序的分页查询
     * @param paraSetter
     * @param sorter
     * @param page
     * @return
     * List<?>
     */
    public void findPageList(QueryParameterSetter paraSetter, Sorter sorter, Page<T> page);

    /**
     * 按Criteria方式返回带条件、排序的分页查询
     * @param detachedCriteria
     * @param page
     * @return
     * List<?>
     */
    public void findPageList(DetachedCriteria detachedCriteria, Page<T> page) ;

    /**
     * 按HQL方式返回带条件、排序的分页查询
     * @param hql
     * @param page
     * @return
     * List<?>
     */
    public void findPageList(String hqlQuery, Object[] objs, Page<?> page) ;

    public void findPageList(String hqlQuery, Map<String,?> map, Page<?> page);
    
    public T findUnique();

    public T findUnique(QueryParameterSetter paraSetter, Sorter sorter) ;

    public T findUnique(DetachedCriteria detachedCriteria) ;

    public Object findUnique(String hqlQuery, Object... values) ;

    public Object findUnique(String hqlQuery, Map<String, ?> values) ;

    public Object findUnique(String namedQuery, String... values) ;


    /**
     * 取得对象的主键名.
     * @return
     * String
     */
    public String getIdName() ;

    public boolean contains(T t);

    public Serializable getId(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

    public String HQL2SQL(String hqlQuery);

    /**
     *  Flush当前Session.
     * void
     */
    public void flush();

    public void clear();

    public void close();
}
