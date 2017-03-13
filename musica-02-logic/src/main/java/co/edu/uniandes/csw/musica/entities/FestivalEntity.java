/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

/**
 *
 * @author af.olivares10
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class FestivalEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    @ManyToOne
    private CiudadEntity ciudadEnity;
    @OneToMany(mappedBy = "festivalEntity", cascade = CascadeType.PERSIST)
    private ArrayList <VenueEntity> venuesEnities;
    @OneToMany(mappedBy = "festivalEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList <FuncionEntity> funcionesEntities;
    
   
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
    public CiudadEntity getCiudadEnity() {
        return ciudadEnity;
    }

    /**
     * @param ciudadEnity the ciudadEnity to set
     */
    public void setCiudadEnity(CiudadEntity ciudadEnity) {
       this.ciudadEnity = ciudadEnity;
    }

    /**
     * @return the funcionesEntities
     */
    public ArrayList <FuncionEntity> getFuncionesEntities() {
        return funcionesEntities;
    }

    /**
     * @param funcionesEntities the funcionesEntities to set
     */
    public void setFuncionesEntities(ArrayList <FuncionEntity> funcionesEntities) {
        this.funcionesEntities = funcionesEntities;
    }

    /**
     * @return the venuesEnities
     */
    public ArrayList <VenueEntity> getVenuesEnities() {
        return venuesEnities;
    }

    /**
     * @param venuesEnities the venuesEnities to set
     */
    public void setVenuesEnities(ArrayList <VenueEntity> venuesEnities) {
        this.venuesEnities = venuesEnities;
    }

  
    
    
}
