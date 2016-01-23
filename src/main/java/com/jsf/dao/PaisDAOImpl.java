package com.jsf.dao;

import com.jsf.model.Pais;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class PaisDAOImpl implements PaisDAO, Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

    @Transactional
    public void save(Pais p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();

    }

    public List<Pais> list() {
        EntityManager em = emf.createEntityManager();
        String sql = "select p from Pais p";
        Query query = em.createQuery(sql);
        List<Pais> pais = query.getResultList();
        em.close();
        return pais;
    }

    public Pais search(Pais p) {
        EntityManager em = emf.createEntityManager();
        String sql = "select p from Pais p WHERE p.id =" + p.getId();
        Query query = em.createQuery(sql);
        Pais pais= (Pais) query.getSingleResult();
        em.close();
        return pais;
    }

    @Transactional
    public void delete(Pais p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        System.out.println("ID" + p.getId());
        tx.begin();
        Pais pais = em.find(Pais.class, p.getId());
        em.remove(pais);
        tx.commit();
        em.close();
    }

    @Transactional
    public void edit(Pais p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(p);
        tx.commit();
        em.close();
    }
}
