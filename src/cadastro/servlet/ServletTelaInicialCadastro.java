package cadastro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.modelo.Pessoa;

@WebServlet("/ServletTelaInicialCadastro")
public class ServletTelaInicialCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter saida= response.getWriter();
		
		String nome= request.getParameter("campo-nome");
		boolean genero= Boolean.parseBoolean(request.getParameter("campo-genero"));
		int diaNascimento= Integer.parseInt(request.getParameter("campo-nascimento-dia"));
		int mesNascimento= Integer.parseInt(request.getParameter("campo-nascimento-mes"));
		int anoNascimento= Integer.parseInt(request.getParameter("campo-nascimento-ano"));
		String endereco= request.getParameter("campo-endereco");
		String telefone= request.getParameter("campo-telefone");
		String email= request.getParameter("campo-email");
		String matricula= request.getParameter("campo-matricula");		
		String tipoPessoa= request.getParameter("campo-tipo-pessoa");
							
		Pessoa pessoa= new Pessoa(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula);
		TelaTipoPessoa telaTipoPessoa= TelaTipoPessoa.getValue(tipoPessoa);
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	
		
		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			
		
		saida.write("<body>");		
		
		saida.write("<h1>Cadastro</h1>");
				
		telaTipoPessoa.apresentarCadastro(pessoa, saida);
		
		saida.write("</body>");
		saida.write("</html>");
		
		saida.close();
	}
}
