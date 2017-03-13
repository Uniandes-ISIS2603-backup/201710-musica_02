package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class FestivalDetailDTO extends FestivalDTO
{
    private CiudadDTO ciudadDTO;
   private VenueDTO venueDTO;
    private ArrayList<FuncionDTO> funcionesDTOs;
    public FestivalDetailDTO ()
    {
        
    }
    public FestivalDetailDTO (FestivalEntity entity)
    {
        super(entity);
        //ciudadDTO = new CiudadDTO (entity.getCiudadEnity());
        funcionesDTOs = new ArrayList<>();
        for(FuncionEntity funcion: entity.getFuncionesEntities())
        {
         funcionesDTOs.add(new FuncionDTO (funcion));
        }
        //venueDTO = new VenueDTO (entity.getVenueEntity());
    }
    @Override
    public FestivalEntity toEntity()
    {
        FestivalEntity entity = super.toEntity();
        entity.setCiudadEnity(getCiudadDTO().toEntity());
        entity.setVenueEntity (venueDTO.toEntity());
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
    public ArrayList<FuncionDTO> getFuncionesDTOs() {
        return funcionesDTOs;
    }

    /**
     * @param funcionesDTOs the funcionesDTOs to set
     */
    public void setFuncionesDTOs(ArrayList<FuncionDTO> funcionesDTOs) {
        this.funcionesDTOs = funcionesDTOs;
    }
}

