<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
    <jsp:include page="headInclude.jsp"/>
    <script src="weblib/js/Controllers.js"></script>
    <script src="weblib/js/Controllers.Admin.js"></script>
</head>
<body onload="Controllers.Admin.getFeatures(); Controllers.cleanInputs()">
	<div class="wrapper container">
		<br>
		<div class="row">
			<div class="col-sm-5">
				<form id="send" action="" enctype="multipart/form-data" target="iframe" method="post">
            		<p>Введите жанр книг (или выберите из списка):</p>
            		<p><input type="text" name="feature"></p>
            		<p><input type="file" name="file" multiple="true" ></p>
            		<p><input type="button" onclick="Controllers.Admin.sendBooks()" value="Upload"></p>
            	</form>
			</div>
			<div id="features" class="col-sm-3">
				<p>Доступные жанры:</p>
            	<ul class="nav nav-pills nav-stacked"></ul>
			</div>
		</div>
		<div class="row">
			<iframe width=100% height=100% name="iframe" frameborder="no"></iframe>
		</div>
	</div>
</body>
</html>
