
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import Aplicação.Republica;
import Cadastro.Categoria;
import Cadastro.Despesa;
import Cadastro.Estudante;
import Cadastro.SubCategoria;
import Calculo.RegraIgualitaria;
import Calculo.RegraProporcional;
import Exceptions.CategoriaNaoInformadaException;
import Exceptions.DescricaoNaoInformadaException;
import Exceptions.EmailNaoInformadoException;
import Exceptions.NomeNaoInformadoException;
import Exceptions.NumeroInvalidoException;
import Exceptions.ValorNaoInformadoException;

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
				"Gravar Estudantes em Arquivo",
				"Ler Estudantes de Arquivo",
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
			case "Gravar Estudantes em Arquivo":
				gravarEstudanteEmArquivo();
				break;
			case "Ler Estudantes de Arquivo":
				LerEstudantesDeArquivo();
				break;
			case "Sair":
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma opcao valida");
				break;
			}
			

		}while(!((String)opcaoSelecionada).equals((String)"Sair"));
		
	}


	private static void LerEstudantesDeArquivo() {
		boolean resposta;
		resposta = rep.lerEstudantesDeArquivo();
		if(resposta)
			JOptionPane.showMessageDialog(null, "Estudantes carregados com sucesso");
		
	}

	private static void gravarEstudanteEmArquivo() {
		boolean resposta = rep.gravarEstudanteEmArquivo();
		if(resposta)
			JOptionPane.showMessageDialog(null, "Estudantes gravados com sucesso");
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
				aux = "SubCategoria: " + d.getCategoria().getSubCategoria().getDescricao() + "\n";
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

		JOptionPane.showMessageDialog(null, RegraProporcional.getMessage());
	}

	private static void calcularRegraIgualitaria() {
		float regraIgualitaria = RegraIgualitaria.calcularRegraIgualitaria();
		DecimalFormat df = new DecimalFormat(",##0.##");
		JOptionPane.showMessageDialog(null, "Despesas mensais para cada estudante morador R$ " + df.format(regraIgualitaria));
	}

	private static void cadastrarEstudante() {
		do {
			String nome = JOptionPane.showInputDialog("Nome do estudante:");
			String email = JOptionPane.showInputDialog("Email:");
			
			float rendimentos = 0;
			boolean resposta = true;
			do {
				try {
					rendimentos = Float.parseFloat(JOptionPane.showInputDialog("Rendimentos:"));
					resposta = false;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
					resposta = true;
				}
			} while(resposta);
			
			Estudante est = null;
			est = new Estudante(nome, email, rendimentos);

			
			resposta = true;
			do {
				try {
					rep.cadastrarEstudante(est);
					resposta = false;
				} catch (NumeroInvalidoException | NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					try {
						rendimentos = Float.parseFloat(JOptionPane.showInputDialog("Rendimentos:"));
						resposta = false;
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
						resposta = true;
					}
					est.setRendimentos(rendimentos);
					resposta = true;
				} catch (NomeNaoInformadoException e2) {
					JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
					nome = JOptionPane.showInputDialog("Nome do estudante:");
					resposta = true;
					est.setNome(nome);
				} catch (EmailNaoInformadoException e3) {
					JOptionPane.showMessageDialog(null, "Erro: " + e3.getMessage());
					email = JOptionPane.showInputDialog("Email:");
					resposta = true;
					est.setEmail(email);
				}
			} while(resposta);

		} while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo estudante?") == JOptionPane.YES_OPTION);
		
	}
	
	
	
	private static void cadastrarDespesa() {
		do {
			String descricao = "";
			descricao = JOptionPane.showInputDialog("Despesa");
			Float valor = 0f;
			
			boolean resposta = true;
			
			do {
				try {
					valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
					resposta = false;
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					resposta = true;
				}
			}while(resposta);
			
			Categoria categoria = null;
			
			
			do {
				try {
					categoria = cadastrarCategoria();
					resposta = false;
				} catch (CategoriaNaoInformadaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					resposta = true;
				}
			} while(resposta);
			Despesa des = new Despesa(descricao, categoria, valor);
			
			
			do {
				try {
					rep.cadastrarDespesa(des);
					resposta = false;
				} catch (DescricaoNaoInformadaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					descricao = JOptionPane.showInputDialog("Despesa");
					resposta = true;
					des.setDescricao(descricao);
				} catch (ValorNaoInformadoException | NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					resposta = true;
					try{
						valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
					}catch(NumberFormatException e3) {
						JOptionPane.showMessageDialog(null, "Erro: " + e3.getMessage());
						resposta = true;
					}
					des.setValor(valor);
					resposta = true;
				}
			} while(resposta);
			
		} while(JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma nova despesa?") == JOptionPane.YES_OPTION);
		
	}

	private static Categoria cadastrarCategoria() throws CategoriaNaoInformadaException{
		Categoria categoria;

		String descricao = JOptionPane.showInputDialog("Categoria");
		if(descricao.equals("") || descricao.isEmpty())
			throw new CategoriaNaoInformadaException();
		
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
