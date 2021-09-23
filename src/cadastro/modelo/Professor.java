package cadastro.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Professor extends Funcionario{
	
	private String disciplina;
	private ArrayList<String> turmas= new ArrayList<String>();
	
	public Professor(String nome, boolean genero, LocalDateTime dataNascimento, String endereco, String telefone,
			String email, String matricula, String cargo, String setor, LocalDateTime dataContratacao, double salario,
			String disciplina, ArrayList<String> turmas) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula, cargo, setor, dataContratacao,
				salario);
		this.disciplina = disciplina;
		this.turmas = turmas;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<String> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<String> turmas) {
		this.turmas = turmas;
	}
	 
	@Override
	public String toString() {
		
		String retorno= super.toString() +
				"\nDisciplina= " + disciplina + " | Turmas= ";
		
		for(String turma : turmas)
			retorno+= " " + turma; 
		
		return retorno;		
	}
}
