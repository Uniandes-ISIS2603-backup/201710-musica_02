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
