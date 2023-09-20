<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DTO.EmployeeDTO"%>
<%@ page import="java.util.ArrayList"%>


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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

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
					<i class="bi bi-globe"></i> 
						<strong>Navegação de colaboradores</strong> 
						<a href="createemployee.jsp" class="btn btn-secondary btn-sm float-end"> 
						<i class="bi bi-person-plus"></i> Adicionar
					</a>
				</div>
				<div class="card-body">
					<div class="container col-sm-12">
						<h5 class="card-title lh-lg">
							<i class="bi bi-search"></i> Pesquisar colaborador
						</h5>
						<form action="Employees" method="GET">
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
											<button type="submit" id="btn_search" class="btn btn-primary">
												<i class="bi bi-search"></i> Pesquisar
											</button>
											<button type="reset" id="btn_clean" class="btn btn-danger">
												<i class="bi bi-arrow-repeat"></i> Limpar
											</button>
											<button name="btn_back" type="button" class="btn btn-secondary" onclick="history.back()">
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
	</div>
	</div>
	<div class="container col-sm-10">
		<hr>
	</div>
	<div class="container col-sm-10">
	<form action="Employees" method="GET">
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
					ArrayList<EmployeeDTO> employeeDTOList = (ArrayList<EmployeeDTO>) request.getAttribute("employeeList");
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
		</form>

<%-- 
<form action="Employees" method="POST">

	<button type="submit" name="Employees" value="Employees"
		id="submit" class="btn btn-primary">
		<i class="bi bi-search"></i> atualizar
	</button>
	<%
		ArrayList<EmployeeDTO> employeeDTOList2 = new ArrayList<EmployeeDTO>(); 
		employeeDTOList2  = (ArrayList<EmployeeDTO>) request.getAttribute("employeeList");
		if (employeeDTOList != null){
			for (int i = 0; i < employeeDTOList2.size(); i++) {
				out.println(employeeDTOList2.get(i).getName());
				out.println(employeeDTOList2.get(i).getEmail());
				out.println(employeeDTOList2.get(i).getPhone());
				out.println(employeeDTOList2.get(i).getSecondname());
				out.println(employeeDTOList2.get(i).getOffice());
				out.println(employeeDTOList2.get(i).getRole());
				out.println(employeeDTOList2.get(i).getActive());
			}	
		}
		
	%>
</form>
 --%>

	</div>
	<!--/.col-sm-12-->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>

</html>