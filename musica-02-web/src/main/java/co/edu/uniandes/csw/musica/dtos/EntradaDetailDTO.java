package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class EntradaDetailDTO extends EntradaDTO {

    public FuncionDTO funcion;
    public ClienteDTO cliente;

    public EntradaDetailDTO() {
        super();
    }

    public EntradaDetailDTO(EntradaEntity entity) {
        super(entity);
        if (entity != null) {
            funcion = new FuncionDTO();
            cliente = new ClienteDTO();
        }
    }

    @Override
    public EntradaEntity toEntity() {
        return super.toEntity();
    }

}
