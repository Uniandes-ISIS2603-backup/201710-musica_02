/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author a.echeverrir
 */
@Entity
public class DiscoEntity implements Serializable
{
    
    //clase cancion 
    public class Cancion
    {
            private String nombre;
            private Integer duracion;
            
        public Cancion (String nombreC, Integer duracionC)
        {
            nombre = nombreC;
            duracion = duracionC;
        }
            
    
        public String getNombre() 
        {
        return nombre;
        }

        public void setNombre(String nombre) 
        {
        this.nombre = nombre;
        }
        
        public Integer getDuracion() 
        {
        return duracion;
        }

        public void setDuracion(Integer duracion) 
        {
        this.duracion = duracion;
        }
    //termina clase cancion
        
            
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private List<Cancion> canciones = new ArrayList<Cancion>();
    
    @ManyToOne
    private ArtistaEntity artistaEntity;

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
     * @return the canciones
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    /**
     * @return the artistaEntity
     */
    public ArtistaEntity getArtistaEntity() {
        return artistaEntity;
    }

    /**
     * @param artistaEntity the artistaEntity to set
     */
    public void setArtistaEntity(ArtistaEntity artistaEntity) {
        this.artistaEntity = artistaEntity;
    }
    
    
}
