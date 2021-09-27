package cadastro.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStringGenero() {
		return (genero? "masculino" : "feminino");
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
	
	public String getStringDataNascimento() {
		return dataNascimento.format(formatter);
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
		return "Nome: " + nome + " | " + getStringGenero() + 
				" | Nascimento: " + getStringDataNascimento() + "\nEndereço: "
				+ endereco + "\nTelefone: " + telefone + " | E-mail: " + email +
				"\nMatrícula: " + matricula;
	}	
}