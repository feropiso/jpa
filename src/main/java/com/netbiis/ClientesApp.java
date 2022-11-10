package com.netbiis;
import java.util.List;
import javax.swing.JOptionPane;
import com.netbiis.controlador.ControladorClientes;
import com.netbiis.entidades.Clientes;

public class ClientesApp {
	
	
	public void iniciar() {
		
		ControladorClientes controle = new ControladorClientes();
		Clientes cliente = new Clientes();
				
		String cpf, nome, email, option = "";
		
			while (!option.equalsIgnoreCase("Sair")) {
				
				String[] opcao = { "Mostrar todos os clientes", "Cadastrar novo cliente", 
						"Atualizar cadastro de cliente", "Deletar cliente", "Sair" };
				
				Object escolha = JOptionPane.showInputDialog(null,
			             "Escolha a operação:", "Sistema de gerenciamento de clientes",
			             JOptionPane.INFORMATION_MESSAGE, null,
			             opcao, opcao[0]);
				
				option = escolha.toString();
				
				switch (option) {
				
					case "Mostrar todos os clientes":
						
						System.out.println("[1]: Todos os clientes:");						
						List<Clientes> lista = controle.listar();
						lista.forEach(e->System.out.println(e.getCpf()+" <=> "+e.getNome()));
						
						break;
											
					case "Cadastrar novo cliente":
						
						System.out.println("[3]: Novo cliente:");
						
						cpf = JOptionPane.showInputDialog(null, "Digite cpf:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						nome = JOptionPane.showInputDialog(null, "Digite nome:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						email = JOptionPane.showInputDialog(null, "Digite email:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);	
						
						cliente.setCpf(cpf);
						cliente.setEmail(email);
						cliente.setNome(nome);
						
						controle.salvar(cliente);
						
						System.out.println("Cliente cadastrado com sucesso!");
												
						break;
						
					case "Atualizar cadastro de cliente":
						
						System.out.println("[4]: Atualizando cadastro...");
						List<Clientes> lista2 = controle.listar();
						Clientes clienteatual = escolherCliente(lista2);
						
						cpf = JOptionPane.showInputDialog(null, "Digite cpf:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
												
						nome = JOptionPane.showInputDialog(null, "Digite nome:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						email = JOptionPane.showInputDialog(null, "Digite email:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);	
						
						clienteatual.setNome(nome);
						clienteatual.setCpf(cpf);
						clienteatual.setEmail(email);
						
						controle.alterar(clienteatual);
						
						System.out.println("Atualização de cadastro com sucesso!");
						
						break;
						
					case "Deletar cliente":
						
						System.out.println("[5]: Deletando...");
						List<Clientes> lista3 = controle.listar();
						Clientes clientedelete = escolherCliente(lista3);
						
						controle.deletar(clientedelete);
						
						System.out.println("Atualização de cadastro com sucesso!");
						
						break;
										
					case "Sair":
						System.out.println("Encerrando...");						
						break;					
				}
				
			}
	}
	
	private Clientes escolherCliente(List<Clientes> lista) {
		
		String [] opcao;
				
		opcao = new String[lista.size()];
		
		for(int i = 0; i < lista.size(); i++ ) 			
			opcao[i] = lista.get(i).getNome();
		
			
		Object escolha = JOptionPane.showInputDialog(null,
	             "Escolha o clientes:", "Sistema de gerenciamento de clientes",
	             JOptionPane.INFORMATION_MESSAGE, null,
	             opcao, opcao[0]);
		
		Clientes clienteescolhido = new Clientes();
		
		for(Clientes c: lista) {
			if (c.getNome().equalsIgnoreCase(escolha.toString())) {
				clienteescolhido = c;
				break;
			}								
		}
							
		return clienteescolhido;
					
	}


}
