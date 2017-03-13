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

/**
 *
 * @author ca.anzola
 */
@Entity
public class CiudadEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this.getName() != null) 
        {
            return this.getName().equals(((CiudadEntity) obj).getName());
        }
        
        return false;
    }
    
    @Override
    public int hashCode() 
    {
        if (this.getName() != null) 
        {
            return this.getName().hashCode();
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
}