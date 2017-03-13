/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
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
public class ClientePersistence {
    
    @PersistenceContext(unitName ="musicaPU")
    protected EntityManager em;
    
    public ClienteEntity find(String id) {
        return em.find(ClienteEntity.class, id);
                
    }
    
    public List<ClienteEntity> findAll() {
        TypedQuery<ClienteEntity> q = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        List<ClienteEntity> allClientes = q.getResultList();
        return allClientes;
    }

    public ClienteEntity create(ClienteEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ClienteEntity update(ClienteEntity entity) {
        return em.merge(entity);
    }

    public void delete(String id) {
        ClienteEntity entity = em.find(ClienteEntity.class, id);
        em.remove(entity);
    }
    
    public ClienteEntity findByUsuario(String usuario){
        TypedQuery<ClienteEntity> q
                = em.createQuery("select u from ClienteEntity u where u.usaurio = :usuario", ClienteEntity.class);
        q = q.setParameter("usuario", usuario);
        
       List<ClienteEntity> sameUsuario = q.getResultList();
        if (sameUsuario.isEmpty() ) {
            return null; 
        } else {
            return sameUsuario.get(0);
        }
    }
    
    
    
    
}
