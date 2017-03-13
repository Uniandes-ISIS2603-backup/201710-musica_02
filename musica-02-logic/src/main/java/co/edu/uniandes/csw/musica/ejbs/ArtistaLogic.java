/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.persistence.ArtistaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.echeverrir
 */
@Stateless
public class ArtistaLogic 
{
    
    @Inject private ArtistaPersistence persistence;
   
   public List<ArtistaEntity> getArtistas()
   {
       return persistence.findAll();
   }
   public ArtistaEntity getArtista(Long id)
   {
       return persistence.find(id);
   }
   public ArtistaEntity createArtista(ArtistaEntity entity)
   {
       return persistence.create(entity);
   }
   public ArtistaEntity updateArtista(ArtistaEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteArtista(Long id)
   {
       persistence.delete(id);
   }
    
}
