/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class DiscoDetailDTO extends DiscoDTO
{

    /**
     * @generated
     */
    private ArtistaDTO artistaDTO;
    private List<CancionDTO> cancionesDTOs;
    
    
    public DiscoDetailDTO() 
    {
        super();
    }

    public DiscoDetailDTO(DiscoEntity entity) {
        super(entity);
        
        if(entity != null)
        {
            if (entity.getArtistaEntity() != null)
            {
                artistaDTO = new ArtistaDTO(entity.getArtistaEntity());
            }
            
            cancionesDTOs = new ArrayList<CancionDTO>();
               
            for (CancionEntity c : entity.getCanciones()) {
                cancionesDTOs.add(new CancionDTO(c));
            }     
            
        
        }
    }

    @Override
    public DiscoEntity toEntity() {
        
        DiscoEntity entity = super.toEntity();
        
        if (getArtistaDTO() != null) {
            entity.setArtistaEntity(getArtistaDTO().toEntity());
        }
        
        if (getCancionesDTOs() != null) {
            List<CancionEntity> canciones = new ArrayList<CancionEntity>();
            for (CancionDTO c : getCancionesDTOs()) {
                canciones.add(c.toEntity());
            }
            entity.setCanciones(canciones);
        }
        
        return entity;
        
    }

    /**
     * @return the artistaDTO
     */
    public ArtistaDTO getArtistaDTO() {
        return artistaDTO;
    }

    /**
     * @param artistaDTO the artistaDTO to set
     */
    public void setArtistaDTO(ArtistaDTO artistaDTO) {
        this.artistaDTO = artistaDTO;
    }

    /**
     * @return the cancionesDTOs
     */
    public List<CancionDTO> getCancionesDTOs() {
        return cancionesDTOs;
    }

    /**
     * @param cancionesDTOs the cancionesDTOs to set
     */
    public void setCancionesDTOs(List<CancionDTO> cancionesDTOs) {
        this.cancionesDTOs = cancionesDTOs;
    }


    
}
