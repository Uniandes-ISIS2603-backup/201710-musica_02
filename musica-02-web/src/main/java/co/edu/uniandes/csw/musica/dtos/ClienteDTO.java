package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class ClienteDTO implements Serializable {

    private String nombre;
    private Integer abono;
    private String documento;
    private String tipoDocumento;
    private Boolean registradoBlog;
    private String usuario;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated
     */
    public ClienteDTO() {
    }

    public ClienteDTO(ClienteEntity entity) {
        if (entity != null) {
            this.nombre = entity.getNombre();
            this.abono = entity.getAbono();
            this.documento = entity.getDocumento();
            this.tipoDocumento = entity.getTipoDocumento();
            this.registradoBlog = entity.isRegistradoBlog();
            this.usuario = entity.getUsuario();
        }
    }

    public ClienteEntity toEntity() {
        ClienteEntity e = new ClienteEntity();
        e.setAbono(getAbono());
        e.setDocumento(getDocumento());
        e.setNombre(getNombre());
        e.setRegistradoBlog(isRegistradoBlog());
        e.setTipoDocumento(getTipoDocumento());
        e.setUsuario(getUsuario());
        return e;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the abono
     */
    public Integer getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(int abono) {
        this.abono = abono;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the registradoBlog
     */
    public Boolean isRegistradoBlog() {
        return registradoBlog;
    }

    /**
     * @param registradoBlog the registradoBlog to set
     */
    public void setRegistradoBlog(boolean registradoBlog) {
        this.registradoBlog = registradoBlog;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
