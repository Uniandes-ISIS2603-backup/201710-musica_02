/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author p.salazar12
 */
@Entity
public class ClienteEntity implements Serializable{
    
    @Id
    private String Usuario;
    private Integer abono;
    private String documento;
    private String tipoDocumento;
    private Boolean registradoBlog;
    private String nombre;
    @OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntradaEntity> entradas;

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
        this.abono = abono;
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
        return registradoBlog;
    }

    public void setRegistradoBlog(boolean registradoBlog) {
        this.registradoBlog = registradoBlog;
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

    public void setEntradas(ArrayList<EntradaEntity> entradas) {
        this.entradas = entradas;
    }
  
    
}
