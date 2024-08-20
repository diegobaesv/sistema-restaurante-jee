<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Sucursal" %>

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
	a{
		text-decoration: none;
		color: black;
	}
</style>
<body>
	<div class="container mt-5">
		<h2>Listado de Sucursales</h2>
		<div class="row">
			<%
			List<Sucursal> listaSucursal = (List<Sucursal>) request.getAttribute("sucursales");
			if (listaSucursal != null && !listaSucursal.isEmpty()) {
				for (Sucursal sucursal : listaSucursal) {
			%>
				<div class="col-md-4 mt-4">
					<a href="/sistema-restaurante-jee/sucursales/<%=sucursal.getIdSucursal()%>">
						<div class="card">
	                        <img class="card-img-top" src="<%= sucursal.getImagenUrl() %>" alt="Imagen del restaurante">
	                        <div class="card-body">
	                            <h5 class="card-title"><%= sucursal.getNombre() %></h5>
	                            <p class="card-text"><%= sucursal.getDireccion() %></p>
	                            <!--  a href="sucursales/reservas/ sucursal.getId() " class="btn btn-primary">Hacer Reserva</a-->
	                        </div>
                    	</div>	
					</a>
                </div>
			<%
				}
			} else {
			%>
			<div class="col">
				<p>No se encontraron restaurantes.</p>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>