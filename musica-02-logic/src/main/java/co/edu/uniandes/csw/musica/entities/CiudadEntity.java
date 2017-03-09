/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ca.anzola
 */
@Entity
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}