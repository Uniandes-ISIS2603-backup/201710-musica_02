/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CiudadEntity implements Serializable
{
    @Id
    private String name;
    @OneToMany(mappedBy = "ciudadEntity")
    private List<FestivalEntity> festivales = new ArrayList<>();
    
    @OneToMany(mappedBy = "ciudadEntity")
    private List<VenueEntity> venues = new ArrayList<>();

    public String getName() 
    {
        return this.name;
    }

    public void setName(String newName) 
    {
        this.name = newName;
    }
    
    public List<FestivalEntity> getFestivales()
    {
        return festivales;
    }
    
    public void setFestivales(List<FestivalEntity> nuevosFestivales)
    {
        festivales = nuevosFestivales;
    }
    
    public List<VenueEntity> getVenues()
    {
        return venues;
    }
    
    public void setVenues(List<VenueEntity> nuevosVenues)
    {
        venues = nuevosVenues;
    }

    /*
    * Dos ciudades son iguales si su nombre es el mismo
    */
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