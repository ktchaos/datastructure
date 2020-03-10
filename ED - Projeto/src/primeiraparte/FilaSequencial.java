package primeiraparte;

public class FilaSequencial {

	private int tamanhoMax;
	private int dados[];
	private int nElementos;
	private int inicio;
	private int fim;
	
	public FilaSequencial() {
		tamanhoMax = 9;
		dados = new int[tamanhoMax];
		nElementos = 0;
		inicio = 0;
		fim = -1;
	}
	
	public boolean vazia() {
		if(nElementos == 0) {
			return true;
		}
		return false;
	}
	
	public boolean cheia() {
		if(nElementos == tamanhoMax) {
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
		return dados[inicio];
	}
	
	public boolean insere(int valor) {
		if(cheia()) {
			return false;
		}
		
		fim = (fim+1) % tamanhoMax;
		dados[fim] = valor;
		nElementos++;
		
		return true;
	}
	
	public int remove() {
		if(vazia()) {
			return -1;
		}
		
		int res = primeiro();
		inicio = (inicio+1) % tamanhoMax;
		nElementos--;
		
		return res;
	}
	
	public int getInicio() {
		return inicio;
	}
	
	public int getFim() {
		return fim;
	}
	
	public int getPrimeiro() {
		return primeiro();
	}
}