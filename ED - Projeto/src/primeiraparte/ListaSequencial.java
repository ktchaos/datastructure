package primeiraparte;

public class ListaSequencial {

	private int dados[];
	private int tamMaximo;
	private int tamAtual;
	
	public ListaSequencial() {
		tamMaximo = 10;
		tamAtual = 0;
		dados = new int[tamMaximo];	
	}
	
	public boolean vazia() {
		if(tamAtual == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean cheia() {
		if(tamAtual == tamMaximo) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getTamanhoAtual() {
		return tamAtual;
	}
	
	public int getElemento(int pos) {
		if(pos > tamMaximo || pos < 1) {
			return -1;
		}
		else {
			return dados[pos-1];
		}	
	}
	
	public int getPosicao(int dado) {
		for(int i = 0; i < tamAtual; i++) {
			if(dados[i] == dado) {
				return i+1;
			}
		}
		return -1;
	}
	
	public boolean inserir(int pos, int dado) {
		if(cheia() || pos > (tamAtual+1) || pos < 1) {
			return false;
		}
		else {
			for(int i = tamAtual; i >= pos; i--) {
				dados[i] = dados[i-1];
			}
			
			dados[pos-1] = dado;
			tamAtual++;
			return true;
		}
	}
	
	public int remove(int pos) {
		int dado;
		
		if(pos > tamAtual || pos < 1) {
			return -1;
		}
		else {
			dado = dados[pos-1];
			
			for(int i = (pos-1); i < tamAtual-1; i++) {
				dados[i] = dados[i+1];
			}
			tamAtual--;
			return dado;
		}	
	}
}