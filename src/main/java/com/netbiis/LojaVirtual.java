package com.netbiis;

import javax.swing.JOptionPane;

public class LojaVirtual {

	public static void main(String[] args) {
		
		String option = "";
		
		while (!option.equalsIgnoreCase("Sair")) {
			
			String[] opcao = { "Clientes", "Cursos", "Informa�oes de Pagamento", "Sair" };
			
			Object escolha = JOptionPane.showInputDialog(null,
		             "Escolha a consulta:", "Cursos Netbiiss",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             opcao, opcao[0]);
			
			option = escolha.toString();
			
			switch (option) {
			
				case "Clientes":
					
					ClientesApp cliente = new ClientesApp();					
					cliente.iniciar();					
					break;
					
				case "Cursos":
					
					CursosApp curso = new CursosApp();					
					curso.iniciar();
					break;
				
				case "Informa�oes de Pagamento":
					
					PagamentosApp pag = new PagamentosApp();					
					pag.iniciar();
					break;
												
				case "Sair":
					System.out.println("Encerrando...");
					break;					
			}
			
		}


	}

}
