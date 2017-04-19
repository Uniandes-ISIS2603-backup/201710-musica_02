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

import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import java.util.ArrayList;
import java.util.Date;
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
public class FuncionPersistence {

    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;

    public FuncionEntity find(Long id) {
        return em.find(FuncionEntity.class, id);
    }

    public List<FuncionEntity> findAll() {
        TypedQuery<FuncionEntity> q = em.createQuery("select u from FuncionEntity u", FuncionEntity.class);
        List<FuncionEntity> allFunciones = q.getResultList();
        return allFunciones;
    }

    public FuncionEntity create(FuncionEntity entity) {
        em.persist(entity);
        return entity;
    }

    public FuncionEntity update(FuncionEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        FuncionEntity entity = em.find(FuncionEntity.class, id);
        em.remove(entity);
    }

    public List<FuncionEntity> findAllFecha(Date fecha) {
        TypedQuery<FuncionEntity> q = em.createQuery("SELECT u FROM FuncionEntity u WHERE u.fecha = :hola", FuncionEntity.class);
        q = q.setParameter("hola", fecha);
        List<FuncionEntity> funcFecha = q.getResultList();
        return funcFecha;
    }

    public List<FuncionEntity> findAllEsPaga(Boolean esPaga) {
        TypedQuery<FuncionEntity> q = em.createQuery("SELECT u FROM FuncionEntity u WHERE u.esPaga = :hola", FuncionEntity.class);
        q = q.setParameter("hola", esPaga);
        List<FuncionEntity> funEsPaga = q.getResultList();
        return funEsPaga;
    }
    
    public FuncionEntity agregarVenue(Long venID, Long funID)
    {
        TypedQuery<FuncionEntity> q =  em.createQuery("UPDATE FuncionEntity u SET u.venueEntity = :venID WHERE u.id = : funId", FuncionEntity.class);
        q = q.setParameter("venID", venID).setParameter("funId", funID);
        q.executeUpdate();
        return q.getSingleResult();
        
    }
    
    public FuncionEntity agregarEntrada(Long entID, Long funID) {
        TypedQuery<FuncionEntity> q =  em.createQuery("UPDATE FuncionEntity u SET u.entradaEntity = :venID WHERE u.id = : funId", FuncionEntity.class);
        q = q.setParameter("entID", entID).setParameter("funId", funID);
        q.executeUpdate();
        return q.getSingleResult();
    }
     public List<FuncionEntity> findByFestival(Long fest) {
        TypedQuery<FuncionEntity> q = em.createQuery("select fu from FestivalEntity fe join fe.funcionesEntities fu where fe.id = :id", FuncionEntity.class);
        q = q.setParameter("id", fest);
        List<FuncionEntity> funs = q.getResultList();
        return funs;
    }
}
