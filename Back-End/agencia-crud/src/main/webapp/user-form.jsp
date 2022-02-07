<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="user.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background: #1c1d22;">
			<div>
				<a href="list" class="navbar-brand">Sakura Trip</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Destinos</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${destino != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${destino == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${destino != null}">
            			Editar Destino
            		</c:if>
						<c:if test="${destino == null}">
            			Novo Destino
            		</c:if>
					</h2>
				</caption>

				<c:if test="${destino != null}">
					<input type="hidden" name="id" value="<c:out value='${destino.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Destino</label> <input type="text"
						value="<c:out value='${destino.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>UF</label> <input type="text"
						value="<c:out value='${destino.uf}' />" class="form-control"
						name="uf">
				</fieldset>

				<fieldset class="form-group">
					<label>País</label> <input type="text"
						value="<c:out value='${destino.country}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>