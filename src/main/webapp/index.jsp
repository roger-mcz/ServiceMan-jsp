<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Gerenciamento de servicos">
<meta name="author" content="Rogerio Oliveira">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<title>Service manager</title>
</head>
<body>
	<nav class="navbar bg-primary">
		<div class="container-fluid">
			<span class="navbar-text text-bg-primary">Login</span>
			<!-- <span class="navbar-text text-bg-primary me-auto">Informações importantes aqui</span> -->
		</div>
	</nav>

	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 mt-5">
			<form role="form" action="LoginServlet" method="POST">
				<div class="form-group mt-3">
					<label for="inputEmail"> Email address </label> <input type="email"
						class="form-control" id="inputEmail" name="email" />
				</div>
				<div class="form-group mt-3">
					<label for="inputPassword"> Password </label> <input
						type="password" class="form-control" id="inputPassword"
						name="password" />
				</div>
				<div class="form-group mt-4">
					<button type="submit" class="btn btn-primary">Acessar!</button>
				</div>
				<div class="form-group mt-2">
					<span>Esqueceu a senha?<a href="index.jsp">clique aqui.</a></span>
				</div>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>