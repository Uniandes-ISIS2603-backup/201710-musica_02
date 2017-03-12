/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jd.gonzaleza
 */
 @Stateless
public class FuncionLogic {
    
   @Inject private FuncionPersistence persistence;
   
   public List<FuncionEntity> getFunciones()
   {
       return persistence.findAll();
   }
   public FuncionEntity getFuncion(Long id)
   {
       return persistence.find(id);
   }
   
   public List<FuncionEntity> getFuncionesFecha(Date fecha)
   {
       return persistence.findAllFecha(fecha);
   }
   public List<FuncionEntity> getFuncionesEsPaga(Boolean paga)
   {
       return persistence.findAllEsPaga(paga);
   }
   public FuncionEntity createFuncion(FuncionEntity entity)
   {
       return persistence.create(entity);
   }
   public FuncionEntity updateFuncion(FuncionEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteFuncion(Long id)
   {
       persistence.delete(id);
   }
   public FuncionEntity agregarVenueEntity(Long funID, Long venueID)
   {
       return persistence.agregarVenue(venueID, funID);
   }
    
}
