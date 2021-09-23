package cadastro.modelo;

import java.time.LocalDateTime;

public class Funcionario extends Pessoa{
	
	private String cargo;
	private String setor;
	private LocalDateTime dataContratacao;
	private double salario;
	
	public Funcionario(String nome, boolean genero, LocalDateTime dataNascimento, String endereco, String telefone,
			String email, String matricula, String cargo, String setor, LocalDateTime dataContratacao, double salario) {
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		this.cargo = cargo;
		this.setor = setor;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
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

	public void setDataContratacao(LocalDateTime dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				" | Cargo=" + cargo + " | Setor= " + setor +
				"Data da contratação= " + dataContratacao + " | Salário= " + salario;
	}
}
