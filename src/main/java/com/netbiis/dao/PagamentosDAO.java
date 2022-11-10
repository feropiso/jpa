package com.netbiis.dao;

import java.util.List;

import com.netbiis.entidades.Pagamentos;

public class PagamentosDAO extends AbstractDAO<Pagamentos> {
	
	public PagamentosDAO() {
        super();
        super.setType(Pagamentos.class);
        super.setTable("Pagamentos");
    }

    public List<Pagamentos> getAllPagamentos() {
        return super.getAll();
    }

    public Pagamentos getPagamentosById(Integer id) {
        return super.getById(id);
    }
    
    public void deletePagamentos(Pagamentos pagamentos) {
		
		super.delete(pagamentos);	
	}

	public void updatePagamentos(Pagamentos pagamentos) {
		
		super.update(pagamentos);		
	}
	
	public void createPagamentos(Pagamentos pagamentos) {
		
		super.create(pagamentos);		
	}
		

}
