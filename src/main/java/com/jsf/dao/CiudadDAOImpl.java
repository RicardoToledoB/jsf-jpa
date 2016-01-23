package com.jsf.dao;

import com.jsf.model.Ciudad;
import com.jsf.model.Rol;
import com.jsf.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
public class CiudadDAOImpl implements CiudadDAO,Serializable{
EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    @Transactional 
    public void save(Ciudad c) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.persist(c);
         tx.commit();
         em.close();
         
    }
    public List<Ciudad> list() {
        EntityManager em = emf.createEntityManager();
        String sql="select c from Ciudad c";
        Query query=em.createQuery(sql);
        List<Ciudad> ciudad=query.getResultList();
        em.close();
        return ciudad;
    }

    
    public Ciudad search(Ciudad c) {
        EntityManager em = emf.createEntityManager();
        String sql="select c from Ciudad c WHERE c.id =" + c.getId();
        Query query=em.createQuery(sql);
        Ciudad ciudad=(Ciudad) query.getSingleResult();
        em.close();
        return ciudad;
    }

    @Transactional
    public void delete(Ciudad c) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         System.out.println("ID"+c.getId());
         tx.begin();
         Ciudad ciudad =em.find(Ciudad.class, c.getId()); 
         em.remove(ciudad);
         tx.commit();
         em.close();
    }

    @Transactional
    public void edit(Ciudad c) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.merge(c);
         tx.commit();
         em.close();
    }
    
}
