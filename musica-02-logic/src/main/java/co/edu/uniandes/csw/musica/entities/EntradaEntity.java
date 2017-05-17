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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author p.salazar12
 */
@Entity
public class EntradaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer noEntrada;
    private String silla;
    private Double precio;
    private Boolean libre;
    @PodamExclude
    @ManyToOne
    private FuncionEntity funcionEntity;
    @PodamExclude
    @ManyToOne
    private ClienteEntity clienteEntity;
    
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null) {
            return this.getId().equals(((EntradaEntity) obj).getId());
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
     * @return the noEntrada
     */
    public Integer getNoEntrada() {
        return noEntrada;
    }

    /**
     * @param noEntrada the noEntrada to set
     */
    public void setNoEntrada(Integer noEntrada) {
        this.noEntrada = noEntrada;
    }

    /**
     * @return the silla
     */
    public String getSilla() {
        return silla;
    }

    /**
     * @param silla the silla to set
     */
    public void setSilla(String silla) {
        this.silla = silla;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the libre
     */
    public Boolean getLibre() {
        return libre;
    }

    /**
     * @param libre the libre to set
     */
    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    /**
     * @return the funcionEntity
     */
   // public FuncionEntity getFuncionEntity() {
     //   return funcionEntity;
 //   }

    /**
     * @param funcionEntity the funcionEntity to set
     */
   // public void setFuncionEntity(FuncionEntity funcionEntity) {
     //   this.funcionEntity = funcionEntity;
   // }

    /**
     * @return the clienteEntity
     */
    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    /**
     * @param clienteEntity the clienteEntity to set
     */
    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    /**
     * @return the funcionEntity
     */
    public FuncionEntity getFuncionEntity() {
        return funcionEntity;
    }

    /**
     * @param funcionEntity the funcionEntity to set
     */
    public void setFuncionEntity(FuncionEntity funcionEntity) {
        this.funcionEntity = funcionEntity;
    }

}
