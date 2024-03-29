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

import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jd.gonzaleza
 */
@Stateless
public class ReviewPersistence {

    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;
    
        public ReviewEntity find(Long id) {
        return em.find(ReviewEntity.class, id);
    }

    public List<ReviewEntity> findAll(Long id) {
        TypedQuery<ReviewEntity> q = em.createQuery("select u from ReviewEntity u WHERE u.funcion.id = :hola", ReviewEntity.class);
        q = q.setParameter("hola", id);
        List<ReviewEntity> allReviews = q.getResultList();
        return allReviews;
    }
    public List<ReviewEntity> findAllparaFuncion(Long id)
    {
        TypedQuery<ReviewEntity> q = em.createQuery("select u from ReviewEntity u where u.funcion.id = :id", ReviewEntity.class);
        q = q.setParameter("id", id);
        List<ReviewEntity> revs = q.getResultList();
        if (revs.isEmpty() ) {
            return null; 
        } else {
            return (List<ReviewEntity>) revs.get(0);
        }
    }

    public ReviewEntity create(ReviewEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ReviewEntity update(ReviewEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ReviewEntity entity = em.find(ReviewEntity.class, id);
        em.remove(entity);
    }
    

}
