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
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author a.echeverrir
 */
@Entity
public class VenueEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private Integer capacidadMax;
    private String direccion;
    private String imagen;
    
    @ManyToOne 
    private CiudadEntity ciudadEntity;
    @ManyToOne 
    private FestivalEntity festivalEntity;
    @OneToMany(mappedBy = "venueEntity")
    private List<FuncionEntity> funcionEntity;
    
    
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null) 
        {
            return this.getId().equals(((FuncionEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
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
     * @return the Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    /**
     * @return the ciudadEntity
     */
   public CiudadEntity getCiudadEntity() {
       return ciudadEntity;
    }

    /**
     * @param ciudadEntity the ciudadEntity to set
     */
    public void setCiudadEntity(CiudadEntity ciudadEntity) {
        this.ciudadEntity = ciudadEntity;
    }

    /**
     * @return the festivalEntity
     */
    public FestivalEntity getFestivalEntity() {
        return festivalEntity;
    }

    /**
     * @param festivalEntity the festivalEntity to set
     */
    public void setFestivalEntity(FestivalEntity festivalEntity) {
        this.festivalEntity = festivalEntity;
    }

    /**
     * @return the funcionEntity
     */
    public List<FuncionEntity> getFuncionEntity() {
        return funcionEntity;
    }

    /**
     * @param funcionEntity the funcionEntity to set
     */
    public void setFuncionEntity(List<FuncionEntity> funcionEntity) {
        this.funcionEntity = funcionEntity;
    }

    public String getImagen() 
    {
        return imagen;
    }
    
    public void setImagen(String pImagen)
    {
        this.imagen = pImagen;  
    }      


  
   

  
    
    
    
}
