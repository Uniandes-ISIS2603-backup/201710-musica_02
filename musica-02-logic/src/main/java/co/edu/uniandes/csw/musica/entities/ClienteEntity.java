/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
    private int abono;
    private String documento;
    private String tipoDocumento;
    private boolean registradoBlog;
    private String nombre;
      @OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList <EntradaEntity> entradas;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getAbono() {
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

    public boolean isRegistradoBlog() {
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

    public ArrayList<EntradaEntity> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<EntradaEntity> entradas) {
        this.entradas = entradas;
    }
  
    
}
