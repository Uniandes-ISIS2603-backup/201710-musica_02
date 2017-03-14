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

    private FuncionDTO funcionDTO;

    public VenueDetailDTO() {
        super();
    }

    public VenueDetailDTO(VenueEntity entity) {
        super(entity);
        ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
        festivalDTO = new FestivalDTO(entity.getFestivalEntity());
        funcionDTO = new FuncionDTO(entity.getFuncionEntity());
        
        
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
        if (getFuncionDTO() != null) {
            
            entity.setFuncionEntity(getFuncionDTO().toEntity());
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
     * @return the funcionDTO
     */
    public FuncionDTO getFuncionDTO() {
        return funcionDTO;
    }

    /**
     * @param funcionDTO the funcionDTO to set
     */
    public void setFuncionDTO(FuncionDTO funcionDTO) {
        this.funcionDTO = funcionDTO;
    }

   
    

}
