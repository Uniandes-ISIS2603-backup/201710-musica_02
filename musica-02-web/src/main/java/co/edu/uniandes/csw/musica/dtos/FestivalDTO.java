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

    public FestivalDTO() {

    }

    public FestivalDTO(FestivalEntity entity) {
        if (entity != null) {
            this.fechaInicio = entity.getFechaInicio();
            this.fechaFin = entity.getFechaFin();
            this.nombre = entity.getNombre();
            this.id = entity.getId();
        }
    }

    public FestivalEntity toEntity() {
        FestivalEntity fe = new FestivalEntity();
        fe.setFechaFin(fechaFin);
        fe.setFechaInicio(fechaInicio);
        fe.setId(id);
        fe.setNombre(nombre);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
