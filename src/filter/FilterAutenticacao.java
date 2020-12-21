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
	
	@Override //faz alguma coisa quando a aplica��o � derrubada
	public void destroy() {
		
	}

	@Override //intercepta todas as requesi��es
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		String urlParaAutenticar = req.getServletPath();
		
		//retorna null caso o usuario n�o esteja logado
		UserLogado userLogado =(UserLogado) session.getAttribute("usuario");
		
		if(userLogado == null&&!urlParaAutenticar.equalsIgnoreCase("/pages/ServeleAutenticacao")) {//usuario n�o logado falhou
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			
			return; //para o processo redirecionar
		}
		
		chain.doFilter(request, response); //tem que colocar esse metodo para n�o travar a aplica��o
		//System.out.println("interceptando : ");
		
	}
    
	@Override//executa alguma coisa quando a aplica��o � iniciada
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
