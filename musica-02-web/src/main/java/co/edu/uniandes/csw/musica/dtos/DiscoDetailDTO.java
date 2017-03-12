/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;

/**
 *
 * @author a.echeverrir
 */
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
    public DiscoEntity toEntity() {        
        return super.toEntity();
    }

    
}
