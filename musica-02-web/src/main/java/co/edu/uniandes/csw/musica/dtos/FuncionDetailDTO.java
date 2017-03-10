package co.edu.uniandes.csw.musica.dtos;



import co.edu.uniandes.csw.musica.dtos.FuncionDTO;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
public class FuncionDetailDTO extends FuncionDTO {

    /**
     * @generated
     */
    private List<ReviewDTO> reviewsDTOs;
    private FestivalDTO festivalDTO;
    public FuncionDetailDTO() {
        super();
        
    }

    public FuncionDetailDTO(FuncionEntity entity) {
        super(entity);
        reviewsDTOs = new ArrayList<ReviewDTO>();
        festivalDTO = new FestivalDTO();
        for(ReviewEntity rev : entity.getReviews())
            reviewsDTOs.add(new ReviewDTO(rev));
    }

    @Override
    public FuncionEntity toEntity() {        
        return super.toEntity();
    }
}
