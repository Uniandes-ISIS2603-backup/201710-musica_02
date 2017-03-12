/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.FuncionEntity;
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
        TypedQuery<FuncionEntity> q = em.createQuery("SELECT u FROM FuncionEntity u WHERE u.fecha LIKE :hola", FuncionEntity.class);
        q = q.setParameter("hola", fecha);
        List<FuncionEntity> funcFecha = q.getResultList();
        return funcFecha;
    }

    public List<FuncionEntity> findAllEsPaga(Boolean esPaga) {
        TypedQuery<FuncionEntity> q = em.createQuery("SELECT u FROM FuncionEntity u WHERE u.esPaga LIKE :hola", FuncionEntity.class);
        q = q.setParameter("hola", esPaga);
        List<FuncionEntity> funEsPaga = q.getResultList();
        return funEsPaga;
    }

}
