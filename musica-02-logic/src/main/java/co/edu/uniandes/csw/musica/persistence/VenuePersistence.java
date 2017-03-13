/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;


import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.echeverrir
 */
@Stateless
public class VenuePersistence 
{
    
    @PersistenceContext(unitName ="musicaPU")
    protected EntityManager em;

    public VenueEntity find(Long id) {
        return em.find(VenueEntity.class, id);
    }

    public List<VenueEntity> findAll() {
        TypedQuery<VenueEntity> q = em.createQuery("select u from VenueEntity u", VenueEntity.class);
        List<VenueEntity> todosLosVenues = q.getResultList();
        return todosLosVenues;
    }

    public VenueEntity create(VenueEntity entity) {
        em.persist(entity);
        return entity;
    }

    public VenueEntity update(VenueEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        VenueEntity entity = em.find(VenueEntity.class, id);
        em.remove(entity);
    }

    public VenueEntity agregarVenueFuncion(Long venID, Long funID)
    {
        TypedQuery<VenueEntity> q =  em.createQuery("UPDATE FuncionEntity u SET u.venueEntity = :venID WHERE u.id = : funId", VenueEntity.class);
        q = q.setParameter("venID", venID).setParameter("funId", funID);
        q.executeUpdate();
        return q.getSingleResult();
        
    }

    
    
}
