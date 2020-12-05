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

/**
 * Servlet implementation class AceptarRequerimientoControlador
 */
@WebServlet("/AceptarRequerimientoControlador")
public class AceptarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientosCompraDAO requerimientosDAO;
	private RequerimientosCompra requerimiento;
	private RequerimientosCompraDAO requerimientoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarRequerimientoControlador() {
    	requerimientoDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
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
		
		String url, mensaje;
		boolean flag=false;
		int id;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Ingrese un ID");
			flag = true;
		}
		
		if (flag==false) {
			
			try {
				id = Integer.valueOf(request.getParameter("id"));
				requerimiento = requerimientoDAO.read(id);
				
				if (request.getParameter("apr") != null) {
					requerimiento.setEstado("A");
				} else if (request.getParameter("rec") != null) {
					requerimiento.setEstado("R");
				}
				
				System.out.println(requerimiento.getEstado());
				requerimientoDAO.update_estado(requerimiento);
				
				if(session.getAttribute("rol").toString().equals("U")) {
					
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
					httpResponse.sendRedirect(url);
				} else {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
					httpResponse.sendRedirect(url);
				}
				
			} catch (Exception e) {
				request.setAttribute("mensaje", "(!) Hubo un Error");
				url = "/Practica_laboratorio_1/ListarRequerimientosControlador?dir=c";
				httpResponse.sendRedirect(url);
			}
			
		} else {
			url = "/Practica_laboratorio_1/ListarRequerimientosControlador?dir=c";
			httpResponse.sendRedirect(url);
		}
		
		
		
	}

}
