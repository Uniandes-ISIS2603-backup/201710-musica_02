/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CiudadDetailDTO extends CiudadDTO {

    private List<FestivalDTO> festivales;
    private List<VenueDTO> venues;

    public CiudadDetailDTO() {
        super();
    }

    /*
     * Crea un objeto CiudadDTO a partir de un objeto CiudadEntity
     * @param entity Entidad CiudadEntity desde la cual se va a crear el nuevo objeto.
     */
    public CiudadDetailDTO(CiudadEntity entity) {
        super(entity);
        if (entity != null) {
            List<FestivalEntity> listaDeFestivales = entity.getFestivales();
            festivales = new ArrayList<>();
            venues = new ArrayList<>();
            for (FestivalEntity festival : listaDeFestivales) {
                festivales.add(new FestivalDTO(festival));
            }
            List<VenueEntity> listaDeVenues = entity.getVenues();
            for (VenueEntity venue : listaDeVenues) {
                venues.add(new VenueDTO(venue));
            }
        }
    }

    /*
    * Convierte un objeto CiudadDetailDTO a CiudadEntity
    * @return un objeto de tipo CiudadEntity.
     */
    @Override
    public CiudadEntity toEntity() {
        CiudadEntity entity = super.toEntity();
        if (getFestivales() != null) {
            List<FestivalEntity> fe = new ArrayList<>();
            for (FestivalDTO f : getFestivales()) {
                fe.add(f.toEntity());
            }
            entity.setFestivales(fe);
        }
        if (getVenues() != null) {
            List<VenueEntity> ve = new ArrayList<>();
            for (VenueDTO f : getVenues()) {
                ve.add(f.toEntity());
            }
            entity.setVenues(ve);
        }
        return entity;
    }

    /**
     * @return the festivales
     */
    public List<FestivalDTO> getFestivales() {
        return festivales;
    }

    /**
     * @param festivales the festivales to set
     */
    public void setFestivales(List<FestivalDTO> festivales) {
        this.festivales = festivales;
    }

    /**
     * @return the venues
     */
    public List<VenueDTO> getVenues() {
        return venues;
    }

    /**
     * @param venues the venues to set
     */
    public void setVenues(List<VenueDTO> venues) {
        this.venues = venues;
    }
}
