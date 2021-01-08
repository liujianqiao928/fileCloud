<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<link rel="stylesheet" href="css/community.css">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="/css/file.css" rel='stylesheet' type='text/css'/>
	<link href="/css/buttons.css" rel='stylesheet' type='text/css'/>
	<title>文件目录</title>
</head>
<body>

<script type="text/javascript">
    var sysMsg = "${msg}"
    if(sysMsg != "")
        alert(sysMsg);
</script>

	<table>
		<tr>
			<th></th>
			<th>文件名</th>
			<th>文件类型</th>
			<th>大小</th>
			<th>上传时间</th>
		
			<th>删除</th>
		</tr>
		
		<c:forEach var="list" items=	"${list }">
			<tr>
				<td>${list.fileId}</td>
				<td>${list.fileName}</td>
				<td>${list.fileType }</td>
				<td>${list.fileSize } KB</td>
				<td>${list.fileUptime }</td>
				<td> <a href="/delate.do?fileId=${list.fileId}">删除</a></td>
		</c:forEach>
	</table>
	<div id="fileForm">
		<div id="upload">
			<br/>
			<h2>文件上传</h2>
			<form class="form-control" action="/up.do" method="post" enctype="multipart/form-data" accept-charset="utf-8" >
				选择文件：<input type="file" name="file" /><br/>
				<input type="hidden" name="path" value="${requestScope.folderId}" />
				<input type="submit" value="          上传           " class="button button-3d button-primary button-rounded"/>
			</form>
		
	</div>
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
</body>
</html>