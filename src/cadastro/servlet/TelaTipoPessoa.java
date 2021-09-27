package cadastro.servlet;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import cadastro.modelo.Aluno;
import cadastro.modelo.Funcionario;
import cadastro.modelo.Pessoa;
import cadastro.modelo.Professor;

public enum TelaTipoPessoa implements TelaPessoa{

	ALUNO("aluno"){

		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {

			saida.write("<input type=\"hidden\" name=\"campo-nome\" value=\"" + pessoa.getNome() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-genero\" value=\"" + pessoa.getGenero() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-dia\" value=\"" + pessoa.getDataNascimento().getDayOfMonth() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-mes\" value=\"" + pessoa.getDataNascimento().getMonthValue() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-ano\" value=\"" + pessoa.getDataNascimento().getYear() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-endereco\" value=\"" + pessoa.getEndereco() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-telefone\" value=\"" + pessoa.getTelefone() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-email\" value=\"" + pessoa.getEmail() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-matricula\" value=\"" + pessoa.getMatricula() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-tipo-pessoa\" value=\"" + getTipoPessoa() + "\"/>");
			
			saida.write("<label for=\"campo-serie\" class=\"descricao-campo\">Serie</label>");	
			saida.write("<select name=\"campo-serie\" class=\"descricao-campo\">");
			saida.write("<option value=\"1\" select=\"selected\">Primeiro ano</option>");
			saida.write("<option value=\"2\" select=\"selected\">Segundo ano</option>");
			saida.write("<option value=\"3\" select=\"selected\">Terceiro ano</option>");
			saida.write("<option value=\"4\" select=\"selected\">Quarto ano</option>");
			saida.write("<option value=\"5\" select=\"selected\">Quinto ano</option>");
			saida.write("<option value=\"6\" select=\"selected\">Sexto ano</option>");
			saida.write("<option value=\"7\" select=\"selected\">Setimo ano</option>");
			saida.write("<option value=\"8\" select=\"selected\">Oitavo ano</option>");
			saida.write("<option value=\"9\" select=\"selected\">Nono ano</option>");		
			saida.write("</select>");
			saida.write("<label for=\"campo-turma\" class=\"descricao-campo\">Turma</label>");	
			saida.write("<input type=\"text\" name=\"campo-turma\" class=\"campo\"/><br/><br/>");
		}

		@Override
		public void apresentarConfirmacao(Pessoa pessoa, PrintWriter saida, HttpServletRequest request) {
			
			int serie= Integer.parseInt(request.getParameter("campo-serie"));
			String turma= request.getParameter("campo-turma");	
			
			Aluno aluno= (Aluno) pessoa;
			aluno.setSerie(serie);
			aluno.setTurma(turma);
			
			saida.write("Serie: " + aluno.getSerie() + " | ");
			saida.write("Turma: " + aluno.getTurma() + "</p>");			
		}

		@Override
		public String getProximaTela() {

			return "ServletTelaConfirmacaoCadastro";
		}

		@Override
		public Pessoa getPessoa(String nome, boolean genero, LocalDateTime dataNascimento, String endereco,
				String telefone, String email, String matricula) {

			return new Aluno(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		}
	},	
	PROFESSOR("professor"){

		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {

			saida.write("<input type=\"hidden\" name=\"campo-tipo-pessoa\" value=\"" + getTipoPessoa() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-cargo\" value=\"" + getTipoPessoa() + "\"/>");
			
			FUNCIONARIO.apresentarCadastro(pessoa, saida);
		}

		@Override
		public void apresentarConfirmacao(Pessoa pessoa, PrintWriter saida, HttpServletRequest request) {
			
			FUNCIONARIO.apresentarConfirmacao(pessoa, saida, request);
			
			String disciplina= request.getParameter("campo-disciplina");
			String turmas= request.getParameter("campo-turmas");
			
			Professor professor= (Professor) pessoa;
			professor.setDisciplina(disciplina);
			professor.setTurmas(turmas);
			
			saida.write("<p>Disciplina: " + professor.getDisciplina() + " | ");
			saida.write("Turmas: " + professor.getTurmas() + "</p>");	
		}

		@Override
		public String getProximaTela() {

			return "ServletTelaCadastroProfessor";
		}

		@Override
		public Pessoa getPessoa(String nome, boolean genero, LocalDateTime dataNascimento, String endereco,
				String telefone, String email, String matricula) {

			return new Professor(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		}
	},	
	FUNCIONARIO("funcionario"){

		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {

			saida.write("<input type=\"hidden\" name=\"campo-nome\" value=\"" + pessoa.getNome() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-genero\" value=\"" + pessoa.getGenero() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-dia\" value=\"" + pessoa.getDataNascimento().getDayOfMonth() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-mes\" value=\"" + pessoa.getDataNascimento().getMonthValue() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-ano\" value=\"" + pessoa.getDataNascimento().getYear() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-endereco\" value=\"" + pessoa.getEndereco() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-telefone\" value=\"" + pessoa.getTelefone() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-email\" value=\"" + pessoa.getEmail() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-matricula\" value=\"" + pessoa.getMatricula() + "\"/>");

			if( !(pessoa instanceof Professor) ) {
				saida.write("<input type=\"hidden\" name=\"campo-tipo-pessoa\" value=\"" + getTipoPessoa() + "\"/>");
				
				saida.write("<label for=\"campo-cargo\" class=\"descricao-campo\">Cargo</label>");
				saida.write("<input type=\"text\" name=\"campo-cargo\" class=\"campo\"/><br/>");
			}

			saida.write("<label for=\"campo-setor\" class=\"descricao-campo\">Setor</label>");
			saida.write("<input type=\"text\" name=\"campo-setor\" class=\"campo\"/><br/>");			
			saida.write("<label for=\"campo-contratacao-dia\" class=\"descricao-campo\">Data de contratacao</label>");
			saida.write("<input type=\"text\" name=\"campo-contratacao-dia\" class=\"campo\"/>");
			saida.write("<input type=\"text\" name=\"campo-contratacao-mes\" class=\"campo\"/>");
			saida.write("<input type=\"text\" name=\"campo-contratacao-ano\" class=\"campo\"/><br/>");
			saida.write("<label for=\"campo-salario\" class=\"descricao-campo\">Salario</label>");
			saida.write("<input type=\"text\" name=\"campo-salario\" class=\"descricao-campo\"/><br/><br/>");			
		}

		@Override
		public void apresentarConfirmacao(Pessoa pessoa, PrintWriter saida, HttpServletRequest request) {
			
			String cargo= request.getParameter("campo-cargo");
			String setor= request.getParameter("campo-setor");
			int diaContratacao= Integer.parseInt(request.getParameter("campo-contratacao-dia"));
			int mesContratacao= Integer.parseInt(request.getParameter("campo-contratacao-mes"));
			int anoContratacao= Integer.parseInt(request.getParameter("campo-contratacao-ano"));
			double salario= Double.parseDouble(request.getParameter("campo-salario"));
		
			Funcionario funcionario= (Funcionario) pessoa;
			funcionario.setCargo(cargo);
			funcionario.setSetor(setor);
			funcionario.setDataContratacao(LocalDateTime.of(anoContratacao, mesContratacao, diaContratacao, 0, 0));
			funcionario.setSalario(salario);
			
			saida.write(funcionario.getCargo() + " | ");
			saida.write("Setor: " + funcionario.getSetor() + "</p>");
			saida.write("<p>Data de contratacao: " + funcionario.getStringDataContratacao() + " | ");
			saida.write("Salario: R$" + funcionario.getStringSalario() + "</p>");
		}

		@Override
		public String getProximaTela() {

			return "ServletTelaConfirmacaoCadastro";
		}

		@Override
		public Pessoa getPessoa(String nome, boolean genero, LocalDateTime dataNascimento, String endereco,
				String telefone, String email, String matricula) {

			return new Funcionario(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		}
	};

	private String tipoPessoa;

	private TelaTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public static TelaTipoPessoa getValue(String tipoPessoa) {

		for(TelaTipoPessoa tipo : values())
			if(tipoPessoa.equals(tipo.getTipoPessoa()))
				return tipo;

		return null;
	}
}