/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
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
public class ArtistaPersistence 
{
    
@PersistenceContext(unitName ="musicaPU")
    protected EntityManager em;

    public ArtistaEntity find(Long id) {
        return em.find(ArtistaEntity.class, id);
    }

    public List<ArtistaEntity> findAll() {
        TypedQuery<ArtistaEntity> q = em.createQuery("select u from ArtistaEntity u", ArtistaEntity.class);
        List<ArtistaEntity> todosLosArtistas = q.getResultList();
        return todosLosArtistas;
    }

    public ArtistaEntity create(ArtistaEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ArtistaEntity update(ArtistaEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ArtistaEntity entity = em.find(ArtistaEntity.class, id);
        em.remove(entity);
    }    
    
    
}
