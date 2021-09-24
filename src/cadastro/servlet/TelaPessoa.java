package cadastro.servlet;

import java.io.PrintWriter;

import cadastro.modelo.Pessoa;

public interface TelaPessoa {
	
	public void apresentarCadastro(Pessoa pessoa, PrintWriter saida);
}
