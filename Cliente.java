package pub;

import java.util.HashMap;

public class Cliente {

	private int fone;
	private String nome;
	protected HashMap<Integer, Cliente> map = new HashMap<>();
	
	public int getFone() {
		return fone;
	}
	public void setFone(int fone) {
		this.fone = fone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
