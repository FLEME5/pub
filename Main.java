package pub;

import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Main principal = new Main();
		Cliente cliente = new Cliente();
		principal.menu(cliente);
	}

	// MENU
	public void menu(Cliente cliente) {
		int option = 0;
		while (true) {
			option = Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação desejada:"
					+ "\n\nOpção 1: Inserir novo cliente." + "\nOpção 2: Sortear cliente."
					+ "\nOpção 3: Remover cliente." + "\nOpção 4: Listar clientes." + "\nOpção 5: Sair."));

			if (option == 1) {
				String nome = JOptionPane.showInputDialog("Digite o nome do novo cliente.");
				int fone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do novo cliente."));
				inserir(fone, nome, cliente);
			} else if (option == 2) {
				sortear(cliente);
			} else if (option == 3) {
				if (cliente.map.isEmpty()) {
					System.out.println("A lista está vazia!");
				} else {
					int fone = Integer.parseInt(
							JOptionPane.showInputDialog("Digite o telefone do cliente que deseja remover da lista."));
					remover(fone, cliente);
				}
			} else if (option == 4) {
				listarClientes(cliente);
			} else if (option == 5) {
				break;
			} else {
				System.out.println("Opcao invalida!");
			}
		}
	}

// METODO INSERIR CLIENTE
	public void inserir(int fone, String nome, Cliente cliente) {
		Cliente newCliente = new Cliente();
		newCliente.setFone(fone);
		newCliente.setNome(nome);
		cliente.map.put(fone, newCliente);
	}

// METODO SORTEAR CLIENTE
	public void sortear(Cliente cliente) {
		if (cliente.map.isEmpty()) {
			System.out.println("A lista está vazia!");
		} else {
			Object[] randomKey = cliente.map.keySet().toArray();
			Object key = randomKey[new Random().nextInt(randomKey.length)];
			System.out.println("O cliente sorteado foi: " + key + " - " + cliente.map.get(key).getNome());
			cliente.map.remove(key);
		}

	}

// METODO REMOVER CLIENTE
	public void remover(int fone, Cliente cliente) {

		if (cliente.map.containsKey(fone)) {
			cliente.map.remove(fone);
		} else {
			System.out.println("Este cliente não está na lista!");
		}

	}

// METODO LISTAR CLIENTES
	public void listarClientes(Cliente cliente) {
		if (cliente.map.isEmpty()) {
			System.out.println("A lista está vazia!");
		} else {
			for (Map.Entry<Integer, Cliente> entry : cliente.map.entrySet()) {
				System.out.println(entry.getValue().getNome() + " - " + entry.getKey());
			}
			System.out.println("============================================================================");
		}
	}
}
