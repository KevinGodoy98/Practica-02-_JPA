package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;
/**
 * Servlet implementation class ActualizarRequerimientoControlador
 */
@WebServlet("/ActualizarRequerimientoControlador")
public class ActualizarRequerimientoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientosCompraDAO requerimientoDAO;
	private ProductoDAO productoDAO;
    private RequerimientosCompra requerimiento, aux;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarRequerimientoControlador() {
    	requerimientoDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url;
		int id, cant;
		Producto pro;
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/private/modificar_req.jsp";
		System.out.println();
		id = Integer.valueOf(request.getParameter("id_req"));
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("cant").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if (flag==false) {
			
			try {			
				
				pro = productoDAO.read(Integer.valueOf(request.getParameter("id")));
				cant = Integer.valueOf(request.getParameter("cant"));				
				
				aux = requerimientoDAO.read(id);
				
				
				if (aux.getEstado().equals("N") || aux.getEstado().equals("R")) {
					
					requerimiento = new RequerimientosCompra(aux.getId(),aux.getUsuario(), aux.getEmpresa(), aux.getEstado(), pro, cant);
					System.out.println(requerimiento);
					requerimientoDAO.update(requerimiento);
					
					if(session.getAttribute("rol").toString().equals("U")) {
						
						url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
						httpResponse.sendRedirect(url);
					} else {
						url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
						httpResponse.sendRedirect(url);
					}
					
				} else {
					
					url = "/Practica_laboratorio_1/LlenarRequerimientoControlador";
					httpResponse.sendRedirect(url+"?id="+id+"&mensaje=(!)+El+requerimiento+ya+ha+sido+aprobado");
					
				}
				
				
				
			} catch (Exception e) {
				url = "/Practica_laboratorio_1/LlenarRequerimientoControlador";
				httpResponse.sendRedirect(url+"?id="+id+"&mensaje=(!)+Ocurrio+un+errror");
			}
			
		} else {
			url = "/Practica_laboratorio_1/LlenarRequerimientoControlador";
			httpResponse.sendRedirect(url+"?id="+id+"&mensaje=(!)+Llene+todos+los+campos");
		}
		
	}

}
