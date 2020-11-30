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
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.RequerimientosCompra;

/**
 * Servlet implementation class ListarRequerimientosControlador
 */
@WebServlet("/RequerimientosControlador")
public class ListarRequerimientosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRequerimientosControlador() {
        super();
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
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.request = request;
		this.response = response;
		ListarRequerimiento();
	}
	
	private void ListarRequerimiento() {
		
		 System.out.println("llamado");
	     
	      Object[] objs = new Object[2];
		  objs[0] = false;
			RequerimientosCompraDAO requerimientosDao = DAOFactory.getFactory().getRequerimientosCompraDAO();
			List<RequerimientosCompra> lstRequerimientos = new ArrayList<>(requerimientosDao.find());
			System.out.println("TESTING -->"+lstRequerimientos);
			objs[1] = lstRequerimientos;
			try {
				if(lstRequerimientos.size()==0) {
					//System.out.println("llega");
					request.setAttribute("error", new ups.edu.ec.modelo.Error("Error al obtener la lista de Requerimientos."));
					despacharPeticiones();
				}else {
				    request.setAttribute("error", null);
					request.setAttribute("lstRequerimientos", lstRequerimientos);//Dame 1 min le reviso xq se manda un string o
				
					despacharPeticiones();
				}
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			;
	}
	private void despacharPeticiones() throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuarioAdmin.jsp").forward(request, response);
	}

}
