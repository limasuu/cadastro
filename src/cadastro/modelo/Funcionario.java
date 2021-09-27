package cadastro.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String cargo;
	private String setor;
	private LocalDateTime dataContratacao;
	private double salario;
	
	public Funcionario(String nome, boolean genero, LocalDateTime dataNascimento, 
			String endereco, String telefone, String email, String matricula, 
			String cargo, String setor, LocalDateTime dataContratacao, double salario) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		this.cargo = cargo;
		this.setor = setor;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
	}
	
	public Funcionario(String nome, boolean genero, LocalDateTime dataNascimento, 
			String endereco, String telefone, String email, String matricula) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public LocalDateTime getDataContratacao() {
		return dataContratacao;
	}
	
	public String getStringDataContratacao() {
		return dataContratacao.format(formatter);
	}

	public void setDataContratacao(LocalDateTime dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getSalario() {
		return salario;
	}
	
	public String getStringSalario() {
		return String.format("%.2f", salario);
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				" | Cargo: " + cargo + " | Setor: " + setor +
				"Data da contratação: " + getStringDataContratacao() + " | Salário: " + getStringSalario();
	}
}