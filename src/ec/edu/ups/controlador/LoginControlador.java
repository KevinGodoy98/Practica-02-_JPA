package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;

/**
 * Servlet implementation class LoginControlador
 */
@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDAO;   
    private Usuario usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
    	usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
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
		String url = null;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session;
		
		try {
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			
			usuario = usuarioDAO.login(mail, pass);
			
			session = request.getSession(true);
			session.setAttribute("rol", usuario.getRol());
			session.setAttribute("id", usuario.getId());
			session.setAttribute("empresa_id", usuario.getEmpresa_id());
			session.setAttribute("nombre", usuario.getNombre()+" "+usuario.getApellido());
			
			request.setAttribute("nombre", usuario.getNombre()+" "+usuario.getApellido());
			
			if (usuario.getRol().equals("U")) {
				//request.setAttribute("usuario", usuario);
				url = "/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			} else if (usuario.getRol().equals("U")){
				//request.setAttribute("usuario", usuario);
				url = "/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			} else {
				
				request.setAttribute("mensaje", "(!) Usuario no registrado");
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/login.jsp";
				httpResponse.sendRedirect(url);
			}
			
		} catch (Exception e) {
			request.setAttribute("mensaje", "(!) Usuario no registrado");
			url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/login.html";
			httpResponse.sendRedirect(url);
			System.out.println("INTERNAL ERROR");
			System.out.println(e.getMessage());
		}
		
	}

}
