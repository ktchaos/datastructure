package primeiraparte;

public class ListaEncadeada {

	private int nElementos;
	private No cabeca;
	
	public ListaEncadeada() {
		nElementos = 0;
		cabeca = null;
	}
	
	public boolean vazia() {
		if(nElementos == 0)
			return true;
		else
			return false;
	}
	
	public int tamanho() {
		return nElementos;
	}
	
	public int elemento(int pos) {
		if(vazia())
			return -1;
			
		if(pos < 1 || pos > nElementos)
			return -1;
		
		No aux = cabeca;
		for(int i = 1; i < pos; i++) {
			aux = aux.getProx();
		}
		
		return aux.getConteudo();
	}
	
	public int posicao(int dado) {
		if(vazia()) 
			return -1;
		
		No aux = cabeca;
		int i = 1;
		
		while(aux != null) {
			if(aux.getConteudo() == dado) {
				return i;
			}
			aux = aux.getProx();
			i++;
		}
		return -1;
	}
	
	public boolean insereInicio(int conteudo) {
		No elemento = new No();
		
		elemento.setConteudo(conteudo);
		elemento.setProx(cabeca);
		cabeca = elemento;
		nElementos++;
		
		return true;
	}
	
	public boolean insereMeio(int pos, int conteudo) {
		if(pos > nElementos) {
			return false;
		}
		if(pos == 1) {
			insereInicio(conteudo);
			return true;
		}
		
		No aux = cabeca;
		No elemento = new No();
		elemento.setConteudo(conteudo);
		
		int cont = 1;
		while(cont < pos-1 && aux != null) {
			aux = aux.getProx();
			cont++;
		}
		
		if(aux == null) {
			return false;
		}
		
		elemento.setProx(aux.getProx());
		aux.setProx(elemento);
		nElementos++;
		
		return true;
	}
	
	public boolean insereFim(int conteudo) {
		No elemento = new No();
		elemento.setConteudo(conteudo);

		No aux = cabeca;		
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		elemento.setProx(null);
		aux.setProx(elemento);
		nElementos++;
		
		return true;
	}
	
	public boolean insere(int pos, int conteudo) {
		if(vazia() && pos != 1) {
			return false;
		}
		
		if(pos == 1) {
			insereInicio(conteudo);
		}
		else if(pos == nElementos+1) {
			return insereFim(conteudo);
		}
		else {
			return insereMeio(pos, conteudo);
		}
		
		return true;
	}
	
	public int removeInicio() {
		No aux = cabeca;
		int dado = cabeca.getConteudo();
		cabeca = aux.getProx();
		
		aux = null;
		nElementos--;
		return dado;
	}
	
	public int removeMeio(int pos) {
		No atual = null;
		No antecessor = null;
		
		int dado;
		int cont = 1;
		
		atual = cabeca;
		while((cont < pos) && atual != null) {
			antecessor = atual;
			atual = atual.getProx();
			cont++;
		}
		
		if(atual == null) {
			return 0;
		}
		
		dado = atual.getConteudo();
		antecessor.setProx(atual.getProx());
		nElementos--;
		
		return dado;
	}
	
	public int removeFinal() {
		No aux = cabeca;
		
		while(aux != null) {
			aux = aux.getProx();
		}
		int dado = aux.getConteudo();
		aux = null;
		nElementos--;
		return dado;
	}
	
	public int remove(int pos) {
		if(vazia()) {
			return -1;
		}
		
		if(pos == 1) {
			return removeInicio();
		}
		else {
			return removeMeio(pos);
		}
	}
}