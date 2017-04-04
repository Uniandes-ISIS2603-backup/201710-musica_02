package co.edu.uniandes.csw.musica.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import java.io.Serializable;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class ArtistaDTO implements Serializable
{
    
        private Long id;
    
	private String nombre;

	private String trayectoria;
        
        private String imagen;

	public ArtistaDTO()
        {
            
	}
        
        public ArtistaDTO(ArtistaEntity entity)
        {
            if(entity != null)
            {
                id = entity.getId();
                nombre = entity.getNombre();
                trayectoria = entity.getTrayectoria();
            }
        }
        
       public ArtistaEntity toEntity()
       {
           ArtistaEntity entity = new ArtistaEntity();
           
           //sets
           entity.setId(this.getId());
           entity.setNombre(this.getNombre());
           entity.setTrayectoria(this.getTrayectoria());
           
           return entity;
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
     * @return the trayectoria
     */
    public String getTrayectoria() {
        return trayectoria;
    }

    /**
     * @param trayectoria the trayectoria to set
     */
    public void setTrayectoria(String trayectoria) {
        this.trayectoria = trayectoria;
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

