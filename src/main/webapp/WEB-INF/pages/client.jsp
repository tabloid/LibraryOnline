<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
    <jsp:include page="headInclude.jsp"/>
</head>
<body onload="getBooks(); getFeatures(); addInputText();">
	<div class="wrapper container">
		<br>
		<div class="row">
			<div class="col-sm-3">
				<div id="features">Поиск по жанру:</div>
				<div>
					<p>Поиск по всем категориям:</p>
					<form id="search">
                		<p><input type="checkbox" name="feature"> Жанр</p>
                        <p><input type="checkbox" name="name"> Название</p>
                        <p><input type="checkbox" name="author"> Автор</p>
                        <p><input type="checkbox" name="year"> Год</p>
                        <p><input type="button" value="искать"></p>
                	</form>
				</div>
			</div>
			<div class="col-sm-9">
				<div id="books"></div>
			</div>
		</div>
	</div>

</body>
</html>
