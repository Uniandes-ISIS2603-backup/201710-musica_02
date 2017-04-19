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
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.VenueEntity;
import co.edu.uniandes.csw.musica.persistence.VenuePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;


/**
 *
 * @author a.echeverrir
 */

// TODO falta implementar las reglas de negocio. POr ejemplo la creación de 
//    venue debe traer el festival y la ciudad y estos debe ser válidos.
@Stateless
public class VenueLogic {
   
    
   @Inject private VenuePersistence persistence;
   
   public List<VenueEntity> getVenues()
   {
       return persistence.findAll();
   }
   public VenueEntity getVenue(Long id) throws BusinessLogicException
   {
        VenueEntity entity = persistence.find(id);
        if(entity != null)
        return persistence.find(id);
        else throw new BusinessLogicException ("No se ha encontrado un venue con dicho Id");
    
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
   
   //TODO quién llama este método?
   public VenueEntity agregarVenueFuncion(Long venueID, Long funID)
   {
       return persistence.agregarVenueFuncion(venueID, funID);
   }
}
