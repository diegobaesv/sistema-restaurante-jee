<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h2>Detalle de sucursal $nombre</h2>
		<img class="imagen-cabecera" src="https://dfmas.df.cl/dfmas/site/artic/20220922/imag/foto_0000002020220922191520/Copia_de_Hyatt_Centric_Lima-050407.jpg">
		<div class="mt-4">
			<p class="mb-2"><b>Direccion:</b> $direccion</p>
			<p class="mb-2"><b>Whatsappp:</b> $telefono</p>
			<p class="mb-2"><b>Correo:</b> $correo</p>
			<p class="mb-2"><b>Horario:</b> Martes a Domingo<br>12 p.m. a 12 a.m.</p>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>