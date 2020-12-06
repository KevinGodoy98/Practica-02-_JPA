package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.Categoria;

/**
 * Servlet implementation class ListarProductoEmpresaControlador
 */
@WebServlet("/ListarProductoEmpresaControlador")
public class ListarProductoEmpresaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
	private CategoriaDAO categoriaDAO;
	private Categoria cat;
	private Producto pro;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductoEmpresaControlador() {
    	productoDAO = DAOFactory.getFactory().getProductoDAO();
    	categoriaDAO = DAOFactory.getFactory().getCategoriaDAO();
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
		
		String url=null;
		int id;
		
		List<Producto> pr = new ArrayList<Producto>();
		List<String> ct = new ArrayList<>();
		
		try {
			
			id = Integer.valueOf(request.getParameter("id").toString());		
			pr = productoDAO.find_emp(id);
			url = "/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
			
			for (Producto p : pr) {
				cat = categoriaDAO.read(p.getCategoria_id());
				ct.add(cat.getNombre());	
			}
			
			request.setAttribute("productos", pr);
			request.setAttribute("categorias", ct);
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("ERROR "+e.getMessage());
		}
		
	}

}
