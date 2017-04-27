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

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author af.olivares10
 */
@Stateless
public class FestivalPersistence {

    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;

    public FestivalEntity find(Long id) {
        TypedQuery<FestivalEntity> q
                = em.createQuery("select u from FestivalEntity u where u.id = :id", FestivalEntity.class);
        q = q.setParameter("id", id);

        List<FestivalEntity> sameId = q.getResultList();
        if (sameId.isEmpty()) {
            return null;
        } else {
            return sameId.get(0);
        }

    }

    public FestivalEntity findPorGenero(String genero) {
        TypedQuery<FestivalEntity> q
                = em.createQuery("select u from FestivalEntity u where u.genero = :genero", FestivalEntity.class);
        q = q.setParameter("genero", genero);

        List<FestivalEntity> sameId = q.getResultList();
        if (sameId.isEmpty()) {
            return null;
        } else {
            return sameId.get(0);
        }

    }

    public List<FestivalEntity> findAll() {
        TypedQuery<FestivalEntity> q = em.createQuery("select u from FestivalEntity u", FestivalEntity.class);
        List<FestivalEntity> allFestivals = q.getResultList();
        return allFestivals;
    }

    public FestivalEntity create(FestivalEntity entity) {
        em.persist(entity);
        return entity;
    }

    public FestivalEntity update(FestivalEntity entity) {
        em.merge(entity);
        return entity;
    }

}
