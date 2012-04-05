<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head></head>
    <body>
        <table>
            <tfoot></tfoot>
            <thead>
                <th>Descri��o</th>
                <th>Pre�o</th>
            </thead>
            <tbody>
	           <c:forEach var="produto" items="${produtos}">
                 <tr>
                    <td>${produto.descricao}</td>
                    <td>${produto.preco}</td>
                 </tr>
        	   </c:forEach>
            </tbody>
        </table>
    </body>
</html>