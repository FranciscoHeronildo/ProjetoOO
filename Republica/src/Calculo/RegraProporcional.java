package Calculo;
import java.text.DecimalFormat;
import java.util.Iterator;

import Aplicação.Republica;
import Cadastro.Despesa;
import Cadastro.Estudante;


public class RegraProporcional extends Republica{
	private static String message;
	
	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		RegraProporcional.message = message;
	}

	public static void calcularRegraProporcional() {
		float totalDespesas = 0;
		float totalRendimentos = 0;
		float mediaRegraProporcional = 0;
		Estudante e;
		String str = "";

		Iterator<Despesa> iteradorDespesas = des.iterator();
		DecimalFormat df = new DecimalFormat(",##0.##");
		
		
		while(iteradorDespesas.hasNext()) {
			totalDespesas += iteradorDespesas.next().getValor();
		}
		
		for(int i = 0; i < est.size(); i++) {
			e = est.get(i);
			totalRendimentos += e.getRendimentos();
		}
		
		for(int i = 0; i < est.size(); i++) {
			e = est.get(i);
			float rendimentoProporcional = (e.getRendimentos() * 100) / totalRendimentos;
			mediaRegraProporcional = (rendimentoProporcional * totalDespesas) / 100;
			
			str += "Estudante: " + e.getNome() + '\n';
			str += "Renda: R$ " + df.format(e.getRendimentos()) + '\n';
			str += "Total de despesas a pagar: R$ " + df.format(mediaRegraProporcional) + " (" + df.format(rendimentoProporcional) + "%)" + '\n';
			str += "-----------------------------------------\n";
		}
		setMessage(str);
	}
}
