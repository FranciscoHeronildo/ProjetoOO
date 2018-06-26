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
	
}
