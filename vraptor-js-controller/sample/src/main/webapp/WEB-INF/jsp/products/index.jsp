<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head></head>
    <body>
				<input type="button" id="listar" value="Listar">
				<input type="text" id="id" >
				<input type="button" id="carregar" value="Carregar">
				<br>
				<form id="novoProduto" action="novoProduto" method="get">
				  descrição: <input type="text" name="product.description"> <br>
				  preço: <input type="text" name="product.price">
				</form>
				<input type="button" id="inserir" value="Inserir">
				<input type="button" id="atualizar" value="Atualizar">
				<input type="button" id="remover" value="Remover">
				<div id="console"></div>
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="<c:url value='/js/min/ProductsController'/>"></script>
        <script type="text/javascript" src="<c:url value='/index.js'/>"></script>
    </body>
</html>