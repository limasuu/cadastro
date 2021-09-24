package cadastro.servlet;

import java.io.PrintWriter;

import cadastro.modelo.Pessoa;

public enum TelaTipoPessoa implements TelaPessoa{
	
	ALUNO("aluno"){
		
		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {
						
			saida.write("<form action=\"ServletTelaFinalCadastroAluno\">");	
			
			saida.write("<input type=\"hidden\" name=\"campo-nome\" value=\"" + pessoa.getNome() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-genero\" value=\"" + pessoa.getGenero() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-dia\" value=\"" + pessoa.getDataNascimento().getDayOfMonth() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-mes\" value=\"" + pessoa.getDataNascimento().getMonthValue() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-nascimento-ano\" value=\"" + pessoa.getDataNascimento().getYear() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-endereco\" value=\"" + pessoa.getEndereco() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-telefone\" value=\"" + pessoa.getTelefone() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-email\" value=\"" + pessoa.getEmail() + "\"/>");
			saida.write("<input type=\"hidden\" name=\"campo-matricula\" value=\"" + pessoa.getMatricula() + "\"/>");
		
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
			saida.write("<input type=\"text\" name=\"campo-turma\" class=\"campo\"/>");
		
			saida.write("<button type=\"submit\">Concluir cadastro</button>");
		
			saida.write("</form>");
		}
	},	
	PROFESSOR("professor"){
		
		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {
			
			
		}
	},	
	FUNCIONARIO("funcionario"){
		
		@Override
		public void apresentarCadastro(Pessoa pessoa, PrintWriter saida) {
			
			
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
