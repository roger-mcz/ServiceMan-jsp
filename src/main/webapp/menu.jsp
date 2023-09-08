<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="validateMessage" type="java.lang.String"
	scope="request" />
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
			<span class="navbar-text text-bg-primary">Status
				${validateMessage}</span>
			<!-- <span class="navbar-text text-bg-primary me-auto">Informações importantes aqui</span> -->
			<form role="form" method="link" action="Logout" method="GET">
				<button type="submit" value="Logout" class="btn btn-light">Logout</button>
			</form>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-12 text-center my-1">
			<h1>Service man</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 text-center my-5">
			<div>
				<a href="clients.html"><img src="img/client.jpg"
					alt="clients-img" class="rounded-circle img-thumbnail mx-5"></a>
				<a href="agreements.html"><img src="img/agreement.jpg"
					alt="agreement-img" class="rounded-circle img-thumbnail mx-5"></a>
				<a href="tickets.html"><img src="img/ticket.jpg"
					alt="ticket-img" class="rounded-circle img-thumbnail mx-5"></a> <a
					href="services.html"><img src="img/service.jpg"
					alt="service-img" class="rounded-circle img-thumbnail mx-5"></a>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>
</html>