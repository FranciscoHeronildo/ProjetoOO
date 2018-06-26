import java.util.Iterator;

public class RegraIgualitaria extends Republica{
	static float totalDespesas;
	static int quantidadeDeEstudantes;
	static float mediaRegraIgualitaria;
	
	public static float calcularRegraIgualitaria() {
		Iterator<Despesa> iteradorDespesas = des.iterator();
		Iterator<Estudante> iteradorEstudantes = est.iterator();
		
		quantidadeDeEstudantes = 0;
		
		while(iteradorDespesas.hasNext()) {
			totalDespesas += iteradorDespesas.next().getValor();
		}
		
		while(iteradorEstudantes.hasNext()) {
			iteradorEstudantes.next();
			quantidadeDeEstudantes++;
		}
		
		mediaRegraIgualitaria = totalDespesas / (float) quantidadeDeEstudantes;
		return mediaRegraIgualitaria;
	}
}
