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

    public void delete(Long id) {
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
    
    public ClienteEntity findById(Long id){
        TypedQuery<ClienteEntity> q
                = em.createQuery("select u from ClienteEntity u where u.id = :id", ClienteEntity.class);
        q = q.setParameter("id", id);
        
       List<ClienteEntity> sameId = q.getResultList();
        if (sameId.isEmpty() ) {
            return null; 
        } else {
            return sameId.get(0);
        }
    }
    
    
    
    public List<ClienteEntity> findAllAbonados() {
        TypedQuery<ClienteEntity> q = em.createQuery("SELECT u FROM ClienteEntity u WHERE u.abono > 0 ", ClienteEntity.class);
        List<ClienteEntity> abonados = q.getResultList();
        return abonados;
    }
    
    
    
    
}
