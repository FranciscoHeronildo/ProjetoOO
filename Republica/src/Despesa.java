import java.util.LinkedList;
import java.util.List;

public class Despesa {
	String descricao;
	float valor;
	Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public Despesa(String descricao, Categoria categoria, float valor) {
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	List<Categoria> cat;
	
	public Despesa() {
		cat = new LinkedList<Categoria>();
	}
	
	public boolean cadastrarCategoria(Categoria c) {
		boolean resposta = cat.add(c);
		return resposta;
	}

	public float getValor() {
		return valor;
	}
}
