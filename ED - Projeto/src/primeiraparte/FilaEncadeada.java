package primeiraparte;

public class FilaEncadeada {
	
	private No inicio;
	private No fim;
	private int nElementos;
	
	public FilaEncadeada() {
		inicio = null;
		fim = null;
		nElementos = 0;
	}
	
	public boolean vazia() {
		if(nElementos == 0) {
			return true;
		}
		return false;
	}
	
	public int tamanho() {
		return nElementos;
	}
	
	public int primeiro() {
		if(vazia()) {
			return -1;
		}
		
		return inicio.getConteudo();
	}

	public boolean insere(int valor) {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(null);
		
		if(vazia()) {
			inicio = novoNo;
			fim = novoNo;
		}
		else {
			fim.setProx(novoNo);
			fim = novoNo;
		}
		
		nElementos++;
		return true;
	}
	
	public int remove() {
		if(vazia()) {
			return -1;
		}
		
		int valor = primeiro();
		if(inicio == fim) {
			fim = null;
		}
		
		No p = inicio;
		inicio = p.getProx();
		nElementos--;
		p = null;
		
		return valor;
	}
	
	public int getInicio() {
		return inicio.getConteudo();
	}
	
	public int getFim() {
		return fim.getConteudo();
	}
}