package com.hit.j2ee.sshTemplate.dao.impl;

import org.springframework.stereotype.Repository;

import com.hit.j2ee.sshTemplate.dao.UserDao;
import com.hit.j2ee.sshTemplate.pojo.User;

/** 
 * 创建时间：2014-4-16 下午12:51:47 
 *  
 * @author hd 
 * @version 2.2  
 * 描述： dao实现类 
 */  
  
@Repository("userDao") 
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	@Override
	public void exampleMethod() {
		System.out.println("----------example method be used---------------");
	}

//		通过注入sessionFactory来实现相关方法
//		@Autowired
//	    private SessionFactory sessionFactory;  
//	  
//	    private Session getCurrentSession() {
//	        return this.sessionFactory.getCurrentSession();
//	    }  
//	  


}
