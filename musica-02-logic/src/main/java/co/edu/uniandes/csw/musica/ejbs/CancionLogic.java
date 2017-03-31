/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import co.edu.uniandes.csw.musica.persistence.CancionPersistence;

/**
 *
 * @author a.echeverrir
 */
@Stateless
public class CancionLogic 
{

    @Inject 
    private CancionPersistence persistence;
    
     public List<CancionEntity> getCanciones(Long id)
   {
       return persistence.findAll(id);
   }
   public CancionEntity getCancion(Long id) throws BusinessLogicException
   {
        CancionEntity entity = persistence.find(id);
        if(entity != null)
        return persistence.find(id);
        else throw new BusinessLogicException ("No se ha encontrado una cancion con dicho Id");
    
   }
   public CancionEntity createCancion(CancionEntity entity)
   {
       return persistence.create(entity);
   }
   public void deleteCancion(Long id)
   {
       persistence.delete(id);
   }
    
}
