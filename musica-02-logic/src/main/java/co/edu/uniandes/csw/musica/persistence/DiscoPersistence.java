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
@Stateless
public class DiscoPersistence 
{
    
    @PersistenceContext(unitName ="musicaPU")
    protected EntityManager em;

    public DiscoEntity find(Long id) {
        return em.find(DiscoEntity.class, id);
    }

    public List<DiscoEntity> findAll(Long id) {
        
        TypedQuery<DiscoEntity> q = em.createQuery("select u from DiscoEntity u WHERE u.artistaEntity.id = :var", DiscoEntity.class);
        q = q.setParameter("var", id);
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
