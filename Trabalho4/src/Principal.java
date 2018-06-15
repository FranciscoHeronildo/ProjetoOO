
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		// Menu de opções
		Object[] opcoesPossiveis = {
				"--- Selecione uma opção ---",
				"Cadastrar Estudante",
				"Visualizar Estudantes",
				"Sair"};
		
		Object opcaoDefault = opcoesPossiveis[0];
		Object opcaoSelecionada = null;
		
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(
					null, 
					"Selecione uma das opcoes a seguir:", 
					"Republica OO", 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opcoesPossiveis, 
					opcaoDefault);
			
			switch((String) opcaoSelecionada) {
			case "Cadastrar Estudante":
				cadastrarEstudantes();
			case "Visualizar Estudantes":
				visualizarEstudantes();
			}
		}while(!((String) opcaoSelecionada).equals((String) opcoesPossiveis[6]));

	}

	private static void cadastrarEstudantes() {
		//Republica.cadastrarEstudantes();
		int novoEstudante;
		do {
			Republica.cadastrarEstudantes();
			novoEstudante = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar um novo Estudante?");
		}while(novoEstudante == JOptionPane.YES_OPTION);
	}
	
	private static void visualizarEstudantes() {
		Republica.visualizarEstudantes();
		
	}

}
