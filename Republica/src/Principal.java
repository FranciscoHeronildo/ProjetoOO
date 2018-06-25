import javax.swing.JOptionPane;

public class Principal {
	static Republica rep = new Republica();
	public static void main(String[] args) {
		
		String[] menu = {
				"-- Selecione uma opcao --",
				"Cadastrar Estudante",
				"Cadastrar Despesas",
				"Sair"};
		String opcaoPadrao = menu[0];
		Object opcaoSelecionada = null;
		
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(
					null,
					"Selecione",
					"teste",
					JOptionPane.QUESTION_MESSAGE,
					null,
					menu,
					opcaoPadrao);
			
			switch((String) opcaoSelecionada) {
			case "Cadastrar Estudante":
				cadastrarEstudante();
				break;
			case "Cadastrar Despesas":
				cadastrarDespesa();
				break;
			case "Sair":
				break;
				
			default:
				break;
			}
			
			
			
			
		}while(!((String)opcaoSelecionada).equals((String)menu[3]));
		
	}

	private static void cadastrarEstudante() {
		do {
			String nome = JOptionPane.showInputDialog("Nome do estudante:");
			String email = JOptionPane.showInputDialog("Email:");
			float rendimentos = Float.parseFloat(JOptionPane.showInputDialog("Rendimentos:"));
			
			Estudante est = new Estudante(nome, email, rendimentos);
			
			rep.cadastrarEstudante(est);
		} while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo estudante?") == JOptionPane.YES_OPTION);
		
	}
	
	private static void cadastrarDespesa() {
		do {
			String descricao = JOptionPane.showInputDialog("Despesa");
			Float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
			Categoria categoria = cadastrarCategoria();
			
			
			Despesa des = new Despesa(descricao, categoria, valor);
			
			rep.cadastrarDespesa(des);
			
		} while(JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma nova despesa?") == JOptionPane.YES_OPTION);
		
	}

	private static Categoria cadastrarCategoria() {
		Categoria categoria;
		//do {
		String descricao = JOptionPane.showInputDialog("Categoria");
		categoria = new Categoria(descricao);
		//}while(JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma nova categoria?") == JOptionPane.YES_OPTION);
		return categoria;
	}
	
	
	
	
}
