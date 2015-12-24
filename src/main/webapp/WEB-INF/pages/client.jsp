<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
    <jsp:include page="headInclude.jsp"/>

<style>
.col-sm-4{
padding-left : 0;
}
input[type="text"]{
display:none;
}
</style>

</head>
<body onload="Controllers.getBooks(); Controllers.getFeatures(); Controllers.cleanInputs()">
	<div class="wrapper container">
		<br>
		<div class="row">
			<div class="col-sm-3">
				<div id="features">
					<div class="row">Поиск по жанру:</div>
				</div>
				<div>
					<div class="row">Поиск по всем категориям:</div>
					<form id="search">
                		<div class="row">
                			<div class="col-sm-4">
                				<input onchange="Controllers.checkboxController(this)" type="checkbox">
                				Жанр
                			</div>
                			<div class="col-sm-8">
                				<input type="text" name="feature">
                			</div>
                		</div>
                		<div class="row">
                			<div class="col-sm-4">
                				<input onchange="Controllers.checkboxController(this)" type="checkbox">
                				Название
                			</div>
                			<div class="col-sm-8">
                				<input type="text" name="name">
                			</div>
                		</div>
                    	<div class="row">
                    		<div class="col-sm-4">
                    			<input onchange="Controllers.checkboxController(this)" type="checkbox">
                    			Автор
                    		</div>
                    		<div class="col-sm-8">
                    			<input type="text" name="author">
                    		</div>
                    	</div>
                    	<div class="row">
                    		<div class="col-sm-4">
                    			<input onchange="Controllers.checkboxController(this)" type="checkbox">
                    			Год
                    		</div>
                    		<div class="col-sm-8">
                    			<input type="text" name="year">
                    		</div>
                    	</div>
                        <p><input type="button" onclick="Controllers.searchController()" value="искать"></p>
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
