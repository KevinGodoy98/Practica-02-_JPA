package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;



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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     
		this.request = request;
		this.response = response;
		ListarProducto();
	}
	
	private void ListarProducto() {
		
		 System.out.println("llamado");
	     
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

}
