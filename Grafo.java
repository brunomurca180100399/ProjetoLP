package TrabalhoLP;

import java.util.*;

public class Grafo {

	private Set<Cidade> cidades;
	private PriorityQueue<Cidade> queueCidade = new PriorityQueue<>();

	public Grafo() {
		cidades = new HashSet<>();
	}

	public void addCidade(Cidade n) {
		cidades.add(n);
	}
	
	public void RemoverCidade(Cidade n) {
		cidades.remove(n);
	}

	public void encontraMenorCaminho(Cidade origem){
		origem.setDistanciaMinima(0.0);
		queueCidade.add(origem);
		while (!queueCidade.isEmpty()) {
			Cidade c = queueCidade.poll();
			for (Ligacao l : c.getLigacoes()) {
				Cidade destino = l.getDestino();
				double peso = l.getHoras();
				double distanciaAtravesC = peso + c.getDistanciaMinima();
				if(distanciaAtravesC < destino.getDistanciaMinima()) {
					destino.setDistanciaMinima(distanciaAtravesC);
					destino.setCidadeAnterior(c);
					queueCidade.remove(destino);
					queueCidade.add(destino);
				}
			}
		}
	}
	
	public List<Cidade> criarCaminho(Cidade destino){
		List<Cidade> caminho = new ArrayList<Cidade>();
		for (Cidade c = destino; c!=null; c=c.getCidadeAnterior()) {
			caminho.add(c);
		}
		Collections.reverse(caminho);
		return caminho;
	}
	
}
