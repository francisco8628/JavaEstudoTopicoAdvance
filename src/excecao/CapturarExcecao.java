package excecao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/capturarExcecao")
public class CapturarExcecao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CapturarExcecao() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String valor = request.getParameter("valorParam");
			
			Integer.parseInt(valor);
			
			response.setStatus(200);//ok
			response.getWriter().write("processada com sucesso");
			
		} catch (Exception e) {
			response.setStatus(500);//error interno do servidor
			response.getWriter().write("erro ao processar: "+ e.getMessage());
		}
		
	}

}
