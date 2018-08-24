package pub;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cliente {

	private int fone;
	private String nome;
	protected Map<Integer, Cliente> map = new HashMap<>();
	
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
	

	// METODO INSERIR CLIENTE
		public void inserir(int fone, String nome) {
			Cliente newCliente = new Cliente();
			newCliente.setFone(fone);
			newCliente.setNome(nome);
			map.put(fone, newCliente);
		}

	// METODO SORTEAR CLIENTE
		public void sortear() {
			if (map.isEmpty()) {
				System.out.println("A lista está vazia!");
			} else {
				Object[] randomKey = map.keySet().toArray();
				Object key = randomKey[new Random().nextInt(randomKey.length)];
				System.out.println("O cliente sorteado foi: " + key + " - " + map.get(key).getNome());
				map.remove(key);
			}

		}

	// METODO REMOVER CLIENTE
		public void remover(int fone) {

			if (map.containsKey(fone)) {
				map.remove(fone);
			} else {
				System.out.println("Este cliente não está na lista!");
			}

		}

	// METODO LISTAR CLIENTES
		public void listarClientes() {
			if (map.isEmpty()) {
				System.out.println("A lista está vazia!");
			} else {
				for (Map.Entry<Integer, Cliente> entry : map.entrySet()) {
					System.out.println(entry.getValue().getNome() + " - " + entry.getKey());
				}
				System.out.println("============================================================================");
			}
		}
}
