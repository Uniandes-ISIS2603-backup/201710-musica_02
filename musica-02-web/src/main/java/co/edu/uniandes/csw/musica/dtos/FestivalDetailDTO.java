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
        ciudadDTO = new CiudadDTO (entity.getCiudadEntity());
        funcionesDTOs = new ArrayList<FuncionDTO>();
        for(FuncionEntity funcion: entity.getFuncionesEntities())
        {
        funcionesDTOs.add(new FuncionDTO (funcion));
        }
        venuesDTOs = new ArrayList<VenueDTO>();
        for(VenueEntity venue: entity.getVenuesEntities())
       {
         venuesDTOs.add(new VenueDTO (venue));
        }
    }
    @Override
    public FestivalEntity toEntity() 
    {
        FestivalEntity entity = super.toEntity();
        if(ciudadDTO != null)
        entity.setCiudadEntity(ciudadDTO.toEntity());
        if(funcionesDTOs != null){
        ArrayList <FuncionEntity> funciones = new ArrayList<FuncionEntity> ();
        for(FuncionDTO funcion: funcionesDTOs)
        {
         funciones.add(funcion.toEntity());
        }
        entity.setFuncionesEntities(funciones);
        }
        if(venuesDTOs!=null)
        {
         ArrayList <VenueEntity> venues = new ArrayList<VenueEntity> ();
        for(VenueDTO venue: venuesDTOs)
        {
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

