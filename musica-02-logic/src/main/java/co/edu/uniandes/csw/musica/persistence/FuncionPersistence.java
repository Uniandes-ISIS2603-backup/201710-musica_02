/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
