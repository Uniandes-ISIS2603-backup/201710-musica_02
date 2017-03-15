/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private FuncionEntity funcionEntity;
    @ManyToOne
    private ClienteEntity clienteEntity;

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

}
