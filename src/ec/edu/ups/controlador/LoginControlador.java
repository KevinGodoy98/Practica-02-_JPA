package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private String usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
    	usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
    	usuario = "";
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
		try {
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			
			usuario = usuarioDAO.login(mail, pass);
			System.out.println(usuario);
			if (usuario.equals("U")) {
				//request.setAttribute("usuario", usuario);
				System.out.println(usuario);
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/index1.html";
			} else if (usuario.equals("A")){
				//request.setAttribute("usuario", usuario);
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/index.html";
			} else {
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/login.html";
			}
			
		} catch (Exception e) {
			url = "/startbootstrap-sb-admin-gh-pages/dist/login.html";
			System.out.println("INTERNAL ERROR");
			System.out.println(e.getMessage());
		}
		httpResponse.sendRedirect(url);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//getServletContext().getRequestDispatcher("Served at: ").forward(request, response);
	}

}
