package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SucursalDao;
import dao.impl.SucursalDaoImpl;
import models.Sucursal;


@WebServlet("/sucursales-listar")
public class SucursalListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SucursalDao sucursalDao;
       
	public SucursalListarServlet() {
		super();
		sucursalDao = new SucursalDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sucursal> sucursales = sucursalDao.listarSucursales();
		
		request.setAttribute("sucursales", sucursales);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/sucursales-listar.jsp");
		dispatcher.forward(request, response);
	}


}
