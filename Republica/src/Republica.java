import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Republica {
	
	
	static List<Estudante> est;
	static List<Despesa> des;
	
	public Republica() {
		est = new LinkedList<Estudante>();
		des = new LinkedList<Despesa>();
	}
	
	public boolean cadastrarEstudante(Estudante a) {
		boolean resposta = est.add(a);
		return resposta;
	}
	
	public boolean cadastrarDespesa(Despesa a) {
		boolean resposta = des.add(a);
		return resposta;
	}
	
	public Estudante pesquisarEstudante(String nome) {
		Estudante resposta = null;
		
		Iterator<Estudante> iteradorEstudante = est.iterator();
		
		while(iteradorEstudante.hasNext()) {
			Estudante e = iteradorEstudante.next();
			if(e.getNome().equalsIgnoreCase(nome))
				resposta = e;
		}
		
		return resposta;
	}
	
	public boolean deletarEstudante(Estudante e) {
		boolean resposta = false;
		if(est.contains(e))
			resposta = est.remove(e);
		return resposta;
	}

	public Despesa pesquisarDespesa(String pesquisa) {
		Despesa resposta = null;
		
		Iterator<Despesa> iteradorDespesa = des.iterator();
		
		while(iteradorDespesa.hasNext()) {
			Despesa d = iteradorDespesa.next();
			if(d.getDescricao().equalsIgnoreCase(pesquisa))
				resposta = d;
		}
		
		return resposta;
	}

	public boolean deletarDespesa(Despesa d) {
		boolean resposta = false;
		if(des.contains(d))
			resposta = des.remove(d);
		return resposta;
	}
	
}
