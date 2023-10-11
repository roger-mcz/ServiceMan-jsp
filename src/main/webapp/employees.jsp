<!-- chamada do cabecalho da pagina  -->
<%@ include file="header.jsp" %>

<%@ page import="DTO.EmployeeDTO"%>
<%@ page import="java.util.ArrayList"%>

	<div class="row">
		<div class="col-md-12 text-center my-1">
			<h1 class="text-">Manutenção de colaboradores</h1>
		</div>

		<div class="container col-sm-10">
			<div class="card">
				<div class="card-header">
					<i class="bi bi-globe"></i> 
						<strong>Navegação de colaboradores</strong> 
						<a href="createemployee.jsp" class="btn btn-success btn-sm float-end"> 
						<i class="bi bi-person-plus"></i> Adicionar
					</a>
				</div>
				<div class="card-body">
					<div class="container col-sm-12">
						<h5 class="card-title lh-lg">
							<i class="bi bi-search"></i> Pesquisar colaborador
						</h5>
<!-- 	form antigo		<form action="employee?action=list" method="GET"> -->
							<div class="row">
								<div class="col-sm-3">
									<div class="form-group">
										<label>Nome</label> <input type="text" name="username"
											id="username" class="form-control" value="">
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<label>Email</label> <input type="email" name="useremail"
											id="useremail" class="form-control" value="">
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-sm-4 lh-lg">
									<div class="form-group">
										<label>&nbsp;</label>
										<div>
											<form action="employee?action=list" method="GET">
												<button type="submit" id="btn_search" class="btn btn-primary">
													<i class="bi bi-search"></i> Pesquisar
												</button>
												<button type="reset" id="btn_clean" class="btn btn-danger">
													<i class="bi bi-arrow-repeat"></i> Limpar
												</button>
												<button name="btn_back" type="button" class="btn btn-secondary" onclick="history.back()">
													<i class="bi bi-arrow-left-circle"></i> Voltar
												</button>
											</form>
										</div>
									</div>
								</div>
							</div>
<!-- 	form antigo		</form> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="container col-sm-10">
		<hr>
	</div>
	<div class="container col-sm-10">
<!-- 	<form action="Employees" method="GET"> -->
		<table class="table table-striped table-bordered table-hover">
			<thead class="table-primary bg-primary">
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Função</th>
					<th class="text-center">Nível</th>
					<th class="text-center">Ativo</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<EmployeeDTO> employeeDTOList = null;
					employeeDTOList = (ArrayList<EmployeeDTO>) request.getAttribute("employeeList");
					if (employeeDTOList != null) {
						for (int i =0; i < employeeDTOList.size(); i++) { 
							
				%>					
						<tr>
							<td><%=employeeDTOList.get(i).getName()%></td>
							<td><%=employeeDTOList.get(i).getSecondname()%></td>
							<td><%=employeeDTOList.get(i).getEmail()%></td>
							<td><%=employeeDTOList.get(i).getPhone()%></td>
							<td><%=employeeDTOList.get(i).getOffice()%></td>
							<td class="text-center"><%=employeeDTOList.get(i).getRole()%></td>
							<td class="text-center"><%=employeeDTOList.get(i).getActive()%></td>			
						</tr>
				<%		} 
					}
				%>				
<!-- 					<td colspan="6" align="center">No Record(s) Found!</td> -->
			</tbody>
		</table>
<!--  		</form> -->


	</div>
	<!--/.col-sm-12-->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>

</html>