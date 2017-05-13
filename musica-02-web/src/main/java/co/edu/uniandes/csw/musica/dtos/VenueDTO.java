/* 
 * The MIT License
 *
 * Copyright 2017 Mighty Fingers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
        
        private String imagen;
        
        private String mapa;

	
	public VenueDTO()
        {
		
	}
        
        public VenueDTO(VenueEntity entity)
        {
            if(entity != null)
            {
                this.id = entity.getId();
                this.nombre = entity.getNombre();
                this.tipo = entity.getTipo();
                this.capacidadMax = entity.getCapacidadMax();
                this.direccion = entity.getDireccion();
                this.imagen = entity.getImagen();
                this.mapa = entity.getMapa();
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
           entity.setImagen(this.getImagen());
           entity.setMapa(this.getMapa());
           return entity;
       }

    public String getMapa()
    {
        return mapa;
    }
    
    public void setMapa(String newMapa)
    {
        mapa = newMapa;
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
    
    public String getImagen()
    {
        return this.imagen;
    }
    
    public void setImagen(String pImagen) {
        this.imagen = pImagen;
    }

}

