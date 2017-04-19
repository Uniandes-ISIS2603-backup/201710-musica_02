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
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlRootElement
public class FuncionDTO implements Serializable
{

	private Date fecha;

	private Integer duracion;

	private Boolean esPaga;

	private Integer entradasDisponibles;

	private Long id;
        
        private String imagen;
        
      
	public FuncionDTO(){
            
	}
        public FuncionDTO(FuncionEntity enti)
        {
            if(enti != null)
            {
                id = enti.getId();
                fecha = enti.getFecha();
                entradasDisponibles = enti.getEntradasDisponibles();
                esPaga = enti.getEsPaga();
                duracion = enti.getDuracion();
                imagen = enti.getImagen();
            }
        }
       public FuncionEntity toEntity()
       {
           FuncionEntity entity = new FuncionEntity();
           entity.setId(this.getId());
           entity.setDuracion(this.getDuracion());
           entity.setEsPaga(this.getEsPaga());
           entity.setEntradasDisponibles(this.getEntradasDisponibles());
           entity.setFecha(this.getFecha());
           entity.setImagen(this.getImagen());
            return entity;
       }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    /**
     * @return the esPaga
     */
    public Boolean getEsPaga() {
        return esPaga;
    }

    /**
     * @param esPaga the esPaga to set
     */
    public void setEsPaga(Boolean esPaga) {
        this.esPaga = esPaga;
    }

    /**
     * @return the entradasDisponibles
     */
    public Integer getEntradasDisponibles() {
        return entradasDisponibles;
    }

    /**
     * @param entradasDisponibles the entradasDisponibles to set
     */
    public void setEntradasDisponibles(Integer entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
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

