<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="jquery-1.12.4.min.js">
	</script>
</head>
<body>
<h1>工作笔记</h1>
<a href="add.jsp">新增</a>
<table border="1">
	<tr>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>4</th>
	</tr>
	<c:forEach var="w" items="${page.list}">
		<tr>
			<td>${w.title }</td>
			<td>
					${w.type == 1 ? '技术' : ''}
					${w.type == 2 ? '行政' : ''}
					${w.type == 3 ? '人事' : ''}
				<!-- or -->
				<c:if test="${w.type == 1}">技术</c:if>
				<c:if test="${w.type == 2}">行政</c:if>
				<c:if test="${w.type == 3}">人事</c:if>
			</td>
			<td>${w.createDate }</td>
			<td>
				<a href="viewServlet?id=${w.id }">查看</a>
			</td>
		</tr>
	</c:forEach>
</table>
<p>
	<a href="listServlet?currPageNo=1&pageSize=${page.pageSize }">首页</a>
	<a href="listServlet?currPageNo=${page.currPageNo - 1 }&pageSize=${page.pageSize }">上一页</a>
	<a href="listServlet?currPageNo=${page.currPageNo + 1 }&pageSize=${page.pageSize }">下一页</a>
	<a href="listServlet?currPageNo=${page.totalPageCount }&pageSize=${page.pageSize }">尾页</a>
	第${page.currPageNo }页/总共${page.totalPageCount }页
</p>
</body>
</html>