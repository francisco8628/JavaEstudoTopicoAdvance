<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progresso</title>

<link rel="stylesheet"  href = "//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">

/*classe fundo da barra de progresso */ 
#myProgres{                 
width: 100%;
background-color:  #ddd; 
}

/*cor da barra de progresso*/
#myBar{
width: 1%;
height: 30px;
background-color: #4CAF50;
}

.ui-progressbar{
position: relative;
}

.progress-label{
position: relative;
left: 50%;
top: 4px;
font-weight: bold;
text-shadow: 1px 1px 0 #fff;
}

</style>
</head>
<body>
<h1>Exemplo com java script</h1>
<div id="myProgres"><!-- fundo da barra -->
  <div id="myBar"><!--  barra DE PROGRESSO--></div>
</div>
<br/>
<button onclick="exibirBarra()">Iniciar a Barra de Tarefas</button>
<br/>
<h1>Barra com Jqeury</h1>
<div id = "progressbar">
    <div class="progress-label">
                     Carregando...
    
    </div>

</div>
 
 <script type="text/javascript">
  
 function exibirBarra() {
	var elem = document.getElementById("myBar");
	var width = 1 ;
	var id = setInterval(frame,10);
	
	function frame() {
		 if (width>=100) {
			clearInterval(id);
		} else {
            width++;
            elem.style.width = width + '%';
		}
	}
}

 </script>
</body>
</html>