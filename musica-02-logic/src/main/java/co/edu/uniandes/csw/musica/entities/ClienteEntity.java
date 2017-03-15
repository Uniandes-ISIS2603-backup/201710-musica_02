/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author p.salazar12
 */
@Entity
public class ClienteEntity implements Serializable {

    /**
     * @param abono the abono to set
     */
    public void setAbono(Integer abono) {
        this.abono = abono;
    }

    /**
     * @return the registradoBlog
     */
    public Boolean getRegistradoBlog() {
        return registradoBlog;
    }

    /**
     * @param registradoBlog the registradoBlog to set
     */
    public void setRegistradoBlog(Boolean registradoBlog) {
        this.registradoBlog = registradoBlog;
    }

    @Id
    private String Usuario;
    private Integer abono;
    private String documento;
    private String tipoDocumento;
    private Boolean registradoBlog;
    private String nombre;
    @OneToMany(mappedBy = "clienteEntity")
    private List<EntradaEntity> entradas = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<ReviewEntity> reviews = new ArrayList <> ();

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Integer getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.setAbono((Integer) abono);
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Boolean isRegistradoBlog() {
        return getRegistradoBlog();
    }

    public void setRegistradoBlog(boolean registradoBlog) {
        this.setRegistradoBlog((Boolean) registradoBlog);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EntradaEntity> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(List<EntradaEntity> entradas) {
        this.entradas = entradas;
    }

    /**
     * @return the reviews
     */
    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

}
