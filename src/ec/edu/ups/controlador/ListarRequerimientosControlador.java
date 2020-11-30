package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.*;

/**
 * Servlet implementation class ListarRequerimientosControlador
 */
@WebServlet("/ListarRequerimientosControlador")
public class ListarRequerimientosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRequerimientosControlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init (ServletConfig conf) throws ServletException {
    	
    }
    
    public void detroy() {
    	
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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		String url = null;
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		Object mostrar = request.getParameter("mostrarPrincipalListaReq");
		List<RequerimientosCompra> rq = new ArrayList<RequerimientosCompra>();
		List<Producto> pro = new ArrayList<Producto>();
		List<Empresa> em = new ArrayList<Empresa>();
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("Id usuario: " + String.valueOf(sesion.getId()));

		if (mostrar.equals("visualizar")) {
			try {
				rq = usuarioDao.listarRequerimientosCompra();
				pro = usuarioDao.listarProductosNum2();
				em = usuarioDao.listarEmpresa();

				request.setAttribute("requerimientos", rq);
				request.setAttribute("productos", pro);
				request.setAttribute("empresa", em);

				url="JSPs/ListarReq.jsp";
			} catch (Exception e) {
				url="JSPs/ListarReq.jsp";
				System.out.println("Error en el login: " + e.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
			
		}


		doGet(request, response);
	}

}
