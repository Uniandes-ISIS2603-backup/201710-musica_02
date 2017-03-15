/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CiudadLogic 
{
    @Inject private CiudadPersistence persistence;
    
    /*
     * Obtiene el conjunto de los registros de ciudades
     * @return conjunto de objetos de tipo CiudadEntity
     */
    public List<CiudadEntity> getCities()
    {
        return persistence.finAll();
    }
    
    public CiudadEntity getCity(Long id)
    {
        return persistence.find(id);
    }
    
    public CiudadEntity getCityByName(String nameOfCity)
    {
        return persistence.findByName(nameOfCity);
    }

    public CiudadEntity createCity(CiudadEntity ciudadEntity) throws BusinessLogicException 
    {

            persistence.create(ciudadEntity);  
            return ciudadEntity;
    }

    public CiudadEntity updateCity(CiudadEntity ciudadEntity) 
    {
        return persistence.update(ciudadEntity);
    }

    public void deleteCity(String name) 
    {
        persistence.delete(name);
    }
    
}