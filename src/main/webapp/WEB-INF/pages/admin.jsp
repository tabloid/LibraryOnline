<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>

<title>admin</title>
<link rel="stylesheet" href="weblib/css/admin.css" type="text/css"/>
<jsp:include page="headInclude.jsp"/>
<script src="weblib/js/Controllers.js"></script>
<script src="weblib/js/Controllers.Admin.js"></script>

</head>
<body onload="Controllers.Admin.getFeatures(); Controllers.cleanInputs()">
	<div class="container">
		<div class="header">
        	<ul class="nav nav-pills pull-right">
          		<li><a href="client">Home</a></li>
          		<li><a href="#">About</a></li>
          		<li class="active"><a href="admin">Admin</a></li>
        	</ul>
        	<h3 class="text-muted">Online library project</h3>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class='panel-heading'>Форма загрузки книг</div>
					<div class='panel-body'>
						<form id="send" action="" enctype="multipart/form-data" target="iframe" method="post">
							<p>Введите жанр книг (или выберите из списка):</p>
							<p><input type="text" name="feature"></p>
							<p><input type="file" name="file" multiple="true" ></p>
							<p><input type="button" onclick="Controllers.Admin.sendBooks()" value="Upload"></p>
						</form>
					</div>
				</div>
			</div>
			<div id="features" class="col-sm-6">
				<div class="panel panel-default">
					<div class='panel-heading'>Доступные жанры</div>
					<ul class="nav nav-pills nav-stacked"></ul>
				</div>
			</div>
		</div>
		<div class="row">
			<iframe width=100% height=100% name="iframe" frameborder="no" onload="Controllers.Admin.getFeatures()"></iframe>
		</div>
	</div>
</body>
</html>
