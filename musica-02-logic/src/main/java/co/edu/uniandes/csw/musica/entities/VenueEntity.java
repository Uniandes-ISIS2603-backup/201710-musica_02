/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author a.echeverrir
 */
@Entity
public class VenueEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private Integer capacidadMax;
    private String direccion;
    
    @ManyToOne
    private CiudadEntity ciudadEntity;
    @ManyToOne
    private FestivalEntity festivalEntity;
    @OneToOne
    private FuncionEntity funcionEntity;
    
    
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null) 
        {
            return this.getId().equals(((FuncionEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the capacidadMax
     */
    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * @param capacidadMax the capacidadMax to set
     */
    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    /**
     * @return the ciudadEntity
     */
   public CiudadEntity getCiudadEntity() {
       return ciudadEntity;
    }

    /**
     * @param ciudadEntity the ciudadEntity to set
     */
    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

    /**
     * @return the festivalEntity
     */
    public FestivalEntity getFestivalEntity() {
        return festivalEntity;
    }

    /**
     * @param festivalEntity the festivalEntity to set
     */
    public void setFestivalEntity(FestivalEntity festivalEntity) {
        this.festivalEntity = festivalEntity;
    }

    /**
     * @return the funcionEntity
     */
    public FuncionEntity getFuncionEntity() {
        return funcionEntity;
    }

    /**
     * @param funcionEntity the funcionEntity to set
     */
    public void setFuncionEntity(FuncionEntity funcionEntity) {
        this.funcionEntity = funcionEntity;
    }
    
    
    
}
