import javax.swing.JOptionPane;

public class Principal {
	static Republica rep = new Republica();
	public static void main(String[] args) {
		
		String[] menu = {
				"-- Selecione uma opcao --",
				"Cadastrar Estudante",
				"Pesquisar Estudante",
				"Deletar Estudante",
				"Cadastrar Despesas",
				"Pesquisar Despesas",
				"Deletar Despesas",
				"Calcular Despesas",
				"Sair"};
		String opcaoPadrao = menu[0];
		Object opcaoSelecionada = null;
		
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(
					null,
					"Selecione",
					"Republica",
					JOptionPane.QUESTION_MESSAGE,
					null,
					menu,
					opcaoPadrao);
			
			switch((String) opcaoSelecionada) {
			case "Cadastrar Estudante":
				cadastrarEstudante();
				break;
			case "Pesquisar Estudante":
				pesquisarEstudante();
				break;
			case "Deletar Estudante":
				deletarEstudante();
				break;
			case "Cadastrar Despesas":
				cadastrarDespesa();
				break;
			case "Calcular Despesas":
				calcularDespesas();
				break;
			case "Pesquisar Despesas":
				pesquisarDespesas();
				break;
			case "Deletar Despesas":
				deletarDespesas();
				break;
				
			case "Sair":
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma opcao valida");
				break;
			}
			

		}while(!((String)opcaoSelecionada).equals((String)"Sair"));
		
	}

	private static void deletarDespesas() {
		Despesa d = pesquisarDespesas();
		if(d == null)
			return;
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar a despesa?",
				"Deletar",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		if(escolha == JOptionPane.YES_OPTION) {
			boolean deletado = rep.deletarDespesa(d);
			if(deletado)
				JOptionPane.showMessageDialog(null, "Despesa deletada!");
			else
				JOptionPane.showMessageDialog(null, "Despesa nao deletado!");
		}
		
	}

	private static Despesa pesquisarDespesas() {
		String pesquisa = JOptionPane.showInputDialog("Digite a descricao da despesa");
		Despesa d = rep.pesquisarDespesa(pesquisa);
		if(d == null) {
			JOptionPane.showMessageDialog(null, "Despesa nao encontrada!");
		}else {
			JOptionPane.showMessageDialog(null, "Despesa encontrada");
			String aux;
			if(d.getCategoria().getSubCategoria() != null)
				aux = "SubCategoria = " + d.getCategoria().getSubCategoria().getDescricao() + "\n";
			else
				aux = "";
			JOptionPane.showMessageDialog(null, 
					"Nome: " + d.getDescricao() + "\n" + 
					"Categoria: " + d.getCategoria().getDescricao() + "\n" + aux +
					"Valor: " + d.getValor());
		}
		return d;
		
	}

	private static void deletarEstudante() {
		Estudante e = pesquisarEstudante();
		if(e == null)
			return;
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar o estudante?",
				"Deletar",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		if(escolha == JOptionPane.YES_OPTION) {
			boolean deletado = rep.deletarEstudante(e);
			if(deletado)
				JOptionPane.showMessageDialog(null, "Estudante deletado");
			else
				JOptionPane.showMessageDialog(null, "Estudante nao deletado!");
		}
		
	}

	private static Estudante pesquisarEstudante() {
		String pesquisa = JOptionPane.showInputDialog("Digite o nome a ser pesquisado");
		Estudante e = rep.pesquisarEstudante(pesquisa);
		if(e == null) {
			JOptionPane.showMessageDialog(null, "Estudante nao encontrado!");
		}else {
			JOptionPane.showMessageDialog(null, "Estudante encontrado");
			JOptionPane.showMessageDialog(null, 
					"Nome: " + e.getNome() + "\n" + 
					"Email: " + e.getEmail() + "\n" +
					"Rendimentos: " + e.getRendimentos());
		}
		return e;
	}

	private static void calcularDespesas() {
		String[] menuDespesa = {
				"-- Selecione uma opcao --",
				"Regra Igualitaria",
				"Regra Proporcional",
				"Voltar"};
		String opcaoPadraoDespesa = menuDespesa[0];
		Object opcaoSelecionadaDespesa = null;
		
		do {
			opcaoSelecionadaDespesa = JOptionPane.showInputDialog(
					null,
					"Selecione a regra de calculo",
					"Republica",
					JOptionPane.QUESTION_MESSAGE,
					null,
					menuDespesa,
					opcaoPadraoDespesa);
			
			switch((String) opcaoSelecionadaDespesa) {
			case "Regra Igualitaria":
				calcularRegraIgualitaria();
				break;
			case "Regra Proporcional":
				calcularRegraProporcional();
				break;
			case "Voltar":
				break;
				
			case "Sair":
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma opcao válida");
				break;
			}
			

		}while(!((String)opcaoSelecionadaDespesa).equals((String)"Voltar"));
		
	}

	private static void calcularRegraProporcional() {
		RegraProporcional.calcularRegraProporcional();
		JOptionPane.showMessageDialog(null, RegraProporcional.message);
	}

	private static void calcularRegraIgualitaria() {
		float regraIgualitaria = RegraIgualitaria.calcularRegraIgualitaria();
		JOptionPane.showMessageDialog(null, "Despesas mensais para cada estudante morador R$ " + regraIgualitaria);
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

		String descricao = JOptionPane.showInputDialog("Categoria");
		
		SubCategoria subCategoria = cadastrarSubCategoria();
		
		categoria = new Categoria(descricao, subCategoria);

		return categoria;
	}

	private static SubCategoria cadastrarSubCategoria() {
		SubCategoria subCategoria = null;
		String descricao;
		
		if(JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma subcategoria?") == JOptionPane.YES_OPTION) {
			descricao = JOptionPane.showInputDialog("Subcategoria");
			subCategoria = new SubCategoria(descricao);
		}
		return subCategoria;
	}
	
	
	
	
	
}
