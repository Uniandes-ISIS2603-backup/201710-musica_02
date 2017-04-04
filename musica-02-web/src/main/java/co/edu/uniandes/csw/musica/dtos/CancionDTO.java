/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.CancionEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class CancionDTO implements Serializable 
{
    
    private Long id;
    
    private String nombre;
    
    private Integer duracion;   
    
    public CancionDTO(){
        
    }
    
    public CancionDTO(CancionEntity entity)
    {
        if(entity != null)
        {
            id = entity.getId();
            nombre = entity.getNombre();
            duracion = entity.getDuracion();
        }  
    }
    
    public CancionEntity toEntity()
    {
        CancionEntity ent = new CancionEntity();
        
        ent.setId(this.getId());
        ent.setNombre(this.getNombre());
        ent.setDuracion(this.getDuracion());
        
        return ent;
        
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
     * @return the duracion
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
    
    
    
    
    
}
