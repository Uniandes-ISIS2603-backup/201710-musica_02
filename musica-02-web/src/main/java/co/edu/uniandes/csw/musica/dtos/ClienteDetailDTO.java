package co.edu.uniandes.csw.musica.dtos;
import java.util.HashSet;
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<EntradaDTO> entradas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ClienteDetailDTO(){
		super();
	}

}

