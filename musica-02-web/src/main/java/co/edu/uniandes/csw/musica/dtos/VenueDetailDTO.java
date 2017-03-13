package co.edu.uniandes.csw.musica.dtos;


import co.edu.uniandes.csw.musica.entities.VenueEntity;
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

    public VenueDetailDTO(VenueEntity entity)
    {
        super(entity);
        ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
        festivalDTO = new FestivalDTO(entity.getFestivalEntity());
        funcionDTO = new FuncionDTO(entity.getFuncionEntity());
    }

    @Override
    public VenueEntity toEntity() {
        VenueEntity entity = super.toEntity();

        if (festivalDTO != null) {
            entity.setFestivalEntity(festivalDTO.toEntity());
        }
        if (ciudadDTO != null) {
            entity.setCiudadEntity(ciudadDTO.toEntity());
        }
        if (funcionDTO != null) {
            entity.setFuncionEntity(funcionDTO.toEntity());
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

