package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SucursalDao;
import dao.impl.SucursalDaoImpl;
import models.Sucursal;

@WebServlet("/sucursales-registrar")
public class SucursalRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SucursalDao sucursalDao;
       
    public SucursalRegistrarServlet() {
        super();
        sucursalDao = new SucursalDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/sucursales-registrar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sucursal sucursal = new Sucursal();
		sucursal.setNombre(request.getParameter("nombre"));
		sucursal.setDireccion(request.getParameter("direccion"));
		sucursal.setImagenUrl(request.getParameter("imagenUrl"));
		sucursal.setTelefono(request.getParameter("telefono"));
		sucursal.setCorreo(request.getParameter("correo"));
		sucursal.setDiasAtencion(request.getParameter("diasAtencion"));
		sucursal.setHorarioAtencion(request.getParameter("horarioAtencion"));
		sucursal.setLatitud(request.getParameter("latitud"));
		sucursal.setLongitud(request.getParameter("longitud"));
		
		sucursalDao.insertarSucursal(sucursal);
		
		response.sendRedirect(request.getContextPath()+"/sucursales-listar");
	}

}
