package com.jsf.dao;
import com.jsf.model.Rol;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
public class RolDAOImpl implements RolDAO,Serializable{
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    @Transactional 
    public void save(Rol r) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.persist(r);
         tx.commit();
         em.close();
         
    }
    public List<Rol> list() {
        EntityManager em = emf.createEntityManager();
        String sql="select r from Rol r";
        Query query=em.createQuery(sql);
        List<Rol> rol=query.getResultList();
        em.close();
        return rol;
    }

    
    public Rol search(Rol r) {
        EntityManager em = emf.createEntityManager();
        String sql="select r from Rol r WHERE r.id =" + r.getId();
        Query query=em.createQuery(sql);
        Rol rol=(Rol) query.getSingleResult();
        em.close();
        return rol;
    }

    @Transactional
    public void delete(Rol r) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         System.out.println("ID"+r.getId());
         tx.begin();
         Rol rol =em.find(Rol.class, r.getId()); 
         em.remove(rol);
         tx.commit();
         em.close();
    }

    @Transactional
    public void edit(Rol r) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.merge(r);
         tx.commit();
         em.close();
    }
}
