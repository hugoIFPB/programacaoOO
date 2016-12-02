import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Jogador {

	private List<Carta> mao;
	
	public Jogador() {
		mao = new ArrayList<Carta>();
	}
	
	public void addCarta(Carta novaCarta) {
		mao.add(novaCarta);
	}

	public void jogar(Baralho baralho, Stack<Carta> descarte) {
		String op = JOptionPane.showInputDialog("Baralho (B) ou Descarte (D)");
		Carta c;
		if(op.equals("B")) {
			c = baralho.pop();
		} else {
			c = descarte.pop();
		}
		mao.add(c);
		c = descartar();
		descarte.push(c);
	}

	private Carta descartar() {
		ListIterator<Carta> iterator = mao.listIterator();
		while(iterator.hasNext()) {
			Carta next = iterator.next();
			int op = JOptionPane.showConfirmDialog(null, "Esta carta: "+next);
			if(op == JOptionPane.YES_OPTION) {
				iterator.remove();
				return next;
			}
		}
		return descartar();
	}

	public boolean venceu() {
		int op = JOptionPane.showConfirmDialog(null, "Venceu?");
		if(op == JOptionPane.YES_OPTION) {
			for(int i=0; i <3; i++) {
				Carta[] jogo = lerJogo();
				if(!jogoValido(jogo)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		
	}

	private boolean jogoValido(Carta[] jogo) {
		if(jogoValidoMesmoNaipe(jogo) || jogoValidoNaipeDiferente(jogo) ) {
			return true;
		} 
		return false;
	}

	private boolean jogoValidoNaipeDiferente(Carta[] jogo) {
		if(jogo[0].getNaipe() != jogo[1].getNaipe() 
				&& jogo[0].getNaipe() != jogo[2].getNaipe()
				&& jogo[1].getNaipe() != jogo[2].getNaipe()) {
			if(jogo[0].getValor() == jogo[1].getValor() 
					&& jogo[0].getValor() == jogo[2].getValor()) {
				return true;
			}
			
		}
		return false;
	}

	private boolean jogoValidoMesmoNaipe(Carta[] jogo) {
		if(jogo[0].getNaipe() == jogo[1].getNaipe() 
				&& jogo[0].getNaipe() == jogo[2].getNaipe()) {
			
			int[] valores = new int[3];
			valores[0] = jogo[0].getValor().getValor();
			valores[1] = jogo[1].getValor().getValor();
			valores[2] = jogo[2].getValor().getValor();
			Arrays.sort(valores);
			if((valores[0]+1)== valores[1] && (valores[1]+1)== valores[2]) {
				return true;
			}
			
		}
		return false;
	}

	private Carta[] lerJogo() {
		return null;
	}

	
}
