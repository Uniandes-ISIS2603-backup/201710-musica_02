/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author p.salazar12
 */
@Stateless
public class EntradaPersistence {
    
    @PersistenceContext(unitName="musicaPU")
    protected EntityManager em;
    
    public EntradaEntity find(Long id) {
        return em.find(EntradaEntity.class, id);
    }
    
    
    public List<EntradaEntity> findAll() {
        TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u", EntradaEntity.class);
        List<EntradaEntity> allEntradas = q.getResultList();
        return allEntradas;
    }
    
    public List<EntradaEntity> findByCliente(String usuario) {
         TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u where u.clienteEntity = :usuario", EntradaEntity.class);
        q = q.setParameter("usuario", usuario);
        List<EntradaEntity> entradas = q.getResultList();
        if (entradas.isEmpty() ) {
            return null; 
        } else {
            //return (List<EntradaEntity>) entradas.get(0);
            return (List<EntradaEntity>) entradas;
        }
    }
    
    public List<EntradaEntity> findByFuncion(Integer id) {
         TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u where u.funcionEntity = :id", EntradaEntity.class);
        q = q.setParameter("id", id);
        List<EntradaEntity> entradas = q.getResultList();
        if (entradas.isEmpty() ) {
            return null; 
        } else {
            //return (List<EntradaEntity>) entradas.get(0);
            return (List<EntradaEntity>) entradas;
        }
    }
    
    public ClienteEntity getCliente(Long id) {
         TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u where u.id = :id", EntradaEntity.class);
       return (ClienteEntity) q.getParameter("cliente");
    }
    
    
    public EntradaEntity create(EntradaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public EntradaEntity update(EntradaEntity entity) {
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        EntradaEntity entity = em.find(EntradaEntity.class, id);
        em.remove(entity);
    }
    
    
    
    
    
}
