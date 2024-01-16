<!-- chamada do cabecalho da pagina  -->
<%@ include file="header.jsp"%>

<div class="row">
	<div class="col-md-12 text-center my-1">
		<h1>Service man</h1>
	</div>
</div>
<div class="row">
	<div class="col-md-1"></div>
	<div class="d-flex col-md-10 text-center my-5">
		<div class="card border-0 w-75">
			<a href="#" class="stretched-link"> 
				<img src="img/client.jpg" alt="clients-img" class="rounded-circle img-thumbnail mx-4">
				<h5 class="card-title">Clientes</h5>
			</a>
		</div>
		<div class="card border-0 w-75">
			<a href="#" class="stretched-link"> 
				<img src="img/agreement.jpg" alt="agreement-img" class="rounded-circle img-thumbnail mx-4">
				<h5 class="card-title">Contrato</h5>
			</a>
		</div>
		<div class="card border-0 w-75">
			<a href="#" class="stretched-link"> 
				<img src="img/ticket.jpg" alt="ticket-img" class="rounded-circle img-thumbnail mx-4">
				<h5 class="card-title">Tickets</h5>
			</a>
		</div>
		<div class="card border-0 w-75">
			<a href="#" class="stretched-link"> 
				<img src="img/service.jpg" alt="service-img" class="rounded-circle img-thumbnail mx-4">
				<h5 class="card-title">Serviços</h5>
			</a>
		</div>
		<div class="card border-0 w-75">
			<a href="employee?action=read" method="GET" class="stretched-link">
				<img src="img/employees.jpg" alt="employees-img" class="rounded-circle img-thumbnail mx-4">
				<h5 class="card-title">Colaboradores</h5>
			</a>
		</div>
	</div>
	<div class="col-md-1"></div>
</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous">
	
</script>
</body>
</html>