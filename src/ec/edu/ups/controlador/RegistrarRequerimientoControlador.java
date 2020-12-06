package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Empresa;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;
import ups.edu.ec.modelo.Usuario;

/**
 * Servlet implementation class RegistrarRequerimientoControlador
 */
@WebServlet("/RegistrarRequerimientoControlador")
public class RegistrarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequerimientosCompraDAO requerimientosDAO;	
    private ProductoDAO proDAO;
    private UsuarioDAO usuDAO;
    private EmpresaDAO empDAO;
    private RequerimientosCompra requerimiento;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarRequerimientoControlador() {
    	requerimientosDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
    	proDAO = DAOFactory.getFactory().getProductoDAO();
    	usuDAO = DAOFactory.getFactory().getUsuarioDAO();
    	empDAO = DAOFactory.getFactory().getEmpresaDAO();
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
		int cant;
		Producto pro;
		Usuario usu;
		Empresa emp;
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
			
			pro = proDAO.read(Integer.valueOf(request.getParameter("id")));
			usu = usuDAO.read(Integer.valueOf(request.getParameter("usuario_id")));
			emp = empDAO.read(Integer.valueOf(request.getParameter("empresa_id")));
			cant = Integer.valueOf(request.getParameter("cant"));
			
			try {
				
				requerimiento = new RequerimientosCompra(usu, emp, "N", pro, cant);
				
				
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
