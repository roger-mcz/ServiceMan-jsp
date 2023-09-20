<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="DTO.EmployeeDTO" %>
		<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Gerenciamento de servicos">
	<meta name="author" content="Rogerio Oliveira">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
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
			<h1 class="text-">Manutenção de colaboradores</h1>
		</div>

		<div class="container col-sm-10">
			<div class="card">
				<div class="card-header">
					<i class="bi bi-globe"></i> <strong>Cadastro de
						colaboradores</strong>
				</div>
				<div class="card-body">
					<div class="container col-sm-12">

						<form id="frm_employees" action="CrudEmployee" method="POST">
							<div class="row">
								<div class="col-4 form-group">
									<label>Nome</label>
									<input type="text" id="ipt_name" name="ipt_name" class="form-control">
								</div>
								<div class="col-4 form-group">
									<label>Sobrenome</label>
									<input type="text" id="ipt_secondname" name="ipt_secondname" class="form-control">
								</div>
								<div class="col-4 form-group">
									<label>Email</label>
									<input type="email" id="ipt_email" name="ipt_email" class="form-control">
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3 form-group">
									<label>Telefone</label>
									<input type="text" id="ipt_phone" name="ipt_phone" class="form-control">
								</div>
								<div class="col-3 form-group">
									<label>CPF</label>
									<input type="text" id="ipt_cpf" name="ipt_cpf" class="form-control">
								</div>
								<div class="col-4 form-group">
									<label>Função</label>
									<input type="text" id="ipt_office" name="ipt_office" class="form-control">
								</div>
								<div class="col-1 form-group">
									<label>Nível</label>
									<input type="text" id="ipt_role" name="ipt_role" class="form-control">
								</div>
								<div class="col-1 form-group text-center">
									<label>Ativo</label>
									<div class="col-12 form-group">
										<input type="checkbox" id="chc_active" name="chc_active">
									</div>
								</div>
							</div>
							<br>
							<hr>
							<div class="row">
								<div class="col-4 form-group">
									<label>Rua</label>
									<input type="text" id="ipt_street" name="ipt_street" class="form-control">						
								</div>
								<div class="col-1 form-group">
									<label>Número</label>
									<input type="number" id="ipt_number" name="ipt_number" class="form-control">				
								</div>
								<div class="col-2 form-group">
									<label>CEP</label>
									<input type="text" id="ipt_cep" name="ipt_cep" class="form-control">
								</div>
								<div class="col-2 form-group">
									<label>Bairro</label>
									<input type="text" id="ipt_neighborhood" name="ipt_neighborhood" class="form-control">
								</div>
								<div class="col-2 form-group">
									<label>Cidade</label>
									<input type="text" id="ipt_city" name="ipt_city" class="form-control">
								</div>
								<div class="col-1 form-group">
									<label>Estado</label>
									<input type="text" id="ipt_state" name="ipt_state" class="form-control">
								</div>
							</div>

							<div class="clearfix">
							</div>
							<div class="col-sm-3 lh-lg">
								<div class="form-group">
									<label>&nbsp;</label>
									<div>
										<button class="btn btn-success" type="button" id="btn_save" data-bs-toggle="modal" data-bs-target="#mdl_save">
											<i class="bi bi-check-all"></i> Salvar
										</button>
										<!-- modal de confirmação -->
 										<div class="modal fade" id="mdl_save" data-bs-backdrop="static">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title">Deseja realmente salvar o registro?</h5>
													</div>
													<div class="modal-footer">
														<button 
															type="submit" 
															id="btnSair"
															class="btn btn-success"
															data-bs-dismiss="modal">
															<i class="bi bi-check-all"></i> Salvar
															
															
														</button>
														<button 
															type="button" 
															class="btn btn-danger" 
															data-bs-dismiss="modal">
															<i class="bi bi-x-circle"></i> Cancelar
														</button>
													</div>
												</div>
											</div>
										</div>

										
										<button name="btn_back" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#mdl_cancel" onclick="history.back()">
											<i class="bi bi-arrow-left-circle"></i> Voltar
										</button>										
									</div>
								</div>
							</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<script>
		document.getElementById('btnConfirm').addEventListener('click', function() {
			clearFormInputs();
		});

		function clearFormInputs() {
			document.getElementById('ipt_name').value = '';
			document.getElementById('ipt_secondname').value = '';
			document.getElementById('ipt_email').value = '';
			document.getElementById('ipt_phone').value = '';
			document.getElementById('ipt_cpf').value = '';
			document.getElementById('ipt_office').value = '';
			document.getElementById('ipt_role').value = '';
			document.getElementById('chc_active').checked = false;
			document.getElementById('ipt_street').value = '';
			document.getElementById('ipt_number').value = '';
			document.getElementById('ipt_cep').value = '';
			document.getElementById('ipt_neighborhood').value = '';
			document.getElementById('ipt_city').value = '';
			document.getElementById('ipt_state').value = '';					
		}
	</script>

</body>
</html>