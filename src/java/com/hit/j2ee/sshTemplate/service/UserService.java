package com.hit.j2ee.sshTemplate.service;

import com.hit.j2ee.sshTemplate.pojo.User;
/**   
 * 创建时间：2017-4-13 下午12:49:55   
 * @author hd 
 * @version 2.2
 * 描述： userDao  
 */  
public interface UserService extends BaseService<User, String>{

	public boolean isUserNameExist(String userName);
}
