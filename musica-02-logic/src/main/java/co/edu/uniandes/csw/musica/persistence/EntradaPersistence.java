/* 
 * The MIT License
 *
 * Copyright 2017 Mighty Fingers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
    
    public List<EntradaEntity> findByCliente(Long cliente) {
        //select fu from FestivalEntity fe join fe.funcionesEntities fu where fe.id = :id
        //select u from EntradaEntity u where u.CLIENTEENTITY_ID = :ids
         TypedQuery<EntradaEntity> q = em.createQuery("select fu from ClienteEntity fe join fe.entradas fu where fe.id = :id", EntradaEntity.class);
        q = q.setParameter("id", cliente);
        List<EntradaEntity> entradas = q.getResultList();
        if (entradas.isEmpty() ) {
            return null; 
        } else {
            //return (List<EntradaEntity>) entradas.get(0);
            return (List<EntradaEntity>) entradas;
        }
    }
    
    public List<EntradaEntity> findByFuncion(Long ids) {
         TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u where u.funcionEntity_id = :ids", EntradaEntity.class);
        q = q.setParameter("ids", ids);
        List<EntradaEntity> entradas = q.getResultList();
        if (entradas.isEmpty() ) {
            return null; 
        } else {
            //return (List<EntradaEntity>) entradas.get(0);
            return (List<EntradaEntity>) entradas;
        }
    }
    
    public ClienteEntity getCliente(Long ids) {
         TypedQuery<EntradaEntity> q = em.createQuery("select u from EntradaEntity u where u.ids = :ids", EntradaEntity.class);
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
