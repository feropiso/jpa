package com.netbiis.controlador;

import java.util.List;
import com.netbiis.dao.PagamentosDAO;
import com.netbiis.entidades.Pagamentos;

public class ControladorPagamentos {
		
	private PagamentosDAO pagamentodao;
	
	public ControladorPagamentos() {
		this.pagamentodao = new PagamentosDAO();
	}
	
	public void alterar(Pagamentos pagamento) {
		 
		pagamentodao.updatePagamentos(pagamento);	
	}

	public void deletar(Pagamentos pagamento) {
		
		pagamentodao.deletePagamentos(pagamento);		
	}

	public List<Pagamentos> listar() {
		
		return pagamentodao.getAllPagamentos();
	}

	public void salvar(Pagamentos pagamento) {
		
		pagamentodao.createPagamentos(pagamento);
	}


}
