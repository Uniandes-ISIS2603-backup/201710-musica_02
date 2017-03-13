/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author af.olivares10
 */
@Stateless
public class FestivalPersistence {

    @PersistenceContext(unitName = "musica")
    protected EntityManager em;

    public FestivalEntity find(Long id) {
          TypedQuery<FestivalEntity> q
                = em.createQuery("select u from FestivalEntity u where u.id = :id", FestivalEntity.class);
        q = q.setParameter("id", id);
        
       List<FestivalEntity> sameId = q.getResultList();
        if (sameId.isEmpty() ) {
            return null; 
        } else {
            return sameId.get(0);
        }

        
    }

    public List<FestivalEntity> findAll() {
        TypedQuery<FestivalEntity> q = em.createQuery("select u from FestivalEntity u", FestivalEntity.class);
        List<FestivalEntity> allFestivals = q.getResultList();
        return allFestivals;
    }

    public FestivalEntity create(FestivalEntity entity) {

        em.persist(entity); 
        return entity;
    }

}
