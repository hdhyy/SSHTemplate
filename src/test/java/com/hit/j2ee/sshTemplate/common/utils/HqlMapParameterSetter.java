/**
 * Create By Du
 * Date : 2017年3月19日
 */
package com.hit.j2ee.sshTemplate.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
* @ClassName: HqlMapParameterSetter
* @ClassNameExplain: HQL参数设置类
* @Description: 辅助生成HQL查询
* @author 杜海文
* @date 2017年4月12日 下午2:44:02
*/
public class HqlMapParameterSetter {
	private final String IS_DELETED = "isDeleted";
	
	private final Boolean NOT_DELETED = false;
	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	/**
	* @Title: add
	* @TitleExplain: 增加查询参数
	* @Description: 增加查询参数，必须与HQL的参数一一对应
	* @param name 参数名
	* @param value 参数值
	* @return void 
	* @version v1.0
	* @author 杜海文
	* @date 2017年4月12日
	*/ 
	public void add(String name,Object value){
		map.put(name, value);
	}
	
	/**
	* @Title: addNotDeleted
	* @TitleExplain: 增加NotDeleted字段
	* @Description: 增加HQL语句，增加数据库未被删除字段
	* @return void 
	* @version v1.0
	* @author 杜海文
	* @date 2017年4月12日
	*/ 
	public void addNotDeleted(){
		map.put(IS_DELETED, NOT_DELETED);
	}
	
	
	/**
	* @Title: getParamMap
	* @TitleExplain: 获取参数Map
	* @Description: 获取参数Map
	* @return
	* @return Map<String,Object>  参数Map
	* @version v1.0
	* @author 杜海文
	* @date 2017年4月12日
	*/ 
	public Map<String,Object> getParamMap(){
		return map;
	}
}
