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
import javax.persistence.OneToMany;


/**
 *
 * @author a.echeverrir
 */
@Entity
public class DiscoEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    
    @ManyToOne
    private ArtistaEntity artistaEntity;
    
    @OneToMany(mappedBy = "discoEntity")
    private List<CancionEntity> canciones = new ArrayList<CancionEntity>();

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

    /**
     * @return the canciones
     */
    public List<CancionEntity> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<CancionEntity> canciones) {
        this.canciones = canciones;
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
