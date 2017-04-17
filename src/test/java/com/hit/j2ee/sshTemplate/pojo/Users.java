package com.hit.j2ee.sshTemplate.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import com.hit.j2ee.sshTemplate.common.ConstUtil;
import com.hit.j2ee.sshTemplate.common.encrypt.MD5Util;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Users", schema = "dbo", catalog = "template")

public class Users implements java.io.Serializable {

	// Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	private String token;
	private String status;
	private Integer version;
	private Boolean isDeleted;

	private static final Integer minUsernameSize = 6;
	private static final Integer maxUsernameSize = 20;
	private static final Integer minPasswordSize = 6;
	
	
	// Constructors

	/** default constructor */
	public Users() {
	}
	
	

	/**
	* @Description  描述该构造方法的特殊用处
	* @param   构造方法的入参描述
	* @author 杜海文
	*/
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
		this.token = "";
		this.status = ConstUtil.STATUS_USERS_NORMAL;
		this.version = 0;
		this.isDeleted = false;
	}



	/** minimal constructor */
	public Users(String id, String username, String password, String status, Integer version, Boolean isDeleted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.version = version;
		this.isDeleted = isDeleted;
	}

	/** full constructor */
	public Users(String id, String username, String password, String token, String status, Integer version,
			Boolean isDeleted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
		this.status = status;
		this.version = version;
		this.isDeleted = isDeleted;
	}

	/**
	* @Title: checkVaild
	* @TitleExplain: 方法名说明
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param username
	* @param password
	* @return
	* @return boolean    返回类型描述
	* @version 该方法在哪个产品的哪个版本上使用
	* @author 杜海文
	* @date 2017年4月12日
	*/ 
	public boolean checkVaild(){
		if (this.username.length() >= minUsernameSize && this.username.length() <= maxUsernameSize 
				&& this.password.length() >= minPasswordSize){
			this.password = MD5Util.getMD5String(username+password+username.charAt(minUsernameSize-1)+password.charAt(minPasswordSize-1));
			return true;
		}
		return false;
	}
	
	public void generateToken(){
		this.token = MD5Util.getMD5String(this.username+this.password+System.currentTimeMillis());
	}
	
	// Property accessors
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 64)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 20)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 64)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "token", length = 64)

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "status", nullable = false, length = 8)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "version", nullable = false)
	@Version
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "is_deleted", nullable = false)

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}