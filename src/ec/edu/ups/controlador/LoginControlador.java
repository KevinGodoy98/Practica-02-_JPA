package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;

/**
 * Servlet implementation class LoginControlador
 */
@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDAO;   
    private boolean usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
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
		String url = null;
		try {
			String mail = request.getParameter("id");
			String pass = request.getParameter("pass");
			usuario = usuarioDAO.login(mail, pass);
			
			if (usuario==true) {
				//request.setAttribute("usuario", usuario);
				url = "/startbootstrap-sb-admin-gh-pages/dist/index1.html";
			} else {
				url = "/startbootstrap-sb-admin-gh-pages/dist/login.html";
			}
			
		} catch (Exception e) {
			System.out.println("INTERNAL ERROR");
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
