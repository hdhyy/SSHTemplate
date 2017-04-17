package com.hit.j2ee.sshTemplate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.j2ee.sshTemplate.dao.UserDao;
import com.hit.j2ee.sshTemplate.pojo.Users;
import com.hit.j2ee.sshTemplate.service.UserService;

/** 
 * 创建时间：2017-4-13 下午1:03:47 
 *  
 * @author hd 
 * @version 2.2
 * 描述： userService实现类
 */  
@Service("userService")  
public class UserServiceImpl implements UserService {  
  
    @Autowired  
    private UserDao userDao;
  
    @Override  
    public Users load(String id) {
        return null;  
    }  
  
    @Override  
    public Users get(String id) {  
        return userDao.get(id);  
    }  
  
    @Override  
    public List<Users> findAll() {  
        return userDao.findAll();  
    }  
  
    @Override  
    public void persist(Users entity) {  
    	userDao.persist(entity);  
    }  
  
    @Override  
    public String save(Users entity) {  
        return userDao.save(entity);  
    }  
  
    @Override  
    public void saveOrUpdate(Users entity) {  
    	userDao.saveOrUpdate(entity);  
    }  
  
    @Override  
    public void delete(String id) {  
    	userDao.delete(id);  
    }  
  
    @Override  
    public void flush() {  
    	userDao.flush();  
    }  
  
}  
