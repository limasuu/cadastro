package cadastro.modelo;

import java.time.LocalDateTime;

public class Pessoa {
	
	private String nome;
	private boolean genero;
	private LocalDateTime dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private String matricula;
	
	public Pessoa(String nome, boolean genero, LocalDateTime dataNascimento, String endereco, String telefone, 
			String email, String matricula) {
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Nome= " + nome + " | " + genero + " | Nascimento= " + dataNascimento + "\nEndereço= "
				+ endereco + "\nTelefone= " + telefone + " | E-mail= " + email +
				"\nMatrícula= " + matricula;
	}	
}
