package primeiraparte;

public class No {

	private No prox;
	private int conteudo; 
	
	public No() {
		prox = null;
	}
	
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}
	
	public int getConteudo() {
		return conteudo;
	}
	
	public void setProx(No prox) {
		this.prox = prox;
	}
	
	public No getProx() {
		return prox;
	}
}
