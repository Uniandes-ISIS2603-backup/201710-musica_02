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
package co.edu.uniandes.csw.musica.entities;

/**
 *
 * @author af.olivares10
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;


@Entity
public class FestivalEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    //@PodamStrategyValue(DateStrategy.class)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    //@PodamStrategyValue(DateStrategy.class)
    private Date fechaFin;
    @ManyToOne
    @PodamExclude
    private CiudadEntity ciudadEntity;
    @OneToMany(mappedBy = "festivalEntity")
    @PodamExclude
    private List <VenueEntity> venuesEntities = new ArrayList <VenueEntity>();
    @OneToMany(mappedBy = "festivalEntity")
    @PodamExclude
    private List <FuncionEntity> funcionesEntities = new ArrayList <FuncionEntity> (); 
    private String imagen;
    private String genero;
   
    
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the ciudadEnity
     */
    public CiudadEntity getCiudadEntity() {
       return ciudadEntity;
    }

    /**
     * @param ciudadEnity the ciudadEnity to set
     */
    public void setCiudadEntity(CiudadEntity ciudadEnity) {
       this.ciudadEntity = ciudadEnity;
    }

    /**
     * @return the funcionesEntities
     */
    public List <FuncionEntity> getFuncionesEntities() {
        return funcionesEntities;
    }

    /**
     * @param funcionesEntities the funcionesEntities to set
     */
    public void setFuncionesEntities(List <FuncionEntity> funcionesEntities) {
        this.funcionesEntities = funcionesEntities;
    }

    /**
     * @return the venuesEnities
     */
    public List <VenueEntity> getVenuesEntities() {
        return venuesEntities;
    }

    /**
     * @param venuesEnities the venuesEnities to set
     */
    public void setVenuesEntities(List <VenueEntity> venuesEnities) {
        this.venuesEntities = venuesEnities;
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