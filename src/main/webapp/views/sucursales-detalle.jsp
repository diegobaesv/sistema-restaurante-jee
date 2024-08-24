<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Sucursal" %>
<%@ page import="utils.Util" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Restaurantes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<style>
	.imagen-cabecera {
		width: 100%;
		height: 250px;
		object-fit: cover;
		object-position: center;
	}
</style>
<body>
	<div class="container mt-5">
	<a href="../sucursales-listar" class="btn btn-primary">Ir a Lista</a>
	
	
	<% 
		Sucursal sucursal = (Sucursal) request.getAttribute("sucursal");  
    %>
		<h2>Detalle de sucursal <%= sucursal.getNombre() %></h2>
		<img class="imagen-cabecera" src="<%= sucursal.getImagenUrl() %>">
		<div class="mt-4">
			<p class="mb-2"><b>Direccion:</b> <%= sucursal.getDireccion() %></p>
			<p class="mb-2"><b>Whatsappp:</b> <a href="https://wa.me/51<%=sucursal.getTelefono()%>?text=<%=Util.encodedTextToUrl("Hola, quiero hacer una reserva para la sucursal "+sucursal.getNombre())%>"><%= sucursal.getTelefono() %></a></p>
			<p class="mb-2"><b>Correo:</b> <%= sucursal.getCorreo() %></p>
			<p class="mb-2"><b>Horario:</b> <%=  sucursal.getDiasAtencion() %><br><%=  sucursal.getHorarioAtencion() %></p>
		</div>
		<div style="width: 100%">
			<iframe 
				width="100%" 
				height="600" 
				frameborder="0" 
				scrolling="no" 
				marginheight="0" 
				marginwidth="0" 
				src="https://maps.google.com/maps?width=100%25&amp;height=600&amp;hl=en&amp;q=<%=sucursal.getLatitud()%>,<%=sucursal.getLongitud()%>+(Restaurante)&amp;t=&amp;z=17&amp;ie=UTF8&amp;iwloc=B&amp;output=embed">					
			</iframe>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>