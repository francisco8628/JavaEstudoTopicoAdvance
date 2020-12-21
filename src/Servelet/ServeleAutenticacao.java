package Servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import user.UserLogado;


@WebServlet("/pages/ServeleAutenticacao")
public class ServeleAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServeleAutenticacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(Boolean.parseBoolean(request.getParameter("deslogar"))){
			HttpServletRequest req =  (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.invalidate();
			
			//rediriciona para o login novamente
			response.sendRedirect("../index.jsp");
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url= request.getParameter("url");
		
		//neste momento pode ser feita a validaação no bando de dados
		if(login.equalsIgnoreCase("admin")&&senha.equalsIgnoreCase("123")) {//se logou 
			
			UserLogado userlogado = new UserLogado();
			userlogado.setLogin(login);
			userlogado.setSenha(senha);
			
			
			//adiciona usuario logado na sessão
			HttpServletRequest req =  (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", userlogado);
			//rediriona para a pagina
			RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}else //se o login falhou //redireciona para logim
		{   
			//redireciona para a pagina
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/autenticar.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
