<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Pagina Pai</title>
<script type="text/javascript" src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>Esta pagina é a pagina pai</h1>
<input type="button" value="carregar pagina" onclick="carregar();"> <!--local de carregamento da pagina filha -->
<div id="mostrarPaginaFilha"></div>
</body>
<script type="text/javascript">
function carregar() {
	$("#mostrarPaginaFilha").load('paginaFilha.jsp')//load pagina em Jquery
}



</script>
</html>