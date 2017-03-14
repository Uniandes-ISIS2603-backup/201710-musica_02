package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class FuncionDetailDTO extends FuncionDTO {

    /**
     * @generated
     */
    private List<ReviewDTO> reviewsDTOs;
    private FestivalDTO festivalDTO;
    private List<ArtistaDTO> artistasDTOs;
    private List<EntradaDTO> entradaDTOs;
    private VenueDTO venueDTO;

    public FuncionDetailDTO() {
        super();

    }

    public FuncionDetailDTO(FuncionEntity entity) {
        super(entity);
        reviewsDTOs = new ArrayList<ReviewDTO>();
        festivalDTO = new FestivalDTO(entity.getFestival());
        artistasDTOs = new ArrayList<ArtistaDTO>();
        entradaDTOs = new ArrayList<EntradaDTO>();
        venueDTO = new VenueDTO(entity.getVenueEntity());

        for (ReviewEntity rev : entity.getReviews()) {
            reviewsDTOs.add(new ReviewDTO(rev));
        }
        for (ArtistaEntity c : entity.getArtistas()) {
            artistasDTOs.add(new ArtistaDTO(c));
        }
    }

    @Override
    public FuncionEntity toEntity() {

        FuncionEntity entity = super.toEntity();

        if (festivalDTO != null) {
            entity.setFestival(festivalDTO.toEntity());
        }
        if (venueDTO != null) {
            entity.setVenueEntity(venueDTO.toEntity());
        }
     

        if (artistasDTOs != null) {
               List<ArtistaEntity> artistas = new ArrayList<ArtistaEntity>();
            for (ArtistaDTO c : artistasDTOs) {
                artistas.add(c.toEntity());
            }
            entity.setArtistas(artistas);
        }

        if (reviewsDTOs != null) {
            List<ReviewEntity> reviews = new ArrayList<ReviewEntity>();
            for (ReviewDTO c : reviewsDTOs) {
                reviews.add(c.toEntity());
            }
            entity.setReviews(reviews);
        }
        
        if (entradaDTOs != null) {
            List<EntradaEntity> entradas = new ArrayList<EntradaEntity>();
            for (EntradaDTO c : entradaDTOs) {
                entradas.add(c.toEntity());
            }
            entity.setEntradas(entradas);
        }
        return entity;
    }

    /**
     * @return the reviewsDTOs
     */
    public List<ReviewDTO> getReviewsDTOs() {
        return reviewsDTOs;
    }

    /**
     * @param reviewsDTOs the reviewsDTOs to set
     */
    public void setReviewsDTOs(List<ReviewDTO> reviewsDTOs) {

        this.reviewsDTOs = reviewsDTOs;
    }

    public List<ReviewDTO> addReviewsDTOs(ReviewDTO dto) {
        reviewsDTOs.add(dto);

        return reviewsDTOs;
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
     * @return the artistasDTOs
     */
    public List<ArtistaDTO> getArtistasDTOs() {
        return artistasDTOs;
    }

    /**
     * @param artistasDTOs the artistasDTOs to set
     */
    public void setArtistasDTOs(List<ArtistaDTO> artistasDTOs) {
        this.artistasDTOs = artistasDTOs;
    }

    /**
     * @return the venueDTO
     */
    public VenueDTO getVenueDTO() {
        return venueDTO;
    }

    /**
     * @param venueDTO the venueDTO to set
     */
    public void setVenueDTO(VenueDTO venueDTO) {
        this.venueDTO = venueDTO;
    }
}
