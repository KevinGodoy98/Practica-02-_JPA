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
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Empresa;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;
import ups.edu.ec.modelo.Usuario;

/**
 * Servlet implementation class ListarEmpresaControlador
 */
@WebServlet("/ListarEmpresaControlador")
public class ListarEmpresaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
	private Empresa empresa;
    

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarEmpresaControlador() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		String url = null;
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		Object mostrar = request.getParameter("mostrarPrincipalListaEmpr");
		List<Empresa> em = new ArrayList<Empresa>();

		
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("Id usuario: " + String.valueOf(sesion.getId()));

		if (mostrar.equals("visualizar")) {
			try {
			
				em = usuarioDao.listarEmpresa();

				request.setAttribute("empresa", em);				

				url="/Practica_laboratorio_1/WebContent/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
			} catch (Exception e) {
				url="/Practica_laboratorio_1/WebContent/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
				System.out.println("Error en el login: " + e.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
			
		}


		doGet(request, response);
	}	*/
System.out.println(request.getParameter("emp"));
		
		String url, descripcion, nombre, precio, ruc, emp;
		int id, catg;
		boolean flag = false;
		
		HttpSession session = request.getSession(true);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		url = "/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
		
		if(request.getParameter("id").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("nombre").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("ruc").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		
		
		if(flag==false) {
			
			id = Integer.valueOf(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			ruc = request.getParameter("ruc");
			//empresa = Integer.valueOf(session.getAttribute("empresa_id").toString());
			emp = (request.getParameter("categ"));
			descripcion = request.getParameter("descrip");
		
			
			try {
				
				empresa = new Empresa(id, nombre, ruc);
				empresaDAO.create(empresa);
				//requerimientosDAO.create(requerimiento);
				//request.setAttribute("Mensaje", "Requerimiento agragado");
				
				if(session.getAttribute("rol").toString().equals("U")) {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
					httpResponse.sendRedirect(url);
				} else {
					url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/public/home.jsp";
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
