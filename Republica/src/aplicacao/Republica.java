package aplicacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import cadastro.Despesa;
import cadastro.Estudante;
import exceptions.DescricaoNaoInformadaException;
import exceptions.EmailNaoInformadoException;
import exceptions.NomeNaoInformadoException;
import exceptions.NumeroInvalidoException;
import exceptions.ValorNaoInformadoException;

public class Republica {
	
	
	protected static List<Estudante> est;
	protected static List<Despesa> des;
	
	public Republica() {
		est = new LinkedList<Estudante>();
		des = new LinkedList<Despesa>();
	}
	
	public boolean cadastrarEstudante(Estudante a) throws NumberFormatException, NumeroInvalidoException, NomeNaoInformadoException, EmailNaoInformadoException {
		boolean resposta = false;
		
		if(a.getRendimentos() <= 0)
			throw new NumeroInvalidoException(a.getRendimentos());
		if(a.getNome() == "" || a.getNome().isEmpty())
			throw new NomeNaoInformadoException();
		if(a.getEmail() == "" || a.getEmail().isEmpty())
			throw new EmailNaoInformadoException();
		
		resposta = est.add(a);
		return resposta;
	}
	
	public boolean cadastrarDespesa(Despesa a) throws DescricaoNaoInformadaException, ValorNaoInformadoException{
		
		if(a.getDescricao().equals("") || a.getDescricao().isEmpty())
			throw new DescricaoNaoInformadaException();
		if(a.getValor() <= 0)
			throw new ValorNaoInformadoException();
		
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

	public boolean gravarEstudanteEmArquivo() {
		boolean resposta = false;
		
		FileWriter arquivo = null;
		
		try {
			arquivo = new FileWriter("alunos.txt");
		} catch (IOException v) {
			v.printStackTrace();
		}
		
		BufferedWriter buffer = new BufferedWriter(arquivo);
		
		Iterator<Estudante> iteradorEstudante = est.iterator();
		while(iteradorEstudante.hasNext()) {
			Estudante e = iteradorEstudante.next();
			String str = "";
			
			str += e.getNome() + ";";
			str += e.getEmail() + ";";
			str += e.getRendimentos() + ";";
			
			try {
				buffer.write(str);
				buffer.newLine();
			} catch (IOException v) {
				v.printStackTrace();
			}
		}
		
		try {
			buffer.close();
			resposta = true;
		} catch (IOException v) {
			v.printStackTrace();
		}
		
		return resposta;
	}

	public boolean lerEstudantesDeArquivo() {
		FileReader arquivo = null;
		BufferedReader buffer;
		boolean resposta; 
		
		try {
			arquivo = new FileReader("alunos.txt");
		} catch (FileNotFoundException v) {
			v.printStackTrace();
		}
		buffer = new BufferedReader(arquivo);
		
		
		String line = "";
		try {
			line = buffer.readLine();
		} catch (IOException v) {
			v.printStackTrace();
		}
		
		
		do {
			String[] campos = line.split(";");
			
			float rendimento = Float.parseFloat(campos[2]);
			
			Estudante estudante = null;
			estudante = new Estudante(campos[0], campos[1], rendimento);

			
			if (est == null) 
				est = new LinkedList<Estudante>();
			
			resposta = est.add(estudante);
			
			try {
				line = buffer.readLine();
			} catch (IOException v) {
				v.printStackTrace();
			}
			
		} while (line != null);
		
		return resposta;
	}

	public void listarEstudantes() {

		Iterator<Estudante> iteradorEstudante = est.iterator();
		String e = "";
		while(iteradorEstudante.hasNext()) {
			e += iteradorEstudante.next().toString();
			e += "-------------------------\n";
		}
		if(e == "")
			JOptionPane.showMessageDialog(null, "Sem alunos cadastrados");
		else
			JOptionPane.showMessageDialog(null, e);
		
	}

	public void listarDespesas() {
		Iterator<Despesa> iteradorDespesa = des.iterator();
		String d = "";
		while(iteradorDespesa.hasNext()) {
			d += iteradorDespesa.next().toString();
			d+= "-------------------------\n";
		}
		
		if(d == "")
			JOptionPane.showMessageDialog(null, "Sem despesas cadastradas");
		else
			JOptionPane.showMessageDialog(null, d);
	}
	
}
