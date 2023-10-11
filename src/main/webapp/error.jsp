<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
<jsp:useBean id="validateMessage" type="java.lang.String" scope="request"/>
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

<title>Service manager - Erro</title>
</head>
<body>
	<nav class="navbar bg-primary">
		<div class="container-fluid">
			<span class="navbar-text text-bg-primary">Erro: 
<%-- 			${validateMessage}</span> --%>
				<%=session.getAttribute("statusmessage") %>
		</div>
	</nav>
	
		<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 mt-5 text-center" >
<!-- 	<form role="form" action="" method="GET"> -->
			<div>
				<h1>
					<i class="bi bi-exclamation-triangle"></i>
					Erro!
				</h1>
            </div>
            <hr>
            <br>
            <div>
                <label>
                    <h3><%=session.getAttribute("statusmessage") %></h3>
                </label>
                <br>
                <br>
                <br>
			</div>
            <div >
                <label>
                    <h5>Verifique o usuário ou senha e tente novamente!</h5>
                </label>
                <br>
                <br>
			</div>
            <br>
			<div >
				<button type="submit" class="btn btn-secondary" onclick="history.back()" >
					<i class="bi bi-arrow-left-circle"></i> Voltar
				</button>
			</div>
<!-- 	</form> -->
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