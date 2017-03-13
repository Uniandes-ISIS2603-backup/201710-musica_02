package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class FestivalDetailDTO extends FestivalDTO
{
    private CiudadDTO ciudadDTO;
    private ArrayList <VenueDTO> venuesDTOs;
    private ArrayList<FuncionDTO> funcionesDTOs;
    public FestivalDetailDTO ()
    {
        
    }
    public FestivalDetailDTO (FestivalEntity entity)
    {
        super(entity);
        ciudadDTO = new CiudadDTO (entity.getCiudadEnity());
        funcionesDTOs = new ArrayList<>();
        for(FuncionEntity funcion: entity.getFuncionesEntities())
        {
         funcionesDTOs.add(new FuncionDTO (funcion));
        }
        venuesDTOs = new ArrayList<>();
        for(VenueEntity venue: entity.getVenuesEnities())
        {
         venuesDTOs.add(new VenueDTO (venue));
        }
    }
    @Override
    public FestivalEntity toEntity()
    {
        FestivalEntity entity = super.toEntity();
        entity.setCiudadEnity(getCiudadDTO().toEntity());
        ArrayList <FuncionEntity> funciones = new ArrayList<> ();
        for(FuncionDTO funcion: getFuncionesDTOs())
        {
         funciones.add(funcion.toEntity());
        }
        entity.setFuncionesEntities(funciones);
         ArrayList <VenueEntity> venues = new ArrayList<> ();
        for(VenueDTO venue: getVenuesDTOs())
        {
         venues.add(venue.toEntity());
        }
        entity.setFuncionesEntities(funciones);
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

    /**
     * @return the venuesDTOs
     */
    public ArrayList <VenueDTO> getVenuesDTOs() {
        return venuesDTOs;
    }

    /**
     * @param venuesDTOs the venuesDTOs to set
     */
    public void setVenuesDTOs(ArrayList <VenueDTO> venuesDTOs) {
        this.venuesDTOs = venuesDTOs;
    }
}

