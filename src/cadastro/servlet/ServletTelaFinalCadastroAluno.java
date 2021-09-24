package cadastro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.modelo.Aluno;

@WebServlet("/ServletTelaFinalCadastroAluno")
public class ServletTelaFinalCadastroAluno extends HttpServlet {
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
		int serie= Integer.parseInt(request.getParameter("campo-serie"));
		String turma= request.getParameter("campo-turma");	
		
		Aluno aluno= new Aluno(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula, serie, turma);
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	
		
		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			
		
		saida.write("<body>");		
		
		saida.write("<h1>Cadastro concluido!</h1>");
		
		saida.write("<p>Nome: " + aluno.getNome() + " | ");
		saida.write(aluno.getStringGenero() + " | ");
		saida.write("Data de nascimento: " + aluno.getStringDataNascimento() + "</p>");
		saida.write("<p>Endereco: " + aluno.getEndereco() + "</p>");	
		saida.write("<p>Telefone: " + aluno.getTelefone() + " | ");	
		saida.write("E-mail: " + aluno.getEmail() + "</p>");	
		saida.write("<p>Matricula: " + aluno.getMatricula() + " | ");	
		saida.write("Serie: " + aluno.getSerie() + "º ano | ");
		saida.write("Turma: " + aluno.getTurma() + "</p>");
		
		saida.write("</body>");
		saida.write("</html>");
		
		saida.close();
	}
}
