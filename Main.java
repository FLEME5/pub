package pub;

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
				cliente.inserir(fone, nome);
			} else if (option == 2) {
				cliente.sortear();
			} else if (option == 3) {
				if (cliente.map.isEmpty()) {
					System.out.println("A lista está vazia!");
				} else {
					int fone = Integer.parseInt(
							JOptionPane.showInputDialog("Digite o telefone do cliente que deseja remover da lista."));
					cliente.remover(fone);
				}
			} else if (option == 4) {
				cliente.listarClientes();
			} else if (option == 5) {
				break;
			} else {
				System.out.println("Opcao invalida!");
			}
		}
	}

}
