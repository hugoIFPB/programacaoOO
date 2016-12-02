
public class Carta {

	private Naipe naipe;
	private Valor valor;
	private Cor cor;
	
	

	public Carta(Naipe naipe, Valor valor, Cor cor) {
		super();
		this.naipe = naipe;
		this.valor = valor;
		this.cor = cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	
	
	public Valor getValor() {
		return valor;
	}
	
	public void setValor(Valor valor) {
		this.valor = valor;
	}
	
	public Naipe getNaipe() {
		return naipe;
	}
	
	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	
	@Override
	public String toString() {
		return naipe.name() + " " + valor.name() + " "+ cor.name();
	}
}
