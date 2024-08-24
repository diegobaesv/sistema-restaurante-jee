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
import utils.Util;

@WebServlet("/sucursales-detalle/*")
public class SucursalDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SucursalDao sucursalDao;
       
    public SucursalDetalleServlet() {
        super();
        sucursalDao = new SucursalDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = Util.extractDataFromPath(pathInfo, 1);
		
		Sucursal sucursal = sucursalDao.obtenerSucursal(Integer.parseInt(id));
		request.setAttribute("sucursal", sucursal);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/sucursales-detalle.jsp");
		dispatcher.forward(request, response);
	}


}
