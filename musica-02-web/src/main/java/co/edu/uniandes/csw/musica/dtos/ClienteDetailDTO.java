package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlRootElement
public class ClienteDetailDTO extends ClienteDTO
{

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(List<EntradaDTO> entradas) {
        this.entradas = entradas;
    }
	
	
    private List<EntradaDTO> entradas;

    private List<ReviewDTO> reviewDTOs;


    public ClienteDetailDTO(){
            super();
    }

    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
        entradas = new ArrayList<EntradaDTO>();
        reviewDTOs = new ArrayList<ReviewDTO>();
        for(ReviewEntity c : entity.getReviews())
        {
            reviewDTOs.add(new ReviewDTO(c));
        }
        for(EntradaEntity e : entity.getEntradas())
        {
            entradas.add(new EntradaDTO(e));
        }
        
    }

    @Override
    public ClienteEntity toEntity() {
        
        ClienteEntity entity = super.toEntity();
        List<EntradaEntity> entradasEn = new  ArrayList<>();
        List<ReviewEntity> revs = new  ArrayList<>();
        if(getEntradas() != null)
        {
             for (EntradaDTO c : getEntradas()) {
            entradasEn.add(c.toEntity());
        }
             entity.setEntradas(entradasEn);
        }
        if(getReviewDTOs() != null)
        {
            for(ReviewDTO f : getReviewDTOs()){
               revs.add(f.toEntity());
            }
            entity.setReviews(revs);
        }
        return entity;
        
    }

    /**
     * @return the entradas
     */
    public List<EntradaDTO> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(ArrayList<EntradaDTO> entradas) {
        this.setEntradas(entradas);
    }

   
    /**
     * @return the reviewDTOs
     */
    public List<ReviewDTO> getReviewDTOs() {
        return reviewDTOs;
    }

    /**
     * @param reviewDTOs the reviewDTOs to set
     */
    public void setReviewDTOs(List<ReviewDTO> reviewDTOs) {
        this.reviewDTOs = reviewDTOs;
    }

}

