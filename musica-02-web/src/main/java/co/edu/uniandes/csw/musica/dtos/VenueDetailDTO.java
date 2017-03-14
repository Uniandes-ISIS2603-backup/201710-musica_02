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
        ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
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
