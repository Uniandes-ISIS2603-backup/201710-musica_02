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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author a.echeverrir
 */
@Entity
public class ArtistaEntity implements Serializable
{

    //CONSTANTES DE GENERO
    public final static String ROCK = "Rock";
    public final static String SALSA = "Salsa";
    public final static String RAGGAE = "Raggae";
    public final static String RAGGAETON = "Raggaeton";
    public final static String HIPHOP = "HipHop";
    public final static String ELECTRONICA = "Electronica";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombre;
    private String trayectoria;
    
    //viene de las constantes
    private String Genero;
    
    private List<DiscoEntity> discos = new ArrayList<DiscoEntity>();
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artistas")
    private List<FuncionEntity> funciones = new ArrayList<FuncionEntity>();

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null) 
        {
            return this.getId().equals(((ArtistaEntity) obj).getId());
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
     * @return the trayectoria
     */
    public String getTrayectoria() {
        return trayectoria;
    }

    /**
     * @param trayectoria the trayectoria to set
     */
    public void setTrayectoria(String trayectoria) {
        this.trayectoria = trayectoria;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the discos
     */
    public List<DiscoEntity> getDiscos() {
        return discos;
    }

    /**
     * @param discos the discos to set
     */
    public void setDiscos(List<DiscoEntity> discos) {
        this.discos = discos;
    }

    /**
     * @return the funciones
     */
    public List<FuncionEntity> getFunciones() {
        return funciones;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(List<FuncionEntity> funciones) {
        this.funciones = funciones;
    }

    
    
}
