package com.hit.j2ee.sshTemplate.common.utils;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 查询条件设置接口
 * 
 * @author eagler006 email:eagler006@hotmail.com
 * @version 1.2
 */
public interface QueryParameterSetter {

	/**
	 * 设置查询条件
	 * 
	 * @param criteria
	 *            查询条件实例
	 */
	public void setParameters(DetachedCriteria criteria);

}
