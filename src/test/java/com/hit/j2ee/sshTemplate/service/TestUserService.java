package java.com.hit.j2ee.sshTemplate.service;

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;
import com.hit.j2ee.sshTemplate.pojo.User;
import com.hit.j2ee.sshTemplate.service.UserService;  
  
/** 
 * 创建时间：2017-2-13 下午3:31:07 
 *  
 * @author andy 
 * @version 2.2 
 */  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-hibernate.xml" })
public class TestUserService {
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestUserService.class);
  
    @Autowired  
    private UserService userService;  
  
    @Test  
    public void save() {  
        User userInfo = new User();  
        userInfo.setUsername("hd");
        userInfo.setVersion(1001);
        String id = userService.save(userInfo);
        JSON.toJSONString(id);  
    }  
  
}  
