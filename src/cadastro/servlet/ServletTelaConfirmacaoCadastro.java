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

@WebServlet("/ServletTelaConfirmacaoCadastro")
public class ServletTelaConfirmacaoCadastro extends HttpServlet {
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

		TelaTipoPessoa telaTipoPessoa= TelaTipoPessoa.getValue(tipoPessoa);
		Pessoa pessoa= telaTipoPessoa.getPessoa(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula);

		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	

		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			

		saida.write("<body>");		

		saida.write("<h1>Cadastro concluido!</h1>");

		saida.write("<p>Nome: " + pessoa.getNome() + " | ");
		saida.write(pessoa.getStringGenero() + " | ");
		saida.write("Data de nascimento: " + pessoa.getStringDataNascimento() + "</p>");
		saida.write("<p>Endereco: " + pessoa.getEndereco() + "</p>");	
		saida.write("<p>Telefone: " + pessoa.getTelefone() + " | ");	
		saida.write("E-mail: " + pessoa.getEmail() + "</p>");	
		saida.write("<p>Matricula: " + pessoa.getMatricula() + " | ");	

		telaTipoPessoa.apresentarConfirmacao(pessoa, saida, request);

		saida.write("</body>");
		saida.write("</html>");

		saida.close();
	}
}
