package co.edu.uniandes.csw.musica.dtos;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
public class FestivalDTO {

    private String nombre;

    private Date fechaInicio;

    private Date fechaFin;

    private long id;

    public FestivalDTO() {
        super();
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
