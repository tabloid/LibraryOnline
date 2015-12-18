<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
    <jsp:include page="headInclude.jsp"/>
</head>
<body>
	<div class="wrapper container">
		<div class="row">
			<form id="form" action="../api/books/test/new" enctype="multipart/form-data" method="post">
        		<p><input type="file" name="file" multiple="true">
        		<input type="submit" value="Upload"></p>
        	</form>
		</div>
	</div>

</body>
</html>
