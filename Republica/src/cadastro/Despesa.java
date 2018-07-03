package cadastro;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class Despesa {
	String descricao;
	float valor;
	Categoria categoria;
	DecimalFormat df = new DecimalFormat(",##0.##");

	
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
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean cadastrarCategoria(Categoria c) {
		boolean resposta = cat.add(c);
		return resposta;
	}

	public float getValor() {
		return valor;
	}
	
	public String toString() {
		String resposta = "";
		resposta += "Descri��o: " + getDescricao() +'\n';
		resposta += "Valor: R$" + df.format(getValor()) +'\n';
		resposta += "Categoria: " + categoria.getDescricao() +'\n';
		if(categoria.getSubCategoria() == null)
			return resposta;
		else
			resposta += "SubCategoria: " + categoria.getSubCategoria().getDescricao() + '\n';
		
		return resposta;
	}
}
