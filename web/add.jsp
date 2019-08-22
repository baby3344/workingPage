<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.4.min.js">
</script>
<script type="text/javascript">
	function checkTitle() {
		var title=$('#title').val();
		$.ajax({
			"url":"CountByTitleServlet",
			"type":"post",
			"data":{"title":title},
			"dataType":"json",
			"success":function(data){
				if(data.count>0){
					$("#tip").html("用户名已被使用");
				} else {
					$("#tip").html("用户名可以使用");
				}
			}
		});
	}
</script>
</head>
<body>

	<form method="post" action="saveServlet">
		标题：<input type="text" name="title" id="title" onblur="checkTitle();"> <span id="tip"></span>  <br>
		内容：<textarea rows="5" cols="10" name="content"></textarea> <br>
		类别：
			<select name="type">
				<option value="0">请选择类别</option>
				<option value="1">技术</option>
				<option value="2">行政</option>
				<option value="3">人事</option>
			</select>
			<br>
			<input type="submit" value="提交">
	</form>

</body>
</html>