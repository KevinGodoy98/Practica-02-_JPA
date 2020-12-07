package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.RequerimientosCompra;

/**
 * Servlet implementation class EliminarRequerimientoControlador
 */
@WebServlet("/LlenarRequerimientoControlador")
public class LlenarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientosCompraDAO requerimientoDAO;	
    private RequerimientosCompra requerimiento; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LlenarRequerimientoControlador() {
    	requerimientoDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url, mensaje;
		int id;
		
		id = Integer.valueOf(request.getParameter("id"));
		mensaje = request.getParameter("mensaje");
		
		try {
			requerimiento = requerimientoDAO.read(id);
			
			request.setAttribute("producto", requerimiento.getProducto());
			request.setAttribute("cantidad", requerimiento.getCantidad());
			request.setAttribute("id", requerimiento.getId());
			request.setAttribute("mensaje", mensaje);
			
			url = "/startbootstrap-sb-admin-gh-pages/dist/private/modificar_req.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(request.getParameter("id"));
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
