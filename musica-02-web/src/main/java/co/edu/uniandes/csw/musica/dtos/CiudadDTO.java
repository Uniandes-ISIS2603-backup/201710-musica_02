/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CiudadDTO implements Serializable
{
	private String nombre;
        private Long id;

	public CiudadDTO(){
	}
        
        /*
         * Crea un objeto CiudadDTO a partir de un objeto CiudadEntity que no sea null
         * @params entity CiudadEntity a partir de la cual se va a crear la CiudadDTO
         */
        public CiudadDTO(CiudadEntity entity)
        {
            if(entity != null)
            {
                this.nombre = entity.getName();
                this.id = entity.getId();
            }
        }
        
        /*
         * Convierte un objeto CiudadDTO a un CiudadEntity
         * @return nuevo objeto de tipo CiudadEntity 
         */
        public CiudadEntity toEntity()
        {
            CiudadEntity entity = new CiudadEntity();
            entity.setName(this.nombre);
            entity.setId(this.id);
            return entity;
        }
        
        public String getNombre()
        {
            return this.nombre;
        }
        
        public void setNombre(String pNombre)
        {
            this.nombre = pNombre;
        }

        public Long getId()
        {
            return this.id;
        }
        
        public void setId(Long newId)
        {
            this.id = newId;
        }
}