<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
<jsp:useBean id="validateMessage" type="java.lang.String"
	scope="request" />
	 --%>
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
<%-- 				${validateMessage} --%>
				<%=session.getAttribute("statusmessage") %>
			</span>
			<form class="d-flex" role="form" action="Logout" method="GET">
				<button class="btn btn-light" type="button" data-bs-toggle="modal" data-bs-target="#mdl_logout">
					Logout <i class="bi bi-box-arrow-right"></i>
				</button>
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
	
<!-- 	
</body>
</html>
 -->