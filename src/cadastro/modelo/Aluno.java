package cadastro.modelo;

import java.time.LocalDateTime;

public class Aluno extends Pessoa{

	private int serie;
	private String turma;
	
	public Aluno(String nome, boolean genero, LocalDateTime dataNascimento, String endereco, String telefone,
			String email, String matricula, int serie, String turma) {
		
		super(nome, genero, dataNascimento, endereco, telefone, email, matricula);
		this.serie = serie;
		this.turma = turma;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return super.toString() +
				" | Série: " + serie + " | Turma: " + turma;
	}
}
