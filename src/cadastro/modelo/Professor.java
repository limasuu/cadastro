package cadastro.modelo;

import java.time.LocalDateTime;

public class Professor extends Funcionario{
	
	private String disciplina;
	private String turmas;
	
	public Professor(String nome, boolean genero, LocalDateTime dataNascimento, 
			String endereco, String telefone, String email, String matricula, 
			String cargo, String setor, LocalDateTime dataContratacao, double salario,
			String disciplina, String turmas) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula, 
				cargo, setor, dataContratacao, salario);
		this.disciplina = disciplina;
		this.turmas = turmas;
	}
	
	public Professor(String nome, boolean genero, LocalDateTime dataNascimento, 
			String endereco, String telefone, String email, String matricula) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula);
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getTurmas() {
		return turmas;
	}

	public void setTurmas(String turmas) {
		this.turmas = turmas;
	}
	 
	@Override
	public String toString() {

		return super.toString() +
				"\nDisciplina= " + disciplina + " | Turmas= " + turmas;		
	}
}