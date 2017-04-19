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
    public List<ArtistaEntity> findByFuncion(Long idFun)
    {
       TypedQuery<ArtistaEntity> q
                = em.createQuery("select a from ArtistaEntity a join a.funciones f where f.id = :id", ArtistaEntity.class);
        q = q.setParameter("id", idFun);
        
       List<ArtistaEntity> sameId = q.getResultList();

            return sameId;
        

    }
    
    
}
