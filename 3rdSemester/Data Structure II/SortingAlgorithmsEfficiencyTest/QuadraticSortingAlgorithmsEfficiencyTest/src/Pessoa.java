
public class Pessoa {

	private String nome;
	private double salario;

	public Pessoa(String nome, double salario) {

		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		
		return nome + " - " + salario;
	}

}
