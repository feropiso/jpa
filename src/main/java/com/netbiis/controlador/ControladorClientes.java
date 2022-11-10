package com.netbiis.controlador;

import java.util.List;

import com.netbiis.dao.ClientesDAO;
import com.netbiis.entidades.Clientes;

public class ControladorClientes {
	
	private ClientesDAO clientedao;
	
	public ControladorClientes() {
		this.clientedao = new ClientesDAO();
	}
	
	public void alterar(Clientes cliente) {
		 
		clientedao.updateCliente(cliente);		
	}

	public void deletar(Clientes cliente) {
		
		clientedao.deleteCliente(cliente);		
	}

	public List<Clientes> listar() {
		
		return clientedao.getAllClientes();
	}

	public void salvar(Clientes cliente) {
		
		clientedao.createCliente(cliente);
	}

}
