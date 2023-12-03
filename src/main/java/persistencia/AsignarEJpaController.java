/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.AsignarE;
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
public class AsignarEJpaController implements Serializable {

    public AsignarEJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AsignarEJpaController(){
        emf=Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignarE asignarE) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignarE);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsignarE asignarE) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            asignarE = em.merge(asignarE);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = asignarE.getId();
                if (findAsignarE(id) == null) {
                    throw new NonexistentEntityException("The asignarE with id " + id + " no longer exists.");
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
            AsignarE asignarE;
            try {
                asignarE = em.getReference(AsignarE.class, id);
                asignarE.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignarE with id " + id + " no longer exists.", enfe);
            }
            em.remove(asignarE);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsignarE> findAsignarEEntities() {
        return findAsignarEEntities(true, -1, -1);
    }

    public List<AsignarE> findAsignarEEntities(int maxResults, int firstResult) {
        return findAsignarEEntities(false, maxResults, firstResult);
    }

    private List<AsignarE> findAsignarEEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignarE.class));
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

    public AsignarE findAsignarE(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignarE.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignarECount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignarE> rt = cq.from(AsignarE.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
