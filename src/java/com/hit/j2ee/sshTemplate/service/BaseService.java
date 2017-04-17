package com.hit.j2ee.sshTemplate.service;

import java.io.Serializable;
import java.util.List;

/** 
 * 创建时间：2015-2-11 下午2:26:42 
 *  
 * @author hd 
 * @version 2.2 
 *  
 * Service通用接口 
 */  
public interface BaseService<T, PK extends Serializable> {
	
    T load(PK id);  
    
    T get(PK id);  
      
    List<T> findAll();  
      
    void persist(T entity);
      
    PK save(T entity);  
      
    void saveOrUpdate(T entity);  
      
    void delete(PK id);  
      
    void flush();

}
