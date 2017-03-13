package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@XmlRootElement
public class CiudadDTO implements Serializable
{
	private String nombre;
        private Long id;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public CiudadDTO()
        {
            
	}
        
        public CiudadDTO(CiudadEntity entity)
        {
            if(entity != null)
            {
                this.nombre = entity.getName();
                this.id = entity.getId();
            }
        }
        
        public CiudadEntity toEntity()
        {
            CiudadEntity entity = new CiudadEntity();
            entity.setName(this.nombre);
            entity.setId(this.getId());
            return entity;
        }
        
        public String getNombre()
        {
            return this.nombre;
        }
        
        public void setNombre(String pNombre)
        {
            this.nombre = pNombre;
        }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}