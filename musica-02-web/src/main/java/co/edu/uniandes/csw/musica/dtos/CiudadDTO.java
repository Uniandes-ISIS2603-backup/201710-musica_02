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