package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class FestivalDTO implements Serializable{

    private String nombre;

    private Date fechaInicio;

    private Date fechaFin;

    private Long id;
    
    private String imagen;

    public FestivalDTO() {

    }

    public FestivalDTO(FestivalEntity entity) {
        if (entity != null) {
            this.fechaInicio = entity.getFechaInicio();
            this.fechaFin = entity.getFechaFin();
            this.nombre = entity.getNombre();
            this.id = entity.getId();
            this.imagen = entity.getImagen();
        }
    }

    public FestivalEntity toEntity() {
        FestivalEntity fe = new FestivalEntity();
        fe.setFechaFin(getFechaFin());
        fe.setFechaInicio(getFechaInicio());
        fe.setId(getId());
        fe.setNombre(getNombre());
        fe.setImagen(getImagen());
        return fe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
