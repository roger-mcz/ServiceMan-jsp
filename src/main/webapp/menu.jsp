<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<span class="navbar-text text-bg-primary">Status: 
				${validateMessage}
			</span>
			<form class="d-flex" role="form" action="Logout" method="GET">
				<button class="btn btn-light" type="button" data-bs-toggle="modal" data-bs-target="#mdl_logout">Logout</button>
				
				<!-- modal de confirmação -->
				<div class="modal fade" id="mdl_logout"	data-bs-backdrop="static">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Deseja sair do sistema?</h5>
							</div>
							<div class="modal-footer">
								<button 
									type="submit" 
									id="btnSair"
									class="btn btn-success"
									data-bs-dismiss="modal"
									>Sair
								</button>
								<button 
									type="button" 
									class="btn btn-danger" 
									data-bs-dismiss="modal">Cancelar
								</button>
							</div>
						</div>
					</div>
				</div>
				
			</form>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-12 text-center my-1">
			<h1>Service man</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="d-flex col-md-8 text-center my-5">
			<div class="p-2 d-flex flex-column text-center">
				<p>
					<a href="clients.html">
						<img src="img/client.jpg" alt="clients-img" class="rounded-circle img-thumbnail mx-5">
						Clientes
					</a>
				</p>
			</div>
			<div class="p-2 d-flex flex-column text-center">
				<p>
					<a href="agreements.html">
						<img src="img/agreement.jpg" alt="agreement-img" class="rounded-circle img-thumbnail mx-5">
						Contrato
					</a>
				</p>
			</div>
			<div class="p-2 d-flex flex-column text-center">
				<p>
					<a href="tickets.html">
						<img src="img/ticket.jpg" alt="ticket-img" class="rounded-circle img-thumbnail mx-5">
						Tickets
					</a>
				</p>
			</div>
			<div class="p-2 d-flex flex-column text-center">
				<p>
					<a href="services.html">
						<img src="img/service.jpg" alt="service-img" class="rounded-circle img-thumbnail mx-5">
					Serviços
					</a>
				</p>
			</div>
			<div class="p-2 d-flex flex-column text-center">
				<p>
					<a href="employee?action=list" method="GET">
						<img src="img/employees.jpg" alt="employees-img" class="rounded-circle img-thumbnail mx-5">
					Colaboradores
					</a>
				</p>
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