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

	public ArtistaDTO(){
		super();
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
           entity.setId(this.id);
           entity.setNombre(this.nombre);
           entity.setTrayectoria(this.trayectoria);
           
           return entity;
       }

}

