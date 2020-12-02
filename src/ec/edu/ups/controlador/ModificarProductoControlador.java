package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ups.edu.ec.modelo.Categoria;
import ups.edu.ec.modelo.Producto;

/**
 * Servlet implementation class ModificarProductoControlador
 */
@WebServlet("/ModificarProductoControlador")
public class ModificarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private CategoriaDAO categoriaDAO;
	private Producto producto;
	private String result;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductoControlador() {
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
	int emp;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(request.getParameter("categ"));
		
		String url, descripcion, nombre, precio,estado;
		int id, catg;
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/ModificarProducto.jsp";
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("nombre").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("precio").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("descrip").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("categ").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		
		
		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			precio = request.getParameter("precio").toString();
			//empresa = Integer.valueOf(session.getAttribute("empresa_id").toString());
			catg = Integer.valueOf(request.getParameter("categ"));
			descripcion = request.getParameter("descrip");
			estado = request.getParameter("estado");
			try {
				
				producto = new Producto(id, nombre, precio, descripcion, catg, emp,estado);
				productoDAO.update(producto);
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
