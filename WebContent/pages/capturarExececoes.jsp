<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captura Exceção</title>
<script type="text/javascript" src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
  <h3>Capturando Excessões com jquery</h3>
  <input type = "text" value = "Valorinformado"id = txtValor>
  <input type = "button" onclick="testarExcessao();" Value = "testar Excesão">
</body>
<script type="text/javascript">
function testarExcessao() {
	valorInformado = $('#txtValor').val();
	$.ajax({
       method:"POST",
	   url:"capturarExcecao",//para qual servelet
	   data:{valorParam: valorInformado}
       
	})
	 /*.always(function (response) {//sempre capta o retorno
		 alert(response);
	 */
	 .done(function (response){//ok nenhum erro
		 alert("Sucesso: "+response);
	 //fazer algo
	 })
	 
     .fail(function (xhr,status,errorThrown){//erro algum problema
		 alert("Error: "+xhr.responseText);
     //fazer algo se der errado
     })
	
	
	
	
}



</script>
</html>