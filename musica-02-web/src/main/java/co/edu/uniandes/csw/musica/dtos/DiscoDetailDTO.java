/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import javax.xml.bind.annotation.XmlRootElement;

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
    
    public DiscoDetailDTO() 
    {
        super();
    }

    public DiscoDetailDTO(DiscoEntity entity) {
        super(entity);
        artistaDTO = new ArtistaDTO(entity.getArtistaEntity());
    }

    @Override
    public DiscoEntity toEntity() 
    {
        DiscoEntity entity = super.toEntity();
        
        if(artistaDTO != null)
        {
            entity.setArtistaEntity(artistaDTO.toEntity());
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

    
}
