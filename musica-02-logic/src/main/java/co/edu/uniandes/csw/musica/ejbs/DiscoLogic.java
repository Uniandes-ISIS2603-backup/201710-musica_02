/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import javax.ejb.Stateless;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import co.edu.uniandes.csw.musica.persistence.DiscoPersistence;
import java.util.List;
import javax.inject.Inject;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;


/**
 *correo 
 * @author a.echeverrir
 */
@Stateless
public class DiscoLogic 
{
    
    @Inject 
    private DiscoPersistence persistence;
   
   public List<DiscoEntity> getDiscos(Long id)
   {
       return persistence.findAll(id);
   }
   public DiscoEntity getDisco(Long id) throws BusinessLogicException
   {
        DiscoEntity entity = persistence.find(id);
        if(entity != null)
        return persistence.find(id);
        else throw new BusinessLogicException ("No se ha encontrado un disco con dicho Id");
    
   }
   public DiscoEntity createDisco(DiscoEntity entity)
   {
       return persistence.create(entity);
   }
   public DiscoEntity updateDisco(DiscoEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteDisco(Long id)
   {
       persistence.delete(id);
   }
    
    
}
