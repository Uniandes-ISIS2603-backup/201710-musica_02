/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.musica.entities.CancionEntity;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class CancionDetailDTO extends CancionDTO
{
    
    private DiscoDTO discoDTO;
    
    public CancionDetailDTO(){
        super();
    }
    
    public CancionDetailDTO(CancionEntity entity)
    {
        super(entity);
        
        if(entity.getDiscoEntity() != null){
            discoDTO = new DiscoDTO(entity.getDiscoEntity());
        }
        
    }
    
    @Override
    public CancionEntity toEntity()
    {
         CancionEntity entity = super.toEntity();
         if(getDiscoDTO() != null){
             entity.setDiscoEntity(getDiscoDTO().toEntity());
         }
         return entity;
    }

    /**
     * @return the discoDTO
     */
    public DiscoDTO getDiscoDTO() {
        return discoDTO;
    }

    /**
     * @param discoDTO the discoDTO to set
     */
    public void setDiscoDTO(DiscoDTO discoDTO) {
        this.discoDTO = discoDTO;
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
