package primeiraparte;

public class PilhaEncadeada {
	
	private No topo;// cabeça - referência a listas
	private int nElementos;
	
	public PilhaEncadeada() {
		nElementos = 0;
		topo = null;
	}
	
	public boolean vazia() {
		return (nElementos == 0);
	}
	
	public int tamanho() {
		return nElementos;
	}
	
	public int top() {
		if(vazia()) {
			return 0;
		}
		return topo.getConteudo();
	}
	
	public boolean push(int valor) {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(topo);
		
		topo = novoNo;
		nElementos++;
		return true;
	}
	
	public int pop() {
		if(vazia()) {
			return -1;
		}
		
		No aux = topo;
		topo = aux.getProx();
		nElementos--;
		
		return aux.getConteudo();
	}
}
