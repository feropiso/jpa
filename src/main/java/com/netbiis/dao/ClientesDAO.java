package com.netbiis.dao;

import java.util.List;

import com.netbiis.entidades.Clientes;

public class ClientesDAO extends AbstractDAO<Clientes> {
	
	public ClientesDAO() {
        super();
        super.setType(Clientes.class);
        super.setTable("Clientes");
    }

    public List<Clientes> getAllClientes() {
        return super.getAll();
    }

    public Clientes getClienteById(Integer id) {
        return super.getById(id);
    }
    
    public void deleteCliente(Clientes cliente) {
		
		super.delete(cliente);	
	}

	public void updateCliente(Clientes cliente) {
		
		super.update(cliente);		
	}
	
	public void createCliente(Clientes cliente) {
		
		super.create(cliente);		
	}

}
