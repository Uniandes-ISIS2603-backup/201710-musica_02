/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jd.gonzaleza
 */
@XmlRootElement
public class ReviewDTO implements Serializable{

    private Long id;
    private Date fecha;
    private String descripcion;
    private Integer calificacion;

    public ReviewDTO() {

    }
    public ReviewDTO(ReviewEntity entity)
    {
        if(entity != null)
        {
            id = entity.getId();
            fecha = entity.getFecha();
            descripcion = entity.getDescripcion();
            calificacion = entity.getCalificacion();
        }
    }
    public ReviewEntity toEntity()
    {
         ReviewEntity enti = new ReviewEntity();
         enti.setId(id);
         enti.setFecha(fecha);
         enti.setCalificacion(calificacion);
         enti.setDescripcion(descripcion);
         return enti;
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

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
   

}
