package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ups.edu.ec.modelo.Categoria;
import ups.edu.ec.modelo.Producto;


/**
 * Servlet implementation class ProductoControlador
 */
@WebServlet("/ProductoControlador")
public class ListarProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	private HttpServletRequest request;
	private HttpServletResponse response;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private boolean flag;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Optional<String> s = request.getParameterMap().keySet().stream().filter(e->e.contains("modificar_")).findFirst();
		if(s.isPresent()) {
			redirigirAModificar(Integer.parseInt(s.get().split("_")[1]));
			return;
		}else {
			this.request = request;
			this.response = response;
			ListarProducto();
		}
	}
	
	private void redirigirAModificar(int productoID) throws ServletException, IOException {
		ProductoDAO productoDAO = DAOFactory.getFactory().getProductoDAO();
		List<Producto> lstProductos = new ArrayList<>(productoDAO.find());
		List<Categoria> lstCategorias = DAOFactory.getFactory().getCategoriaDAO().find();
		Optional<Producto> producto = lstProductos.stream().filter(e->e.getId()==productoID).findFirst();
		
		if(producto.isPresent()){
			System.out.println("SE DEBE REDIRiGIR");
			request.setAttribute("producto_modificar", producto.get());
			request.setAttribute("catg", lstCategorias);
			despacharModificar();

		}
			
	}
	
	
	
	private void despacharModificar() throws ServletException, IOException {
		System.out.println("TESTING--->");
		getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-gh-pages/dist/private/ModificarProducto.jsp").forward(request, response);
	}
	
	private void ListarProducto() {
		
		 System.out.println("llaaaaaamado");
	     
	      Object[] objs = new Object[2];
		  objs[0] = false;
			ProductoDAO productoDAO = DAOFactory.getFactory().getProductoDAO();
			List<Producto> lstProductos = new ArrayList<>(productoDAO.find());
			System.out.println("TESTING -->"+lstProductos);
			objs[1] = lstProductos;
			try {
				if(lstProductos.size()==0) {
					//System.out.println("llega");
					request.setAttribute("error", new ups.edu.ec.modelo.Error("Error al obtener la lista de Productos."));
					despacharPeticiones();
				}else {
				    request.setAttribute("error", null);
					request.setAttribute("lstProductos", lstProductos);//Dame 1 min le reviso xq se manda un string o
				
					despacharPeticiones();
				}
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			;
	}
	
	private void despacharPeticiones() throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-gh-pages/dist/private/tablaAdmin.jsp").forward(request, response);
	}
	public void Eliminar(int id) {
			
	}
	
}
