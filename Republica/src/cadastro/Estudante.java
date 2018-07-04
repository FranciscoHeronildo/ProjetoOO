package cadastro;

import java.text.DecimalFormat;

public class Estudante {
	String nome;
	String email;
	float rendimentos;
	DecimalFormat df = new DecimalFormat(",##0.##");

	
	public Estudante(String nome, String email, float rendimentos) {
		this.nome = nome;
		this.email = email;
		this.rendimentos = rendimentos;
	}

	public float getRendimentos() {
		return rendimentos;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRendimentos(float rendimentos) {
		this.rendimentos = rendimentos;
	}

	public String getNome() {
		return nome;
	}
	
	public String toString() {
		String resposta = "";
		resposta += "Nome: " + getNome() +'\n';
		resposta += "Email: " + getEmail() +'\n';
		resposta += "Rendimento: R$ " + df.format(getRendimentos()) + '\n';
		
		return resposta;
	}

}
