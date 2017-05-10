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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class CiudadEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @PodamExclude
    @OneToMany(mappedBy = "ciudadEntity")
    private List<FestivalEntity> festivales = new ArrayList<>();
    
    @PodamExclude
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
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long newId)
    {
        this.id = newId;
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