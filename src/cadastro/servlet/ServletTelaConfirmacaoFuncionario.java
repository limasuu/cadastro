package cadastro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.modelo.Funcionario;

@WebServlet("/ServletTelaConfirmacaoFuncionario")
public class ServletTelaConfirmacaoFuncionario extends HttpServlet {
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
		String cargo= request.getParameter("campo-cargo");
		String setor= request.getParameter("campo-setor");
		int diaContratacao= Integer.parseInt(request.getParameter("campo-contratacao-dia"));
		int mesContratacao= Integer.parseInt(request.getParameter("campo-contratacao-mes"));
		int anoContratacao= Integer.parseInt(request.getParameter("campo-contratacao-ano"));
		double salario= Double.parseDouble(request.getParameter("campo-salario"));
	
		Funcionario funcionario= new Funcionario(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula, cargo, setor, 
				LocalDateTime.of(anoContratacao, mesContratacao, diaContratacao, 0, 0),  salario);
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	
		
		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			
		
		saida.write("<body>");		
		
		saida.write("<h1>Cadastro concluido!</h1>");
		
		saida.write("<p>Nome: " + funcionario.getNome() + " | ");
		saida.write(funcionario.getStringGenero() + " | ");
		saida.write("Data de nascimento: " + funcionario.getStringDataNascimento() + "</p>");
		saida.write("<p>Endereco: " + funcionario.getEndereco() + "</p>");	
		saida.write("<p>Telefone: " + funcionario.getTelefone() + " | ");	
		saida.write("E-mail: " + funcionario.getEmail() + "</p>");	
		saida.write("<p>Matricula: " + funcionario.getMatricula() + " | ");	
		saida.write(funcionario.getCargo() + " | ");
		saida.write("Setor: " + funcionario.getSetor() + "</p>");
		saida.write("<p>Data de contratacao: " + funcionario.getStringDataNascimento() + " | ");
		saida.write("Salario: R$" + funcionario.getStringSalario() + "</p>");
		
		saida.write("</body>");
		saida.write("</html>");
		
		saida.close();
	}
}
