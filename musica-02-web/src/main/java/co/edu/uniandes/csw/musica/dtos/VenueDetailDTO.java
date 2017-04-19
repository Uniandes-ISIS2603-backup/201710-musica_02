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

import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class VenueDetailDTO extends VenueDTO {

    private CiudadDTO ciudadDTO;

    private FestivalDTO festivalDTO;

    private List<FuncionDTO> funcionDTOs;

    public VenueDetailDTO() {
        super();
    }

    public VenueDetailDTO(VenueEntity entity) {
        super(entity);
        if(entity.getCiudadEntity() != null)
        ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
        if(entity.getFestivalEntity() != null)
        festivalDTO = new FestivalDTO(entity.getFestivalEntity());
        funcionDTOs = new ArrayList<FuncionDTO>();
        for (FuncionEntity c : entity.getFuncionEntity()) {
            funcionDTOs.add(new FuncionDTO(c));
        }

    }

    @Override
    public VenueEntity toEntity() {
        VenueEntity entity = super.toEntity();

        if (getFestivalDTO() != null) {
            entity.setFestivalEntity(getFestivalDTO().toEntity());
        }
        if (getCiudadDTO() != null) {
            entity.setCiudadEntity(getCiudadDTO().toEntity());
        }
        List<FuncionEntity> funcionesEnti = new ArrayList<FuncionEntity>();
        if (funcionDTOs != null) {

            for (FuncionDTO c : funcionDTOs) {
                funcionesEnti.add(c.toEntity());
            }
            entity.setFuncionEntity(funcionesEnti);
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
     * @return the festivalDTO
     */
    public FestivalDTO getFestivalDTO() {
        return festivalDTO;
    }

    /**
     * @param festivalDTO the festivalDTO to set
     */
    public void setFestivalDTO(FestivalDTO festivalDTO) {
        this.festivalDTO = festivalDTO;
    }

    /**
     * @return the funcionDTOs
     */
    public List<FuncionDTO> getFuncionDTOs() {
        return funcionDTOs;
    }

    /**
     * @param funcionDTOs the funcionDTOs to set
     */
    public void setFuncionDTOs(List<FuncionDTO> funcionDTOs) {
        this.funcionDTOs = funcionDTOs;
    }

}
