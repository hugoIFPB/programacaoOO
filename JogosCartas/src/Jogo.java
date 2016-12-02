import java.util.Set;
import java.util.Stack;

public class Jogo {

	private Set<Jogador> jogadores;
	private Baralho baralho;
	private Stack<Carta> descarte;
	private Jogador vencedor;

	public Jogo(Set<Jogador> js) {
		this.jogadores = js;
		baralho = new Baralho();
		distribuirCartas();
	}

	private void distribuirCartas() {
		for (Jogador j : jogadores) {
			for (int i = 0; i < 9; i++) {
				j.addCarta(baralho.pop());
			}
		}
	}

	private Jogador iniciarJogo() {
		descarte.push(baralho.pop());
		while (vencedor == null) {
			vencedor = rodada();
		}
		return vencedor;
	}

	private Jogador rodada() {
		for (Jogador jogador : jogadores) {
			jogador.jogar(baralho, descarte);
			if (jogador.venceu()) {
				return jogador;
			}
			verificarBaralho();
		}
		return null;
	}

	private void verificarBaralho() {
		if(baralho.isEmpty()) {
			Carta topo = descarte.pop();
			baralho.addCartas(descarte);
			baralho.embaralhar();
			descarte = new Stack<Carta>();
			descarte.push(topo);
		}
	}

}
