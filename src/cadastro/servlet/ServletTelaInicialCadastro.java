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
							
		TelaTipoPessoa telaTipoPessoa= TelaTipoPessoa.valueOf(tipoPessoa);
		Pessoa pessoa= telaTipoPessoa.getPessoa(nome, genero, 
				LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0), 
				endereco, telefone, email, matricula);		
		String proximaTela= telaTipoPessoa.getProximaTela();
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	
		
		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Cadastro</title>");	
		saida.write("</head>");			
		
		saida.write("<body>");		
		
		saida.write("<h1>Cadastro</h1>");
				
		saida.write("<form action=\"" + proximaTela + "\">");
		
		saida.write("<input type=\"hidden\" name=\"campo-nome\" value=\"" + pessoa.getNome() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-genero\" value=\"" + pessoa.getGenero() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-dia\" value=\"" + pessoa.getDataNascimento().getDayOfMonth() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-mes\" value=\"" + pessoa.getDataNascimento().getMonthValue() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-nascimento-ano\" value=\"" + pessoa.getDataNascimento().getYear() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-endereco\" value=\"" + pessoa.getEndereco() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-telefone\" value=\"" + pessoa.getTelefone() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-email\" value=\"" + pessoa.getEmail() + "\"/>");
		saida.write("<input type=\"hidden\" name=\"campo-matricula\" value=\"" + pessoa.getMatricula() + "\"/>");
		
		telaTipoPessoa.apresentarCadastro(pessoa, saida);
		
		saida.write("<button type=\"submit\">Proxima pagina</button>");

		saida.write("</form>");
		
		saida.write("</body>");
		saida.write("</html>");
		
		saida.close();
	}
}