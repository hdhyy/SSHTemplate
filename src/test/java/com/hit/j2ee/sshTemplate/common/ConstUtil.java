package com.hit.j2ee.sshTemplate.common;
/**
 * @ClassName: ConstUtil
 * @ClassNameExplain: 常量工具类
 * @Description: 保存代码中的各种常量
 * @author 杜海文
 * @date 2016年4月11日 下午2:13:38
 */
public class ConstUtil {
	//服务器配置地址常量
	//------------------------------部署之前必须修改------------------------------------
	public static final String SERVER_ADDRESS = "http://localhost:8080/werunmanager";
	public static final String LOCAL_PIC_ADDRESS = "D:/image/userImage/";
	public static final String PIC_ADDRESS = "http://120.77.212.147:8080/file/userUpload";
	public static final String FILE_ADDRESS = "C:/file/userUpload/";
	public static final String FILE_SERVER_ADDRESS = "http://120.77.212.147:8080/file/userUpload/";
	public static final String FILE_LOCAL_ADDRESS = "C:/file/userUpload/";
	//融云配置常量
	public static final String appKey = "uwd1c0sxuwtw1";//替换成您的appkey
	public static final String appSecret = "hGzQL3hSEi";//替换成匹配上面key的secret
	//接口地址常量
	public static final String BASE_INTERFACE = "/";
	public static final String APP_INTERFACE = "/app";
	public static final String USERS_INTERFACE = APP_INTERFACE + "/users";
	public static final String LOGIN_INTERFACE = "/login.do";
	public static final String REGIST_INTERFACE = "/regist.do";
	public static final String GET_USERINFO_INTERFACE = "/getUserInfo.do";
	//管理地址常量
	public static final String ADMIN_INTERFACE = "/admin";
	public static final String MANAGER_INTERFACE = ADMIN_INTERFACE + "/manager";
	//session信息常量
	public static final String SESSION_USER_INFO = "userInfo";
	//header信息常量
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_TOKEN = "token";
	//HQL常量
	//用户登录
	public static final String USER_LOGIN_HQL = "from Users where username = :username and "
			+ "password = :password and status = :status and isDeleted = :isDeleted";
	//用户注册时检查用户名是否注册过
	public static final String USER_REGIST_CHECK_HQL = "from Users where username = :username and isDeleted = :isDeleted";
	public static final String USER_GET_BY_TOKEN_HQL = "from Users where token = :token and isDeleted = :isDeleted";
	//数据库通用字段常量
	public static final String DB_ID = "id";
	public static final String DB_STATUS = "status";
	public static final String IS_DELETED = "isDeleted";
	public static final Integer NOT_DELETED = 0;
	public static final Integer DELETED = 1;
	//视图常量
	public static final String BASE_RESULT_NAME = "result";
	public static final String MODEL_TOKEN_ATTRIBUTE = "token";
	public static final String ADMIN_REDIRECT_VIEW = "redirect:/admin";
	public static final String LOGIN_VIEW = "login.jsp";
	public static final String INDEX_VIEW = "index.jsp";
	//Users常量
	public static final String STATUS_USERS_NORMAL = "01010100";
	public static final String DB_USERS_USERNAME = "username";
	public static final String DB_USERS_PASSWORD = "password";
	public static final String DB_USERS_TOKEN = "token";
	
	//其他常量
	public static final String DEFULT_PORTRAIT = "http://s16.sinaimg.cn/mw690/003gRgrCzy73OGZAV434f&690";
	//返回消息常量
	public static String LOGIN_SUCCESS = "99010101"; //登录成功
	public static String LOGIN_WRONG_PASSWORD = "99010102";//账号/密码错误
	public static String REGIST_SUCCESS = "99010201";//注册成功
	public static String HAVE_REGISTED = "99010202";//账号已被注册
	public static String INVALID  = "99010203";//账号不合法
	public static String UPDATE_SUCCESS = "99010301";//更新成功
	public static String UPDATE_FAILED = "99010302";//更新失败，参数不合法
	public static String SAVE_SUCCESS = "99010401";//保存成功
	public static String SAVE_FAILED = "99010402";//保存失败，参数不合法
	//特殊含义常量
	public static String NO_COMPANY_PHONE = "";//厂家没有电话;
	public static String NO_COMPANY_ADDRESS = "";//厂家没有地址;
	public static String DEFAULT_COMPANY = "未知";
	public static String NO_ATTENTION = "无";//没有注意事项
}
