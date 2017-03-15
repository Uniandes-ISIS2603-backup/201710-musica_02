package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class EntradaDetailDTO extends EntradaDTO {

    private FuncionDTO funcion;
    private ClienteDTO cliente;

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
        EntradaEntity e = super.toEntity();
        if(cliente != null) e.setClienteEntity(cliente.toEntity());
        if (funcion != null)e.setFuncionEntity(funcion.toEntity());
        return e;
    }

    /**
     * @return the funcion
     */
    public FuncionDTO getFuncion() {
        return funcion;
    }

    /**
     * @param funcion the funcion to set
     */
    public void setFuncion(FuncionDTO funcion) {
        this.funcion = funcion;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

}
