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
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {  
  
    @Resource
    private void setUserDao(UserDao userDao){
    	this.baseDao = userDao;
    }

    private UserDao getUserDao(){
    	return (UserDao)baseDao;
    }
    public UserServiceImpl() {
		super();
		setClazz(User.class);
		this.getUserDao().exampleMethod();
	}

	@Override
	public boolean isUserNameExist(String userName) {

		return baseDao.findFirstByCondition(" and o.name=?", new Object[]{ userName }, false)!=null;
	}
  

  
}  
