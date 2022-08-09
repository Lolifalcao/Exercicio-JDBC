package exejdbc.entidades;

public class Aluno {
	private int id;
	private String nome;
	private String curso;
	private String periodo;
		
	public Aluno() {
		
	}
		
	public Aluno(String nome, String curso, String periodo) {
		this.nome = nome;
		this.curso = curso;
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", curso=" + curso + ", periodo=" + periodo + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
