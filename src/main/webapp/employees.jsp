<!-- chamada do cabecalho da pagina  -->
<%@ include file="header.jsp"%>

<%@ page import="DTO.EmployeeDTO"%>
<%@ page import="java.util.ArrayList"%>

<div class="row">
	<label>&nbsp;</label>
	<div class="container col-sm-10">
		<div class="card">
			<label>&nbsp;</label>
			<div class="row align-items-center">
				<div class="col-sm-2 align-items-center text-center">
					<img src="img/employees.jpg" alt="employees-img" class="img-fluid rounded-circle img-thumbnail">
				</div>
				<div class="col-sm-10">
					<h1 class="display-4">Colaboradores</h1>
				</div>
			</div>
			<label>&nbsp;</label>
			<div class="card-body align-items-center">
				<div class="row align-items-center">
					<div class="col-sm-6 d-grid gap-2 d-md-flex">
						<a href="menu.jsp" method="GET" class="btn btn-secondary"> 
							<i class="bi bi-arrow-left-circle"></i> Voltar
						</a>							
						<a href="employee?action=create" method="GET" class="btn btn-primary"> 
							<i class="bi bi-person-plus"></i> Adicionar
						</a>						
						<%
							//passagem de parametros p/ EmployeeControllerServlet
        					String actionCrud = "create";
        					session.setAttribute("actionCrud", actionCrud);
    					%>
					</div>
					<div class="col-sm-6 d-grid gap-2 d-md-flex justify-content-md-end">
						<a href="createemployee.jsp" class="btn btn-danger"> <i
							class="bi bi-file-earmark-pdf"></i> .PDF
						</a> <a href="createemployee.jsp" class="btn btn-secondary"> <i
							class="bi bi-filetype-csv"></i> .CSV
						</a> <a href="createemployee.jsp" class="btn btn-success"> <i
							class="bi bi-filetype-xlsx"></i> .XLSX
						</a> <a href="createemployee.jsp" class="btn btn-warning"> <i
							class="bi bi-printer"></i> Imprimir
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container col-sm-10">
	<hr>
</div>

<!-- DataTable -->
<div class="container col-sm-10">
	<table id="tb_employees" class="table table-striped table-bordered table-hover">
		<thead class="table-primary bg-primary">
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Função</th>
				<th class="text-center">Nível</th>
				<th class="text-center">Ativo</th>
				<th class="text-center">Ação</th>
			</tr>
		</thead>
		<tbody class="align-middle">
			<%
			ArrayList<EmployeeDTO> employeeDTOList = null;
			employeeDTOList = (ArrayList<EmployeeDTO>) request.getAttribute("employeeList");
			if (employeeDTOList != null) {
				for (int i = 0; i < employeeDTOList.size(); i++) {
			%>
			<tr>
				<td><%=employeeDTOList.get(i).getName()%></td>
				<td><%=employeeDTOList.get(i).getSecondname()%></td>
				<td><%=employeeDTOList.get(i).getEmail()%></td>
				<td><%=employeeDTOList.get(i).getPhone()%></td>
				<td><%=employeeDTOList.get(i).getOffice()%></td>
				<td class="text-center"><%=employeeDTOList.get(i).getRole()%></td>
				<td class="text-center"><%=employeeDTOList.get(i).getActive()%></td>
				<td class="text-center">
									
					<!-- exibir detalhes -->
					<button type="button" class="btn btn-outline-primary me-2"
						style="--bs-btn-padding-y: .10rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: 1rem;">
						<i class="bi bi-eye"></i> 
					</button>
									
					<!-- editar employee  -->
					<a href="employee?action=update&employeeid=<%=employeeDTOList.get(i).getId()%>" method="GET" class="btn btn-outline-success me-2"
						style="--bs-btn-padding-y: .10rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: 1rem;">
						<i class="bi bi-pencil-square"></i>
					</a>
				
					
					<!-- excluir employee 
					<button type="button" class="btn btn-outline-danger me-2" -->
					<a href="employee?action=delete&employeeid=<%=employeeDTOList.get(i).getId()%>" method="GET" class="btn btn-outline-danger me-2"
						style="--bs-btn-padding-y: .10rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: 1rem;">
						<i class="bi bi-trash3"></i>
					</a>
<!-- 					</button> -->
				</td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
		<hr>
	</div>

    <!-- DataTable JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.1/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.1/js/responsive.bootstrap5.min.js"></script>
    <!-- Custom JS -->
    <script src="js/script.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
	</script>

</body>

</html>