package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.Error;

/**
 * Servlet implementation class EliminarProductoControlador
 */
@WebServlet("/EliminarProductoControlador")
public class EliminarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private CategoriaDAO categoriaDAO;
	private Producto producto;
	private String result;
    /**
     * @see HttpServlet#HttpServlet()
     */
	  	private HttpServletRequest rsq;
	    private HttpServletResponse rsp;
	    
    public EliminarProductoControlador() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	result = "";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String url, descripcion, nombre, precio,estado;
	int id, empresa, catg;
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("id"));
		
		
		
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/EliminarProducto.jsp";
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}

		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("id"));
			
			
			try {
				
				producto = new Producto(id, nombre, precio, descripcion, catg,empresa,estado);
				productoDAO.delete(producto);
				//requerimientosDAO.create(requerimiento);
				//request.setAttribute("Mensaje", "Requerimiento agragado");
				
				if(session.getAttribute("rol").toString().equals("U")) {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
					httpResponse.sendRedirect(url);
				} else {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
					httpResponse.sendRedirect(url);
				}
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
			} catch (Exception e) {
				request.setAttribute("mensaje", "(!) Ocurrio un ERROR");
			}
		} else {
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
	}

}
