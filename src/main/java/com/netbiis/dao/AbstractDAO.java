package com.netbiis.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class AbstractDAO<Entidade> {
	
	private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    private Class<Entidade> type;
    private String table;
   
    public AbstractDAO() {
        this.emf = Persistence.createEntityManagerFactory("JPA");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();        
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public EntityTransaction getTx() {
        return tx;
    }

    public void setType(Class<Entidade> type) {
        this.type = type;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Entidade> getAll() {
        TypedQuery<Entidade> query = em.createQuery("from "+this.table, this.type);
        return query.getResultList();
    }

    public Entidade getById(Integer id) {
        return em.find(this.type, id);
    }
    
    public void delete(Entidade ent) {
    	tx.begin();
    	em.remove(em.contains(ent) ? ent : em.merge(ent));				
		tx.commit();
	}

	public void update(Entidade ent) {
		
		tx.begin();
		
		em.merge(ent);	
		
		tx.commit();
	}
	
	public void create(Entidade ent) {
		
		tx.begin();
		
		em.persist(ent);
		
		tx.commit();
	}
	
	
}
