<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	
	
	<div class="container mt-5">
		<a href="/sistema-restaurante-jee" class="btn btn-primary">Ir a Inicio</a>
		<h2>Registrar Sucursal</h2>
		<form action="" method="post">
			<div class="form-group">
	            <label for="nombre">Nombre de Sucursal</label>
	            <input type="text" class="form-control" id="nombre" name="nombre" required>
        	</div>
        	<button type="submit" class="mt-5 btn btn-primary">Registrar</button>
		</form>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>