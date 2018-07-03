package Cadastro;
import java.util.LinkedList;
import java.util.List;

public class Categoria {
	String descricao;
	SubCategoria subCategoria;
	
	public Categoria(String descricao, SubCategoria subCategoria) {
		this.descricao = descricao;
		this.subCategoria = subCategoria;
	}
	
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	List<SubCategoria> subcat;
	
	public Categoria() {
		subcat = new LinkedList<SubCategoria>();
	}

	public boolean cadastrarSubCategoria(SubCategoria sc){
		boolean resposta = subcat.add(sc);
		return resposta;
		
	}
}
