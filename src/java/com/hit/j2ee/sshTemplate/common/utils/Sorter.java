package com.hit.j2ee.sshTemplate.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.criterion.Order;


public class Sorter {
	public static final String DESC = "desc";

	public static final String ASC = "asc";

	private Map sortmap;

	public Sorter() {
		this.sortmap = new HashMap<String,Object>();
	}

	public void setSort(String key, Object value){
		this.sortmap.put(key,value);
	}

	/**
	 * @return the sortmap
	 */
	public Map getSortmap() {
		return sortmap;
	}

	/**
	 * @param sortmap
	 *            the sortmap to set
	 */
	public void setSortmap(Map sortmap) {
		this.sortmap = sortmap;
	}

	public Order[] getOrder() {
		if (DetectionUtils.isEmpty(sortmap))
			return null;
		Order[] orders = new Order[sortmap.size()];
		Iterator iter = sortmap.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			String sortName = (String) iter.next();
			String sortType = (String) sortmap.get(sortName);
			if (DESC.equalsIgnoreCase(sortType))
				orders[i] = Order.desc(sortName);
			else
				orders[i] = Order.asc(sortName);
			i++;
		}

		return orders;
	}

}
