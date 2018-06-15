import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Republica {
	
	static LinkedList<Estudante> listaEstudantes = new LinkedList<Estudante>();
	static Iterator<Estudante> i = listaEstudantes.iterator();
	
	public static void cadastrarEstudantes() {
		Estudante est = new Estudante();
		est.setNome(JOptionPane.showInputDialog("Digite o nome: "));
		est.setEmail(JOptionPane.showInputDialog("Digite o Email: "));
		est.setRendimento(Float.parseFloat(JOptionPane.showInputDialog("Digite o rendimento: ")));
		listaEstudantes.add(est);
	}
	
	void cadastrarDespesa(){
		
	}

	public static void visualizarEstudantes() {
		while(i.hasNext()) {
			JOptionPane.showMessageDialog(null, Estudante.getNome());
		}
	}
}
