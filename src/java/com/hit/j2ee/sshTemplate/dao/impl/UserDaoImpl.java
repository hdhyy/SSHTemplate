package com.hit.j2ee.sshTemplate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hit.j2ee.sshTemplate.dao.UserDao;
import com.hit.j2ee.sshTemplate.pojo.Users;

/** 
 * 创建时间：2014-4-16 下午12:51:47 
 *  
 * @author hd 
 * @version 2.2  
 * 描述： dao实现类 
 */  
  
@Repository("userDao") 
public class UserDaoImpl implements UserDao {

		@Autowired
	    private SessionFactory sessionFactory;  
	  
	    private Session getCurrentSession() {  
	        return this.sessionFactory.getCurrentSession();  
	    }  
	  
	    @Override  
	    public Users load(String id) {  
	        return (Users) this.getCurrentSession().load(Users.class, id);  
	    }  
	  
	    @Override  
	    public Users get(String id) {  
	        return (Users) this.getCurrentSession().get(Users.class, id);  
	    }  
	  
	    @SuppressWarnings("unchecked")  
	    @Override  
	    public List<Users> findAll() {  
	        List<Users> Userss = this.getCurrentSession()  
	                .createQuery("from Users").list();  
	        return Userss;  
	    }  
	  
	    @Override  
	    public void persist(Users entity) {  
	        this.getCurrentSession().persist(entity);  
	  
	    }  
	  
	    @Override  
	    public String save(Users entity) {  
	        return (String) this.getCurrentSession().save(entity);  
	    }  
	  
	    @Override  
	    public void saveOrUpdate(Users entity) {  
	        this.getCurrentSession().saveOrUpdate(entity);  
	    }  
	  
	    @Override  
	    public void delete(String id) {
	        Users entity = this.load(id);  
	        this.getCurrentSession().delete(entity);  
	    }  
	  
	    @Override  
	    public void flush() {  
	        this.getCurrentSession().flush();  
	  
	    }  

}
