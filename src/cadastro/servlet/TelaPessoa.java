package cadastro.servlet;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import cadastro.modelo.Pessoa;

public interface TelaPessoa {
	
	public void apresentarCadastro(Pessoa pessoa, PrintWriter saida);
	
	public void apresentarConfirmacao(Pessoa pessoa, PrintWriter saida, HttpServletRequest request);
	
	public String getProximaTela();
	
	public Pessoa getPessoa(String nome, boolean genero, LocalDateTime dataNascimento, 
			String endereco, String telefone, String email, String matricula);
}