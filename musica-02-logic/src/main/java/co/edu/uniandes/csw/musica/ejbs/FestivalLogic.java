/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

/**
 *
 * @author af.olivares10
 */
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.FestivalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FestivalLogic {
    
    @Inject FestivalPersistence persistence;
    
    public List<FestivalEntity> getFestivales ()
    {
        return persistence.findAll();
    }
     public FestivalEntity getFestival (Long id) throws BusinessLogicException
    {
        FestivalEntity entity = persistence.find(id);
        if(entity != null)
        return persistence.find(id);
        else throw new BusinessLogicException ("No se ha encontrado un festival con dicho Id");
    }
    public FestivalEntity createFestival (FestivalEntity festival) throws BusinessLogicException
    {
        //FestivalEntity entity = persistence.find(festival.getId());
        return persistence.create(festival);
        // Puede que nunca la lance pues el Id es autogenerado
        //else throw new BusinessLogicException ("Ya existe un festival con ese Id");
    }
    
}
