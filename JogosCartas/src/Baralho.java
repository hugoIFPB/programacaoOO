import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Baralho {

	private Stack<Carta> cartas;

	public Baralho() {
		cartas = new Stack<Carta>();
		Naipe[] naipes = Naipe.values();
		Cor[] cores = Cor.values();
		Valor[] valores = Valor.values();
		for (Valor valor : valores) {
			for (Cor cor : cores) {
				for (Naipe naipe : naipes) {
					Carta carta = new Carta(naipe, valor, cor);
					cartas.add(carta);
				}
			}
		}
		embaralhar();
	}

	public void setCartas(Stack<Carta> cartas) {
		this.cartas = cartas;
	}

	public Stack<Carta> getCartas() {
		return cartas;
	}

	public Carta pop() throws Exception {
		try {
			Carta carta = cartas.pop();
			return carta;
		}catch(EmptyStackException e) {
			throw new Exception("Não tem mais cartas");
		}
	}

	public boolean isEmpty() {
		return cartas.isEmpty();
	}

	public void addCartas(Stack<Carta> descarte) {
		cartas.addAll(descarte);

	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}
	
	public static void main(String[] args) {
		Baralho b = new Baralho();
		while(true) {
			try {
				System.out.println(b.pop());
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("xau");
	}
	
	

}
