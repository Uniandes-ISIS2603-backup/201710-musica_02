/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class DiscoDTO implements Serializable
{
    
    
        private String nombre;

	private Long id;
        
        private List<DiscoEntity.Cancion> canciones = new ArrayList<DiscoEntity.Cancion>();
        
      
	public DiscoDTO(){
            
	}
        public DiscoDTO(DiscoEntity entity)
        {
            if(entity != null)
            {
                id = entity.getId();
                nombre = entity.getNombre();
                canciones = entity.getCanciones();
            }
        }
       public DiscoEntity toEntity()
       {
           DiscoEntity entity = new DiscoEntity();
           
           //sets
           entity.setId(this.getId());
           entity.setNombre(this.getNombre());
           entity.setCanciones(this.getCanciones());
           
            return entity;
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
     * @return the canciones
     */
    public List<DiscoEntity.Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<DiscoEntity.Cancion> canciones) {
        this.canciones = canciones;
    }
    
    
}
