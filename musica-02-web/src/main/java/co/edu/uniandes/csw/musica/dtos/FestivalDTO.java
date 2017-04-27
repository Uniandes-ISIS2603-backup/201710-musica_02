/* 
 * The MIT License
 *
 * Copyright 2017 Mighty Fingers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
    
   private String genero;

    public FestivalDTO() {

    }

    public FestivalDTO(FestivalEntity entity) {
        if (entity != null) {
            this.fechaInicio = entity.getFechaInicio();
            this.fechaFin = entity.getFechaFin();
            this.nombre = entity.getNombre();
            this.id = entity.getId();
            this.imagen = entity.getImagen();
            this.genero = entity.getGenero();
        }
    }

    public FestivalEntity toEntity() {
        FestivalEntity fe = new FestivalEntity();
        fe.setFechaFin(fechaFin);
        fe.setFechaInicio(fechaFin);
        fe.setId(id);
        fe.setNombre(nombre);
        fe.setImagen(imagen);
        fe.setGenero(genero);
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

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
