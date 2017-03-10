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
    //private CiudadDTO ciudadDTO;
   //private VenueDTO venueDTO;
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
      //  entity.setCiudadEnity(ciudadDTO.toEntity());
        //entity.setVenueEntity (venueDTO.toEntity());
        return entity;
    }
}

