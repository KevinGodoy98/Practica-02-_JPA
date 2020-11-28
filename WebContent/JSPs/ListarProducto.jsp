<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="pro" value="${requestScope['lstProductos']} " />


<c:forEach var="row" items="${lstProductos}">
    <tr>
 
        <td><c:out value="${row.id}"/></td><br>
        <td><c:out value="${row.nombre}"/></td><br>
        <td><c:out value="${row.precio}"/></td><br>
        <td><c:out value="${row.descripcion}"/></td><br>
         <td><c:out value="${row.categoria_id}"/></td><br>
    </tr>
 
</c:forEach>

<form id="form_cabecera" action="/Practica_laboratorio_1/ProductoControlador" method="post">

					<h5 style="color: white" , class="bg-black"><strong>Listar Productos:</strong></h5>
			
					<div class="input-group input-group-lg">
						<input type="text" class="form-control" id="cedula" name="cedula" placeholder="Numero de cedula">
						<div class="input-group-prepend">
							<button class="input-group-text" name="btn" value="bscCedula" type="submit">Buscar</button>
						</div>
					</div>
</form>

<script src="/Practica_laboratorio_1/JSPs/js/jquery-3.3.1.min.js"></script>
<script src="/Practica_laboratorio_1/JSPs/js/jquery-ui.js"></script>
<script src="/Practica_laboratorio_1/JSPs/js/bootstrap.min.js"></script>
<script src="/Practica_laboratorio_1/JSPs/js/aos.js"></script>


<script src="/Practica_laboratorio_1/JSPs/js/main.js"></script>
</body>
</html>