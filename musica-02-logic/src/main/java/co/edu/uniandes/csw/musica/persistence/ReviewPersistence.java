/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jd.gonzaleza
 */
@Stateless
public class ReviewPersistence {

    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;
    
        public ReviewEntity find(Long id) {
        return em.find(ReviewEntity.class, id);
    }

    public List<ReviewEntity> findAll() {
        TypedQuery<ReviewEntity> q = em.createQuery("select u from ReviewEntity u", ReviewEntity.class);
        List<ReviewEntity> allFunciones = q.getResultList();
        return allFunciones;
    }

    public ReviewEntity create(ReviewEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ReviewEntity update(ReviewEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ReviewEntity entity = em.find(ReviewEntity.class, id);
        em.remove(entity);
    }
    

}
