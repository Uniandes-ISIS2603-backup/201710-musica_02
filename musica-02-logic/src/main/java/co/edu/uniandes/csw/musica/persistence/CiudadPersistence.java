/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CiudadPersistence 
{
    @PersistenceContext(unitName = "musicaPU")
    protected EntityManager em;
    
    public List<CiudadEntity> finAll() 
    {
        TypedQuery<CiudadEntity> q = em.createQuery("select u from CiudadEntity u", CiudadEntity.class);
        List<CiudadEntity> allCities = q.getResultList();
        return allCities;
    }

    public CiudadEntity find(String nameOfCity) 
    {
        return em.find(CiudadEntity.class, nameOfCity);
    }

    public CiudadEntity create(CiudadEntity ciudadEntity) 
    {
        em.persist(ciudadEntity);
        return ciudadEntity;
    }

    public CiudadEntity update(CiudadEntity ciudadEntity) 
    {
        return em.merge(ciudadEntity);
    }

    public void delete(String name) 
    {
        System.out.println(name);
        CiudadEntity buscada = em.find(CiudadEntity.class, name);
        if(buscada != null)
        {
            em.remove(buscada);
        }
    }
    
}
