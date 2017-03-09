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
            }
        }
        
        public CiudadEntity toEntity()
        {
            CiudadEntity entity = new CiudadEntity();
            entity.setName(this.nombre);
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

}