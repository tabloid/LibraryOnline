<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>

<title>about</title>
<link rel="stylesheet" href="weblib/css/admin.css" type="text/css"/>
<jsp:include page="headInclude.jsp"/>

</head>
<body>
	<div class="container">
	    <div class="header">
            <ul class="nav nav-pills pull-right">
                <li><a href="client">Home</a></li>
                <li class="active"><a href="about">About</a></li>
                <li><a href="admin">Admin</a></li>
            </ul>
            <h3 class="text-muted">Online library project</h3>
        </div>
		<div class="row">
		    <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class='panel-body'>
                        <p>
                            Данный ресурс задумывался в качестве репозитория технической литературы, где все жилающие могут бесплатно получить необходимые книги, а также в качестве учебного проекта автора.
                        </p>
                        <p>
                            По всем вопросам обращайтесь по почте sysmet@meta.ua
                        </p>
                    </div>
                </div>
            </div>
		</div>
	</div>
</body>
</html>
