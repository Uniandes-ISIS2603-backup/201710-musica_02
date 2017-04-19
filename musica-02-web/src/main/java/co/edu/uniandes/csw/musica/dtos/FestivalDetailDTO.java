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

import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FestivalDetailDTO extends FestivalDTO {

    private CiudadDTO ciudadDTO;
    private List<VenueDTO> venuesDTOs;
    private List<FuncionDTO> funcionesDTOs;

    public FestivalDetailDTO() {
        super();
    }

    public FestivalDetailDTO(FestivalEntity entity) {
        super(entity);
        if (entity != null) {
            if(entity.getCiudadEntity() != null)
            ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
            funcionesDTOs = new ArrayList<>();
            for (FuncionEntity funcion : entity.getFuncionesEntities()) {
                funcionesDTOs.add(new FuncionDTO(funcion));
            }
            venuesDTOs = new ArrayList<>();
            for (VenueEntity venue : entity.getVenuesEntities()) {
                venuesDTOs.add(new VenueDTO(venue));
            }
        }
    }

    @Override
    public FestivalEntity toEntity() {
        FestivalEntity entity = super.toEntity();
        if (ciudadDTO != null) {
            entity.setCiudadEntity(ciudadDTO.toEntity());
        }
        if (funcionesDTOs != null) {
            ArrayList<FuncionEntity> funciones = new ArrayList<FuncionEntity>();
            for (FuncionDTO funcion : funcionesDTOs) {
                funciones.add(funcion.toEntity());
            }
            entity.setFuncionesEntities(funciones);
        }
        if (venuesDTOs != null) {
            ArrayList<VenueEntity> venues = new ArrayList<VenueEntity>();
            for (VenueDTO venue : venuesDTOs) {
                venues.add(venue.toEntity());
            }
            entity.setVenuesEntities(venues);
        }
        return entity;
    }

    /**
     * @return the ciudadDTO
     */
    public CiudadDTO getCiudadDTO() {
        return ciudadDTO;
    }

    /**
     * @param ciudadDTO the ciudadDTO to set
     */
    public void setCiudadDTO(CiudadDTO ciudadDTO) {
        this.ciudadDTO = ciudadDTO;
    }

    /**
     * @return the funcionesDTOs
     */
    public List<FuncionDTO> getFuncionesDTOs() {
        return funcionesDTOs;
    }

    /**
     * @param funcionesDTOs the funcionesDTOs to set
     */
    public void setFuncionesDTOs(List<FuncionDTO> funcionesDTOs) {
        this.funcionesDTOs = funcionesDTOs;
    }

    /**
     * @return the venuesDTOs
     */
    public List<VenueDTO> getVenuesDTOs() {
        return venuesDTOs;
    }

    /**
     * @param venuesDTOs the venuesDTOs to set
     */
    public void setVenuesDTOs(List<VenueDTO> venuesDTOs) {
        this.venuesDTOs = venuesDTOs;
    }
}
