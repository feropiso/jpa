package com.netbiis.dao;

import java.util.List;
import com.netbiis.entidades.Cursos;

public class CursosDAO extends AbstractDAO<Cursos> {
	
	public CursosDAO() {
        super();
        super.setType(Cursos.class);
        super.setTable("Cursos");
    }

    public List<Cursos> getAllCursos() {
        return super.getAll();
    }

    public Cursos getCursosById(Integer id) {
        return super.getById(id);
    }
    
    public void deleteCursos(Cursos cursos) {
		
		super.delete(cursos);	
	}

	public void updateCursos(Cursos cursos) {
		
		super.update(cursos);		
	}
	
	public void createCursos(Cursos cursos) {
		
		super.create(cursos);		
	}
		
}
