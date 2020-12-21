package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import sun.rmi.server.Dispatcher;
import user.UserLogado;

@WebFilter(urlPatterns = {"/pages/*"})//autentica todas as paginas desta pasta
public class FilterAutenticacao implements Filter{
	
	@Override //faz alguma coisa quando a aplicação é derrubada
	public void destroy() {
		
	}

	@Override //intercepta todas as requesições
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		String urlParaAutenticar = req.getServletPath();
		
		//retorna null caso o usuario não esteja logado
		UserLogado userLogado =(UserLogado) session.getAttribute("usuario");
		
		if(userLogado == null&&!urlParaAutenticar.equalsIgnoreCase("/pages/ServeleAutenticacao")) {//usuario não logado falhou
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			
			return; //para o processo redirecionar
		}
		
		chain.doFilter(request, response); //tem que colocar esse metodo para não travar a aplicação
		//System.out.println("interceptando : ");
		
	}
    
	@Override//executa alguma coisa quando a aplicação é iniciada
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
