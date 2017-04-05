/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import java.io.Serializable;
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
    
    private String imagen;
      
    public DiscoDTO(){
            
    }
        public DiscoDTO(DiscoEntity entity)
        {
            if(entity != null)
            {
                id = entity.getId();
                nombre = entity.getNombre();
                imagen = entity.getImagen();
            }
        }
       public DiscoEntity toEntity()
       {
           DiscoEntity entity = new DiscoEntity();
           
           //sets
           entity.setId(this.getId());
           entity.setNombre(this.getNombre());
           entity.setImagen(this.getImagen());
           
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
