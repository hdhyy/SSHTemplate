package com.hit.j2ee.sshTemplate.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.hit.j2ee.sshTemplate.dao.UserDao;
import com.hit.j2ee.sshTemplate.pojo.User;
import com.hit.j2ee.sshTemplate.service.UserService;

/** 
 * 创建时间：2017-4-13 下午1:03:47 
 *  
 * @author hd 
 * @version 2.2
 * 描述： userService实现类
 */  
@Service("userService")  
public class UserServiceImpl extends BaseServiceImpl<User, String,UserDao> implements UserService {  
  
    @Resource(name="userDao")
    private void setBaseDao(UserDao userDao){
    	this.baseDao = userDao;
    }
    
    public UserServiceImpl() {
		super();
		setClazz(User.class);
	}

	@Override
	public boolean isUserNameExist(String userName) {

		return baseDao.findFirstByCondition(" and o.username=?", new Object[]{ userName }, false)!=null;
	}
  

  
}  
