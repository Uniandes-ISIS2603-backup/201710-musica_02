/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.VenueEntity;
import co.edu.uniandes.csw.musica.persistence.VenuePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.echeverrir
 */
@Stateless
public class VenueLogic {
   
    
   @Inject private VenuePersistence persistence;
   
   public List<VenueEntity> getVenues()
   {
       return persistence.findAll();
   }
   public VenueEntity getVenue(Long id)
   {
       return persistence.find(id);
   }
   public VenueEntity createVenue(VenueEntity entity)
   {
       return persistence.create(entity);
   }
   public VenueEntity updateVenue(VenueEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteVenue(Long id)
   {
       persistence.delete(id);
   }
}