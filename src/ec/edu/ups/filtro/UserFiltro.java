package ec.edu.ups.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserFiltro
 */
@WebFilter({"/UserFiltro", "/startbootstrap-sb-admin-gh-pages/dist/private/home_user.jsp", "/startbootstrap-sb-admin-gh-pages/dist/private/tablaUsuario.jsp", "/startbootstrap-sb-admin-gh-pages/dist/private/register_req.jsp", "/startbootstrap-sb-admin-gh-pages/dist/private/modificar_req.jsp", "/ActualizarRequerimientoControlador", "/LlenarRequerimientoControlador", "/ModificarRequerimientoControlador", "/RegistrarRequerimientoControlador"})
public class UserFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public UserFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String url;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		//System.out.println("!!!!");
		
		try {
			if (session.getAttribute("rol").equals("U")) {
				
				System.out.println("ACCESS " + session.getAttribute("rol"));
				chain.doFilter(request, response);
				
			} else if (session.getAttribute("rol").equals("A")){
				System.out.println(session.getAttribute("rol"));
				url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/private/home_admin.jsp";
				httpResponse.sendRedirect(url);
				System.out.println("2");
				//chain.doFilter(request, response);
			}
		} catch (Exception e) {
			// System.out.println("1");
			System.out.println(e.getMessage());
			session.invalidate();
			url = "/Practica_laboratorio_1/startbootstrap-sb-admin-gh-pages/dist/public/login.jsp";
			httpResponse.sendRedirect(url);
			//chain.doFilter(request, response);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
