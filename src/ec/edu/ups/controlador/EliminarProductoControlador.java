package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.servlets.HttpSession;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.Error;

/**
 * Servlet implementation class EliminarProductoControlador
 */
@WebServlet("/EliminarProductoControlador")
public class EliminarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  	private HttpServletRequest rsq;
	    private HttpServletResponse rsp;
	    
    public EliminarProductoControlador() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.rsq = request;
		this.rsp = response;
		
		String id = request.getParameter("id");

		if(!id.equals("")) {
			System.out.println("1");
			delete(id);
		}else {
			System.out.println("2");
			request.setAttribute("error", new Error("No se ha podido eliminar el telefono.", "Debe seleccionar un numero despues de listar en la tabla."));
			request.getRequestDispatcher(request.getContextPath()+"/EliminarProducto.jsp").forward(request, response);
		}
	}
	
	private void delete(String ...strings) throws IOException, ServletException {
		ProductoDAO producto = DAOFactory.getFactory().getProductoDAO();
		Set<Producto> nombre = producto.listarProducto(strings[0]);
		boolean rtn = producto.delete(new Producto(int id,String nombre, String precio, String descripcion,int categoria_id));
		if(!rtn) {
			rsq.setAttribute("error", new ups.edu.ec.modelo.Error("No se ha podido eliminar el registro telefonico.", ""));
			rsq.getRequestDispatcher(rsq.getContextPath()+"/private/tablaAdmin.jsp").forward(rsq, rsp);
		}else {
			rsq.setAttribute("error", null);
			rsp.sendRedirect(rsq.getContextPath()+"/private/EliminarProducto.jsp");
		}
		
	}

}
