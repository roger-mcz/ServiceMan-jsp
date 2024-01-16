<!-- chamada do cabecalho da pagina  -->
<%@ include file="header.jsp" %>

<%@ page import="DTO.EmployeeDTO"%>
<%@ page import="java.util.ArrayList"%>

	<style>
		.vertical-center {
			min-height: 50%;  /* Fallback for browsers do NOT support vh unit */
			min-height: 5vh; /* These two lines are counted as one :-)       */
			
			display: flex;
			align-items: center;
		}
	</style>
	
		<div class="container col-sm-10 p-3">
			<div class="card p-3">
				<div class="row">
					<div class="col col-sm-1 text-end">
						<img src="img/employees.jpg" alt="employees-img" class="img-fluid rounded-circle img-thumbnail"  style="max-width: 80%;">
					</div>
					<div class="col col-sm-11 vertical-center">
						<label class="fs-4"><%= session.getAttribute("labelCrud") %></label>
					</div>
				</div>
			</div>
		</div>

		<div class="container  col-sm-10">		
			<form id="frm_employees" action="employee?action=create" method="POST">
				<div class="row">
					<div class="col-4 form-group">
						<label>Nome</label>
						<input type="text" id="ipt_name" name="ipt_name" class="form-control" required>
					</div>
					<div class="col-4 form-group">
						<label>Sobrenome</label>
						<input type="text" id="ipt_secondname" name="ipt_secondname" class="form-control">
					</div>
					<div class="col-4 form-group">
						<label>Email</label>
						<input type="email" id="ipt_email" name="ipt_email" class="form-control" required>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-3 form-group">
						<label>Telefone</label>
						<input type="text" id="ipt_phone" name="ipt_phone" class="form-control" required>
					</div>
					<div class="col-3 form-group">
						<label>CPF</label>
						<input type="text" id="ipt_cpf" name="ipt_cpf" class="form-control" required>
					</div>
					<div class="col-4 form-group">
						<label>Função</label>
						<input type="text" id="ipt_office" name="ipt_office" class="form-control" required>
					</div>
					<div class="col-1 form-group">
						<label>Nível</label>
						<input type="text" id="ipt_role" name="ipt_role" class="form-control" required>
					</div>
					<div class="col-1 form-group text-center">
						<label>Ativo</label>
						<div class="col-12 form-group">
							<input type="checkbox" id="chk_active" name="chk_active">
						</div>
					</div>
				</div>
				<br>
				<hr>
				<div class="row">
					<div class="col-4 form-group">
						<label>Rua</label>
						<input type="text" id="ipt_street" name="ipt_street" class="form-control" required>						
					</div>
					<div class="col-1 form-group">
						<label>Número</label>
						<input type="number" id="ipt_number" name="ipt_number" class="form-control" required>				
					</div>
					<div class="col-2 form-group">
						<label>CEP</label>
						<input type="text" id="ipt_cep" name="ipt_cep" class="form-control" required>
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
												id="btnSave"
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
							<!-- modal de confirmação -->
							<a href="employee?action=read" method="GET" class="btn btn-secondary">
								<i class="bi bi-arrow-left-circle"></i> Voltar
							</a>
						</div>
					</div>
				</div>
			</form>
		</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous">
	</script>

	<script>
	
/* 	//limpando os imputs
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
		} */
	</script>

</body>
</html>