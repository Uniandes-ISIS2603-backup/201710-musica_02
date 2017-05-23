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
