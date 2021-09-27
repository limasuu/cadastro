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

@WebServlet("/ServletTelaCadastroProfessor")
public class ServletTelaCadastroProfessor extends HttpServlet {
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
		
		String cargo= request.getParameter("campo-cargo");
		String setor= request.getParameter("campo-setor");
		int diaContratacao= Integer.parseInt(request.getParameter("campo-contratacao-dia"));
		int mesContratacao= Integer.parseInt(request.getParameter("campo-contratacao-mes"));
		int anoContratacao= Integer.parseInt(request.getParameter("campo-contratacao-ano"));
		double salario= Double.parseDouble(request.getParameter("campo-salario"));
		
		Funcionario funcionario= new Funcionario(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula, cargo, setor, 
				LocalDateTime.of(anoContratacao, mesContratacao, diaContratacao, 0, 0), salario);
		
		String proximaTela= "ServletTelaConfirmacaoCadastro";
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	
		
		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			
		
		saida.write("<body>");		
		
		saida.write("<h1>Cadastro</h1>");
				
		saida.write("<form action=\"" + proximaTela + "\">");
		
		saida.write("<input type=\"hidden\" name=\"campo-nome\" value=\"" + funcionario.getNome() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-genero\" value=\"" + funcionario.getGenero() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-dia\" value=\"" + funcionario.getDataNascimento().getDayOfMonth() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-mes\" value=\"" + funcionario.getDataNascimento().getMonthValue() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-ano\" value=\"" + funcionario.getDataNascimento().getYear() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-endereco\" value=\"" + funcionario.getEndereco() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-telefone\" value=\"" + funcionario.getTelefone() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-email\" value=\"" + funcionario.getEmail() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-matricula\" value=\"" + funcionario.getMatricula() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-tipo-pessoa\" value=\"" + tipoPessoa + "\"/>");
		
		saida.write("<input type=\"hidden\" name=\"campo-cargo\" value=\"" + funcionario.getCargo() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-setor\" value=\"" + funcionario.getSetor() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-contratacao-dia\" value=\"" + funcionario.getDataContratacao().getDayOfMonth() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-contratacao-mes\" value=\"" + funcionario.getDataContratacao().getMonthValue() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-contratacao-ano\" value=\"" + funcionario.getDataContratacao().getYear() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-salario\" value=\"" + funcionario.getSalario() + "\"/>");

		saida.write("<label for=\"campo-disciplina\" class=\"descricao-campo\">Disciplina</label>");
		saida.write("<input type=\"text\" name=\"campo-disciplina\" class=\"campo\"/>");
		
		saida.write("<label for=\"campo-turmas\" class=\"descricao-campo\">Turmas</label>");
		saida.write("<input type=\"text\" name=\"campo-turmas\" class=\"campo\"/><br/><br/>");
		
		saida.write("<button type=\"submit\">Proxima pagina</button>");

		saida.write("</form>");
		
		saida.write("</body>");
		saida.write("</html>");
		
		saida.close();
	}
}
