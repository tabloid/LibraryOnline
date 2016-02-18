<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Library</title>
	<link rel="stylesheet" href="weblib/css/client.css" type="text/css"/>

    <jsp:include page="headInclude.jsp"/>
    <script src="weblib/js/Controllers.js"></script>
    <script src="weblib/js/Controllers.Client.js"></script>
</head>
<body onload="Controllers.Client.getBooks(); Controllers.Client.getFeatures(); Controllers.cleanInputs()">
	<div class="container">
		<div class="header">
        	<ul class="nav nav-pills pull-right">
          		<li class="active"><a href="client">Home</a></li>
          		<li><a href="#">About</a></li>
          		<li><a href="admin">Admin</a></li>
        	</ul>
        	<h3 class="text-muted">Online library project</h3>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div id="features" class="panel panel-default">
					<div class='panel-heading'>Поиск по жанру</div>
					<ul class="nav nav-pills nav-stacked"></ul>
				</div>
				<div class="panel panel-default">
					<div class='panel-heading'>Поиск по всем категориям</div>
					<form id="search">
                		<div class="panel-body">
                			<div class="col-sm-5">
                				<input onchange="Controllers.Client.checkboxController(this)" type="checkbox">
                				Жанр
                			</div>
                			<div class="col-sm-7">
                				<input type="text" name="feature">
                			</div>
                		</div>
                		<div class="panel-body">
                			<div class="col-sm-5">
                				<input onchange="Controllers.Client.checkboxController(this)" type="checkbox">
                				Название
                			</div>
                			<div class="col-sm-7">
                				<input type="text" name="name">
                			</div>
                		</div>
                    	<div class="panel-body">
                    		<div class="col-sm-5">
                    			<input onchange="Controllers.Client.checkboxController(this)" type="checkbox">
                    			Автор
                    		</div>
                    		<div class="col-sm-7">
                    			<input type="text" name="author">
                    		</div>
                    	</div>
                    	<div class="panel-body">
                    		<div class="col-sm-5">
                    			<input onchange="Controllers.Client.checkboxController(this)" type="checkbox">
                    			Год
                    		</div>
                    		<div class="col-sm-7">
                    			<input type="text" name="year">
                    		</div>
                    	</div>
                    	<div class="panel-body">
                        	<input type="button" onclick="Controllers.Client.searchController()" value="искать" class="btn btn-default">
                        </div>
                	</form>
				</div>
			</div>
			<div id="books" class="col-sm-6 panel panel-default"></div>
			<div id="sidebar" class="col-sm-3">
				<div class="panel panel-default">
					<div>
						реклама
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
