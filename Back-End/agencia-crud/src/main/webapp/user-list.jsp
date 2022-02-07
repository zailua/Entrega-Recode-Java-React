<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CRUD Destinos</title>
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

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Destinos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Novo Destino</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>UF</th>
						<th>País</th>
						<th>Acões</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="destino" items="${listDestino}">

						<tr>
							<td><c:out value="${destino.id}" /></td>
							<td><c:out value="${destino.nome}" /></td>
							<td><c:out value="${destino.uf}" /></td>
							<td><c:out value="${destino.country}" /></td>
							<td><a href="edit?id=<c:out value='${destino.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${destino.id}' />">Deletar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>