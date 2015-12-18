<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
    <jsp:include page="headInclude.jsp"/>
</head>
<body onload="getFeatures()">
	<div class="wrapper container">
		<br>
		<div class="row">
			<div class="col-sm-3">
				<form id="form" action="../api/books/test/new" enctype="multipart/form-data" method="post">
            		Введите жанр книг (или выберите из списка):
            		<p><input type="text" name="feature" required></p>
            		<p><input type="file" name="file" multiple="true"></p>
            		<p><input type="submit" value="Upload"></p>
            	</form>
			</div>
			<div id="features" class="col-sm-3">
				Доступные жанры:
			</div>
			<div id="books" class="col-sm-6">
			</div>
		</div>
	</div>

</body>
</html>
