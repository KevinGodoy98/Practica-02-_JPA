package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Producto;

/**
 * Servlet implementation class RequerimientosCompraControlador
 */
@WebServlet("/RequerimientosCompraControlador")
public class RegistrarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private Producto producto;
	private String result;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProductoControlador() {
    	usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
    	result = "";
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
		
		String url = null;
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			
			//persona = personaDao.read(id);
			//request.setAttribute("persona", persona);
			url = "/JSPs/buscar_persona.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
