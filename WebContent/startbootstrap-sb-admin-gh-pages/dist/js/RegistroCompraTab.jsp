<%@page import="ec.edu.ups.dao.RequerimientosCompraDAO" %>
<%@page import="ups.edu.ec.jdbc.JDBCRequerimientosCompraDAO" %>
<%@page import="ups.edu.ec.modelo.Empresa" %>
<%@page import="java.util.ArrayList" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>



   

<body>



    <form name="formReq" method='POST' action="ListarRequerimientosControlador">
    id_req<input type="number" name="NumID"><br>
    usuario_id<input type="number" name="txtUsuario"><br>
    empresa_id<input type="number" name="txtEmpresa"><br>
    estado<input type="text" name="txtEstado"><br>
    producto_id<input type="number" name="txtProducto"><br>
    cantidad<input type="number" name="txtCantidad"><br>
	</form>
	
	<table border="lpx">
		<tr>
			<td>ID</td>
			<td>Usuario</td>
			<td>Empresa</td>
			<td>Estado</td>
			<td>Producto</td>
			<td>Cantidad</td>
		</tr>
		
	</table>
</body>
</html>