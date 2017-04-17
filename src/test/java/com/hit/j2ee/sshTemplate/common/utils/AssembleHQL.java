package com.hit.j2ee.sshTemplate.common.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.util.Assert;


/**
* Query组装工具类
* @author eagler006 email:eagler006@hotmail.com
* @version  1.2
*
*/
public class AssembleHQL {

	/**
	* 带一个参数的原生SQL的Query生成方法
	* @param session
	* @param sql
	* @param value
	* @return
	* Query
	*/
	public static Query createSQLQuery(Session session, String sql, String value){
		if(DetectionUtils.isBlank(value))
			return session.createSQLQuery(sql);
		if(DetectionUtils.contains(sql, '?'))
			return session.createSQLQuery(OperateUtils.replace(sql, "?", value));
		return null;
	}
	
	/**
	* 带多个参数的原生SQL的Query生成方法
	* @param session
	* @param sql
	* @param values
	* @return
	* Query
	*/
	public static Query  createSQLQuery(Session session, String sql, String... values){
		
		if(DetectionUtils.isEmpty(values))
			return session.createSQLQuery(sql);
		
		if(OperateUtils.countMatches(sql, "?")==values.length)
			
			return session.createSQLQuery(OperateUtils.replaceEach(sql, OperateUtils.split(OperateUtils.repeat("?",",", values.length),","), values));
				
		return null;
	}
	
	/**
	* 带多个参数数组的HQL的Query生成方法
	* @param session
	* @param hql
	* @param values
	* @return
	* Query
	*/
	public static Query createQuery(Session session, String hql, Object... values)
	{
		Assert.hasText(hql, "hql不能为空");
		Query query = session.createQuery(hql);
		if(DetectionUtils.isEmpty(values))
			return query;
		for (int i = 0; i < values.length; i++)
		{
			query.setParameter(i, values[i]);
		}

		return query;
	}


	/**
	* Map方式的HQL的Query生成方法
	* @param session
	* @param hql
	* @param values
	* @return
	* Query
	*/
	public static Query createQuery(Session session, String hql, Map<String, ?> values)
	{
		Assert.hasText(hql, "hql不能为空");
		Query query = session.createQuery(hql);
		if(DetectionUtils.isEmpty(values))
			return query;
		Iterator<String> iter = values.keySet().iterator();
		while(iter.hasNext()){
			String key=iter.next();
			Object value=values.get(key);
			if(value instanceof Collection)
				query.setParameterList(key, (Collection)value);
			else
				query.setParameter(key, value);
			
		}
		return query;
	}
}
