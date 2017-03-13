/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CiudadDetailDTO extends CiudadDTO 
{
    private List<FestivalDTO> festivales;
    private List<VenueDTO> venues;
    
    public CiudadDetailDTO() 
    {
        super();
    }

    /*
     * Crea un objeto CiudadDTO a partir de un objeto CiudadEntity
     * @param entity Entidad CiudadEntity desde la cual se va a crear el nuevo objeto.
     */
    public CiudadDetailDTO(CiudadEntity entity) 
    {
        super(entity);
        List<FestivalEntity> listaDeFestivales =  entity.getFestivales();
        for(FestivalEntity festival : listaDeFestivales)
        {
            this.festivales.add(new FestivalDTO(festival));
        }
        List<VenueEntity> listaDeVenues =  entity.getVenues();
        for(VenueEntity venue : listaDeVenues)
        {
            this.venues.add(new VenueDTO(venue));
        }
    }

   /*
    * Convierte un objeto CiudadDetailDTO a CiudadEntity
    * @return un objeto de tipo CiudadEntity.
    */
    @Override
    public CiudadEntity toEntity() {
        CiudadEntity entity = super.toEntity();
        return entity;
    }
}