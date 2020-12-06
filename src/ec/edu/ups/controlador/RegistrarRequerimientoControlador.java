package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.RequerimientosCompra;

import ec.edu.ups.dao.RequerimientosCompraDAO;

/**
 * Servlet implementation class RegistrarRequerimientoControlador
 */
@WebServlet("/RegistrarRequerimientoControlador")
public class RegistrarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequerimientosCompraDAO requerimientosDAO;	
    private RequerimientosCompra requerimiento;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarRequerimientoControlador() {
    	requerimientosDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
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
		String url=null;
		int id, cant;
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/register_req.jsp";
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("cant").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("id"));
			cant = Integer.valueOf(request.getParameter("cant"));
			
			try {
				
				requerimiento = new RequerimientosCompra(Integer.valueOf(session.getAttribute("id").toString()), Integer.valueOf(session.getAttribute("empresa_id").toString()), "N", id, cant);
				
				
				requerimientosDAO.create(requerimiento);
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
