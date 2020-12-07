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

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;
/**
 * Servlet implementation class ListarRequerimientosControlador
 */
@WebServlet("/ListarRequerimientosControlador")
public class ListarRequerimientosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequerimientosCompraDAO requerimientosDAO;
	private ProductoDAO proDAO;
	private Producto pro; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRequerimientosControlador() {
    	requerimientosDAO = DAOFactory.getFactory().getRequerimientosCompraDAO();
    	proDAO = DAOFactory.getFactory().getProductoDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dir;
		String url=null;
		HttpSession session = request.getSession(true);
		
		List<RequerimientosCompra> rq = new ArrayList<RequerimientosCompra>();
		List<String> productos = new ArrayList<>();
		
		dir = request.getParameter("dir").toString();
		
		if (dir.equals("a")) {
			url = "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuario.jsp";
			rq = requerimientosDAO.find_usuario(Integer.valueOf(session.getAttribute("id").toString()));
		} else if (dir.equals("b")) {
			url = "/startbootstrap-sb-admin-gh-pages/dist/private/modificar_req.jsp";
			rq = requerimientosDAO.find_usuario(Integer.valueOf(session.getAttribute("id").toString()));
		} else if (dir.equals("c")) {
			url = "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuarioAdmin.jsp";
			rq = requerimientosDAO.find_empresa(Integer.valueOf(session.getAttribute("empresa_id").toString()));
			
		}
		
		try {
				
			for (RequerimientosCompra req : rq) {
				pro = proDAO.read(req.getProducto().getId());
				productos.add(pro.getNombre());	
			}
			
			request.setAttribute("requerimientos", rq);
			request.setAttribute("productos", productos);
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("ERROR "+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				
	}

}
