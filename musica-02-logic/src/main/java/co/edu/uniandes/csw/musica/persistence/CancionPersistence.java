/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.CancionEntity;
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
public class CancionPersistence {
    
    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;
    
    public List<CancionEntity> findAll(Long id)
    {
        TypedQuery<CancionEntity> q = em.createQuery("select u from CancionEntity u where u.discoEntity.id = :var", CancionEntity.class);
        q = q.setParameter("var", id);
        List<CancionEntity> allCanciones = q.getResultList();
        return allCanciones;
    }
    
    public CancionEntity find(Long id)
    {
         return em.find(CancionEntity.class, id);
    }
    
    public CancionEntity create(CancionEntity entity)
    {
        em.persist(entity);
        return entity;
    }
    
    public void delete(Long id)
    {
        CancionEntity entity = em.find(CancionEntity.class, id);
        em.remove(entity);
    }
    
    
    
    
    
    
}
