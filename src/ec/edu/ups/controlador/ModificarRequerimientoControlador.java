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
 * Servlet implementation class ModificarRequerimientoControlador
 */
@WebServlet("/ModificarRequerimientoControlador")
public class ModificarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientosCompraDAO requerimientoDAO;
	private RequerimientosCompra requerimiento;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarRequerimientoControlador() {
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
		
		String url;
		boolean flag=false;
		int id;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Ingrese un ID");
			flag = true;
		}
		
		if (request.getParameter("mod") != null && flag==false) {
			
			if(session.getAttribute("rol").toString().equals("U")) {
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
				httpResponse.sendRedirect(url);
			} else {
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
				httpResponse.sendRedirect(url);
			}

	    } else if (request.getParameter("eli") != null && flag==false) {
	    	
			try {
				id = Integer.valueOf(request.getParameter("id"));
				
				requerimiento = requerimientoDAO.read(id);
				
				if(requerimiento.getUsuario_id()==Integer.valueOf(session.getAttribute("id").toString())) {
					requerimientoDAO.delete(requerimiento);
					
					if(session.getAttribute("rol").toString().equals("U")) {
						
						url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
						httpResponse.sendRedirect(url);
					} else {
						url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
						httpResponse.sendRedirect(url);
					}
					
				} else {
					
					request.setAttribute("mensaje", "(!) Ocurrio un ERROR");
					url = "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuario.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);
				
				}
				
				
			} catch (Exception e) {
				request.setAttribute("mensaje", "(!) Ocurrio un ERROR");
				url = "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuario.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			
			}
	    	
	    } else {
	    	url = "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuario.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
	    }
		
	}

}
