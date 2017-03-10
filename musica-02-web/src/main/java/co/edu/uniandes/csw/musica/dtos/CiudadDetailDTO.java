package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@XmlRootElement
public class CiudadDetailDTO extends CiudadDTO
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<FestivalDTO> festival;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public CiudadDetailDTO()
        {
	   super();
	}

        public CiudadDetailDTO(CiudadEntity entity)
        {
	   super(entity);
	}
        
        @Override
        public CiudadEntity toEntity() 
        {
           CiudadEntity entity = super.toEntity();
           return entity;
        }
}