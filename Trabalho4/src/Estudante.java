
public class Estudante {
	private static String nome;
	private static String email;
	private static float rendimento;
	
	//Metodos getters and setters para nome
	public static String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		Estudante.nome = nome;
	}
	
	//Metodos getters and setters para email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		Estudante.email = email;
	}
	
	//Metodos getters and setters para rendimento
	public float getRendimento() {
		return rendimento;
	}
	public void setRendimento(float rendimento) {
		Estudante.rendimento = rendimento;
	}
	
}
