package Gerenciador;

public class Estudante extends Pessoa {

	public String matricula;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Estudante(String nome, int idade) {
		super(nome, idade);
		
	}

	@Override
	public String exibirDados() {
		return "Nome:"+ getNome() + "Matrícula" +getMatricula()+ "Idade" + getIdade();
		
		
	}

}
