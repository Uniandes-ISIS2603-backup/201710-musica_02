package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
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
	
	
	private ArrayList<EntradaDTO> entradas;
        private ClienteDTO dto;
        

	public ClienteDetailDTO(){
		super();
	}
        
        public ClienteDetailDTO(ClienteEntity entity) {
            super(entity);
            dto = new ClienteDTO();
            entradas = new ArrayList<EntradaDTO>();
            for(EntradaEntity entrada : entity.getEntradas()){
                entradas.add(new EntradaDTO(entrada));
            }
        }
        
        @Override
        public ClienteEntity toEntity() {
            return super.toEntity();
        }

}

