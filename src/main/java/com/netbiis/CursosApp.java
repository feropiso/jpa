package com.netbiis;

import java.util.List;
import javax.swing.JOptionPane;
import com.netbiis.controlador.ControladorCursos;
import com.netbiis.entidades.Cursos;

public class CursosApp {
	
	
	public void iniciar() {
		
		ControladorCursos controle  = new ControladorCursos();
		
		Cursos curso = new Cursos();		
				
		String nome, valor, url, option = "";
		
			while (!option.equalsIgnoreCase("Sair")) {
				
				String[] opcao = { "Mostrar todos os cursos", "Cadastrar novo curso", 
						"Atualizar curso", "Deletar curso", "Sair" };
				
				Object escolha = JOptionPane.showInputDialog(null,
			             "Escolha a operação:", "Sistema de gerenciamento de cursos",
			             JOptionPane.INFORMATION_MESSAGE, null,
			             opcao, opcao[0]);
				
				option = escolha.toString();
				
				switch (option) {
				
					case "Mostrar todos os cursos":
						
						System.out.println("[1]: Todos os cursos:");
						List<Cursos> lista = controle.listar();
						
						lista.forEach(e->System.out.println(e.getNome()+" <=> "+e.getUrl()));
						
						break;
											
					case "Cadastrar novo curso":
						
						System.out.println("[3]: Novo curso...");
						
						nome = JOptionPane.showInputDialog(null, "Digite nome do curso:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						valor = JOptionPane.showInputDialog(null, "Digite valor em reais (R$):", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						url = JOptionPane.showInputDialog(null, "Digite url:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);		
						
						curso.setNome(nome);
						curso.setValor(valor);
						curso.setUrl(url);
						
						controle.salvar(curso);
						
						System.out.println("Curso cadastrado com sucesso!");
												
						break;
						
					case "Atualizar curso":
						
						System.out.println("[4]: Atualizando curso...");
						List<Cursos> lista2 = controle.listar();
						Cursos cursoatual = escolherCurso(lista2);
						
						nome = JOptionPane.showInputDialog(null, "Digite nome do curso:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
							
						valor = JOptionPane.showInputDialog(null, "Digite valor em reais (R$):", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);
						
						url = JOptionPane.showInputDialog(null, "Digite url:", "Cadastro",
					             JOptionPane.INFORMATION_MESSAGE);	
																		
						cursoatual.setNome(nome);
						cursoatual.setValor(valor);
						cursoatual.setUrl(url);
						
						controle.alterar(cursoatual);						
						
						System.out.println("Atualização de cadastro com sucesso!");
						
						break;
						
					case "Deletar curso":
						
						System.out.println("[5]: Deletando...");
						List<Cursos> lista3 = controle.listar();
						Cursos cursodelete = escolherCurso(lista3);
						
						controle.deletar(cursodelete);
						
						System.out.println("Curso deletado com sucesso!");
						break;
										
					case "Sair":
						System.out.println("Encerrando...");
						
						break;					
				}
				
			}
	}
	
	private Cursos escolherCurso(List<Cursos> lista) {
		
		String [] opcao;
				
		opcao = new String[lista.size()];
		
		for(int i = 0; i < lista.size(); i++)			
			opcao[i] = lista.get(i).getNome();
			
		Object escolha = JOptionPane.showInputDialog(null,
	             "Escolha o curso:", "Sistema de gerenciamento de cursos",
	             JOptionPane.INFORMATION_MESSAGE, null,
	             opcao, opcao[0]);
		
		Cursos cursoescolhido = new Cursos();
		
		for(Cursos curso: lista) {
			if(curso.getNome().equalsIgnoreCase(escolha.toString())) {
				cursoescolhido = curso;
				break;
			}
		}
							
		return cursoescolhido;					
	}


}
