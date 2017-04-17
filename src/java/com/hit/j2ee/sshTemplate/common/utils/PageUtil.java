package com.hit.j2ee.sshTemplate.common.utils;


import javax.servlet.http.HttpServletRequest;


public class PageUtil {

	public static void Request2Page(Page<? extends Object> page, HttpServletRequest request) {
		int start = ConvertUtils.String2int(request.getParameter("start"),1);
		// 每页显示的记录数
		int limit = ConvertUtils.String2int(request.getParameter("limit"), 10);
		// 排序字段
		String sort = OperateUtils.defaultString(request.getParameter("sort"),
				"");
		// 排序方式
		String dir = OperateUtils.defaultString(request.getParameter("dir"),
				"ASC");
		if (!DetectionUtils.isEmpty(sort))
			page.setSort(sort);
		if (!DetectionUtils.isEmpty(dir))
			page.setDir(dir);
		page.setPageSize(limit);
		page.setPageNo(start);
	}

}
