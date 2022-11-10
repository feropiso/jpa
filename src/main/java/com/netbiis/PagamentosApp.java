package com.netbiis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import com.netbiis.controlador.ControladorClientes;
import com.netbiis.controlador.ControladorCursos;
import com.netbiis.controlador.ControladorPagamentos;
import com.netbiis.entidades.Clientes;
import com.netbiis.entidades.Cursos;
import com.netbiis.entidades.Pagamentos;

public class PagamentosApp {
		
	private String cpf;
	private Cursos curso;
	private Clientes cliente;
	private Pagamentos pag;
	private List<Cursos> lista_cursos;	
	private List<Clientes> lista_de_clientes;
	private ControladorPagamentos controle;
	
	public void iniciar() {
		
		controle = new ControladorPagamentos();		
		ControladorCursos controle_cursos  = new ControladorCursos();
		ControladorClientes controle_cliente = new ControladorClientes();
				
		curso = new Cursos();	
		cliente = new Clientes();
		pag = new Pagamentos();
		
		lista_cursos = controle_cursos.listar();		
		lista_de_clientes = controle_cliente.listar();
		
		String option = "";
		cpf = "";
		
		while (!option.equalsIgnoreCase("Sair")) {
				
				String[] opcao = { "Cadastrar pagamento", "Mostrar faturamento", 
						"Mostrar pagamento por cliente", "Deletar pagamento", "Sair" };
				
				Object escolha = JOptionPane.showInputDialog(null,
			             "Escolha a operação:", "Sistema de gerenciamento de pagamentos",
			             JOptionPane.INFORMATION_MESSAGE, null,
			             opcao, opcao[0]);
				
				option = escolha.toString();
				
				switch (option) {
										
					case "Cadastrar pagamento":
						
						System.out.println("[1]: Cadastrando pagamento:");
						
						cpf = JOptionPane.showInputDialog(null, "Digite cpf:", "Cadastro de pagamento",
					             JOptionPane.INFORMATION_MESSAGE);
												
						cadastraPagamento();
						
						break;
					
					case "Mostrar pagamento por cliente":
						
						System.out.println("[2]: Pagamento por cliente:");
						
						cpf = JOptionPane.showInputDialog(null, "Digite cpf:", "Cadastro de pagamento",
					             JOptionPane.INFORMATION_MESSAGE);
												
						faturamentoPorCliente();
						
						break;
					
					case "Mostrar faturamento":
						
						System.out.println("[3]: Faturamento:");
						
						faturamento();
						
						break;
										
					case "Deletar pagamento":
						
						System.out.println("[3]: Deletar pagamento:");
						
						pag = escolherPagamento();
						
						controle.deletar(pag);
						
						System.out.println("Pagamento deletado...");
						
						break;
						
					case "Sair":
						System.out.println("Encerrando...");
						
						break;					
				}
				
			}
	}
	
	private void cadastraPagamento() {
		
		if (!verificaCliente()) {
			System.out.println("Cliente ainda não cadastrado!");
			return;
		}
						
		curso = escolherCurso();
				
		int id_cliente = cliente.getIdCliente();
		int id_curso = curso.getIdCurso();
			
		if (!verificaClienteCurso(id_cliente, id_curso)) {
			
			pag.setClientes(cliente);
			pag.setCursos(curso);			
			pag.setData(dataAtual());
			
			controle.salvar(pag);
			
			System.out.println("Pagamento cadastrado com sucesso!");
			
			return;
		}
		
		System.out.println("Cliente já possui esse curso!");
	}
	
	private boolean verificaCliente() {
		for(Clientes c: lista_de_clientes) {
			if(c.getCpf().equalsIgnoreCase(cpf)) {
				cliente = c;
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaClienteCurso(Integer id_cliente, Integer id_curso) {
		
		List<Pagamentos> lista_pagamentos = controle.listar();
		
		for(Pagamentos p: lista_pagamentos) {			
			if(p.getClientes().getIdCliente() == id_cliente && p.getCursos().getIdCurso() == id_curso)
				return true;			
		}
		return false;
	}
		
	private Cursos escolherCurso() {
		
		String [] opcao;
				
		opcao = new String[lista_cursos.size()];
		
		for(int i = 0; i < lista_cursos.size(); i++)			
			opcao[i] = lista_cursos.get(i).getNome();
			
		Object escolha = JOptionPane.showInputDialog(null,
	             "Escolha o curso:", "Sistema de gerenciamento de cursos",
	             JOptionPane.INFORMATION_MESSAGE, null,
	             opcao, opcao[0]);
		
		Cursos cursoescolhido = new Cursos();
		
		for(Cursos curso: lista_cursos) {
			if(curso.getNome().equalsIgnoreCase(escolha.toString())) {
				cursoescolhido = curso;
				break;
			}
		}
							
		return cursoescolhido;					
	}
	
	private java.sql.Date dataAtual() {
		
		return new java.sql.Date(new Date().getTime()); 
		
	}
	
	private void faturamentoPorCliente() {
		
		List<Pagamentos> lista_pagamentos = controle.listar();
		
		if (!verificaCliente()) {
			System.out.println("Cliente ainda não cadastrado!");
			return;
		}
		
		double valor_bruto = 0.0;
				
		for(Pagamentos pg: lista_pagamentos) {
			
			if (pg.getClientes().getIdCliente() == cliente.getIdCliente()) {
				
				String v = pg.getCursos().getValor().replace(",", ".");
				BigDecimal valor = converteParaBigDecimal(v);
				
				valor_bruto += valor.doubleValue();
			}
					
		}
		
		System.out.println("\nCliente: "+cliente.getNome()+""
				+ "\nPagamento no total de: R$ "+formataPreco(""+valor_bruto));
		
	}

	private void faturamento() {
		
		List<Pagamentos> lista_pagamentos = controle.listar();
		
		double valor_bruto = 0.0;
				
		for(Pagamentos pg: lista_pagamentos) {
			 
			String v = pg.getCursos().getValor().replace(",", ".");
			BigDecimal valor = converteParaBigDecimal(v);
			
			valor_bruto += valor.doubleValue();			
		}
		
		System.out.println("\nO faturamento total é: R$ "+formataPreco(""+valor_bruto));
		
	}
	
	private String formataPreco(String s) {
		
		String aux = s;
		
		if(aux.contains(".")) {				
			aux = aux.replace(".", ",");				
			if(aux.indexOf(",") == aux.length()-1)
				aux += "00";
			else if(aux.indexOf(",") == aux.length()-2)
				aux += "0";
			else if(aux.length() - aux.indexOf(",")>3)
				aux = aux.substring(0, aux.indexOf(",")+3);
		}
		else
			aux += ",00";			
		
		return aux;
	}
	
	private BigDecimal converteParaBigDecimal(String s) {
		
		return new BigDecimal(s);
	}
	
	private Pagamentos escolherPagamento() {
		
		List<Pagamentos> lista_pagamentos = controle.listar();
		
		String [] opcao;
				
		opcao = new String[lista_pagamentos.size()];
		
		for(int i = 0; i < lista_pagamentos.size(); i++)			
			opcao[i] = lista_pagamentos.get(i).getClientes().getCpf()+" <=> "+lista_pagamentos.get(i).getCursos().getNome();
			
		Object escolha = JOptionPane.showInputDialog(null,
	             "Escolha o curso:", "Sistema de gerenciamento de cursos",
	             JOptionPane.INFORMATION_MESSAGE, null,
	             opcao, opcao[0]);
		
		Pagamentos pag_escolhido = new Pagamentos();
		
		for(Pagamentos pg: lista_pagamentos) {
			
			if(pg.getClientes().getCpf().equalsIgnoreCase(escolha.toString().substring(0, 14))) {
				pag_escolhido = pg;				
				break;
			}
		}
							
		return pag_escolhido;					
	}

}
