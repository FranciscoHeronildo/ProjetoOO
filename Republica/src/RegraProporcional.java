import java.util.Iterator;

public class RegraProporcional extends Republica{
	static String message;

	public static void calcularRegraProporcional() {
		float totalDespesas = 0;
		float mediaRegraProporcional = 0;


		Iterator<Despesa> iteradorDespesas = des.iterator();
		Iterator<Estudante> iteradorEstudantes = est.iterator();

		while(iteradorDespesas.hasNext()) {
			totalDespesas += iteradorDespesas.next().getValor();
		}
		
		while(iteradorEstudantes.hasNext()) {
			
			float rendimento =  iteradorEstudantes.next().getRendimentos();
			//String nome =  iteradorEstudantes.getNome().;
			mediaRegraProporcional = (rendimento * 100f) / totalDespesas;
			
			message += "Estudante: " + //nome + 
					" Renda: R$ " + rendimento + 
					" Total de despesas a pagar: R$ " + mediaRegraProporcional + "= " +  "\n";
		}
	}

}
