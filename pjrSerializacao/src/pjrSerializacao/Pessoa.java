package pjrSerializacao;

import java.io.Serializable;
public class Pessoa implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	private String nome;
	private int idade;
	private transient String cpf;
	
	public Pessoa(String nome, int idade, String cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", CPF=" + cpf + "]";
	}
	
		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}
		public int getIdade() {return idade;}
		public void setIdade(int idade) {this.idade = idade;}
		public String getCPF() {return cpf;}
		public void setCPF(String cpf) {this.cpf = cpf;}	
}

