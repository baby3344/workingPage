<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  标题：${w.title } <br>
  内容：${w.content } <br>
  类别：
  <c:if test="${w.type == 1}">技术</c:if>
  <c:if test="${w.type == 2}">行政</c:if>
  <c:if test="${w.type == 3}">人事</c:if><br>
  日期：${w.createDate }<br>
  
  <input type="button" value="返回" onclick="history.back();">
</body>
</html>