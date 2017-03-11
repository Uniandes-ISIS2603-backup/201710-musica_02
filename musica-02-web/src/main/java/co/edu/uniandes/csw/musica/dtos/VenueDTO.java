package co.edu.uniandes.csw.musica.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import java.io.Serializable;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class VenueDTO implements Serializable
{
	
    
	private String nombre;
        
        private Long id;
	
	private String tipo;
	
	private int capacidadMax;
	
	private String direccion;

	
	public VenueDTO(){
		
	}
        
        
        public VenueDTO(VenueEntity entity)
        {
            if(entity != null)
            {
                id = entity.getId();
                nombre = entity.getNombre();
                tipo = entity.getTipo();
                capacidadMax = entity.getCapacidadMax();
                direccion = entity.getDireccion();
            }
        }
       public VenueEntity toEntity()
       {
           VenueEntity entity = new VenueEntity();
           
           //sets
           entity.setId(this.id);
           entity.setNombre(this.nombre);
           entity.setTipo(this.tipo);
           entity.setCapacidadMax(this.capacidadMax);
           entity.setDireccion(this.direccion);
           
           return entity;
       }

}

