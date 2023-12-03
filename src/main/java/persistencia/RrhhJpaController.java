/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Rrhh;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Victor
 */
public class RrhhJpaController implements Serializable {

    public RrhhJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public RrhhJpaController() {
        emf=Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rrhh rrhh) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rrhh);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rrhh rrhh) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rrhh = em.merge(rrhh);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rrhh.getId();
                if (findRrhh(id) == null) {
                    throw new NonexistentEntityException("The rrhh with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rrhh rrhh;
            try {
                rrhh = em.getReference(Rrhh.class, id);
                rrhh.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rrhh with id " + id + " no longer exists.", enfe);
            }
            em.remove(rrhh);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rrhh> findRrhhEntities() {
        return findRrhhEntities(true, -1, -1);
    }

    public List<Rrhh> findRrhhEntities(int maxResults, int firstResult) {
        return findRrhhEntities(false, maxResults, firstResult);
    }

    private List<Rrhh> findRrhhEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rrhh.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rrhh findRrhh(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rrhh.class, id);
        } finally {
            em.close();
        }
    }

    public int getRrhhCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rrhh> rt = cq.from(Rrhh.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
