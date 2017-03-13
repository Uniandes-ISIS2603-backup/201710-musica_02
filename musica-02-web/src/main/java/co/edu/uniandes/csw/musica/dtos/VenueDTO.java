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
	
	private Integer capacidadMax;
	
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
           entity.setId(this.getId());
           entity.setNombre(this.getNombre());
           entity.setTipo(this.getTipo());
           entity.setCapacidadMax(this.getCapacidadMax());
           entity.setDireccion(this.getDireccion());
           
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}

