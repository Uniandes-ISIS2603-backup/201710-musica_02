/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.echeverrir
 */
public class DiscoPersistence 
{
    
    @PersistenceContext(unitName ="musicaPU")
    protected EntityManager em;

    public DiscoEntity find(Long id) {
        return em.find(DiscoEntity.class, id);
    }

    public List<DiscoEntity> findAll() {
        TypedQuery<DiscoEntity> q = em.createQuery("select u from DiscoEntity u", DiscoEntity.class);
        List<DiscoEntity> todosLosDiscos = q.getResultList();
        return todosLosDiscos;
    }

    public DiscoEntity create(DiscoEntity entity) {
        em.persist(entity);
        return entity;
    }

    public DiscoEntity update(DiscoEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        DiscoEntity entity = em.find(DiscoEntity.class, id);
        em.remove(entity);
    }    
    
}
