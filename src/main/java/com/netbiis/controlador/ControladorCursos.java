package com.netbiis.controlador;

import java.util.List;
import com.netbiis.dao.CursosDAO;
import com.netbiis.entidades.Cursos;

public class ControladorCursos {
	
	private CursosDAO cursosdao;
	
	public ControladorCursos() {
		this.cursosdao = new CursosDAO();
	}
	
	public void alterar(Cursos curso) {
		
		cursosdao.updateCursos(curso);			
	}

	public void deletar(Cursos curso) {
		cursosdao.deleteCursos(curso);		
	}

	public List<Cursos> listar() {
		
		return cursosdao.getAllCursos();
	}

	public void salvar(Cursos curso) {
		
		cursosdao.createCursos(curso);
	}

}
