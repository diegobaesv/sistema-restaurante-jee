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
import utils.Util;

@WebServlet("/sucursales/*")
public class SucursalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SucursalDao sucursalDao;
	
    public SucursalServlet() {
        super();
        sucursalDao = new SucursalDaoImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo: "+pathInfo);
		
		if(pathInfo == null) {
			List<Sucursal> sucursales = sucursalDao.listar();
			
			request.setAttribute("sucursales", sucursales);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listarSucursales.jsp");
			dispatcher.forward(request, response);
		} else {
			String id = Util.extractDataFromPath(pathInfo, 1);
			System.out.println("id: "+id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/detalleSucursal.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Peticion POST a SucursalServlet");
	}

}
