package com.hit.j2ee.sshTemplate.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;  
  
/** 
 * 创建时间：2017-4-11 下午2:26:42 
 *  
 * @author hd 
 * @version 2.2 
 *  
 * Dao通用接口 
 */  
  
public interface BaseDao<T, PK extends Serializable> {
      
    T load(PK id);  
      
    T get(PK id);  
      
    List<T> findAll();  
      
    void persist(T entity);
      
    PK save(T entity);  
    
    void update(T entity
    		);
    void saveOrUpdate(T entity);  
      
    void delete(PK id); 
    
    void deleteByIds(PK... ids);
    
    void deleteAll(Collection<T> entities);
      
    void flush(); 
    
    void setEntityClass(Class<?> entityClass);
    
    T findById(PK id);
    
    List<T> findByCondition(String whereHql,Object[] params,Map<String,String> orderBy,boolean cacheable);
    
    List<T> findByCondition(String whereHql,Object[] params,boolean cacheable);
    
    List<T> findByCondition(Map<String,String> orderBy,boolean cacheable);
    
    List<T> findAll(boolean cacheable);
    
    T findFirstByCondition(String whereHql,Object[] params,boolean cacheable);
    
    List<T> findByConditionWithPaging(String whereHql,Object[] params,Map<String,String> orderBy,int offset,int length);
    
    int getRowCount(String whereHql,Object[] params);
    
    
    
    
}  