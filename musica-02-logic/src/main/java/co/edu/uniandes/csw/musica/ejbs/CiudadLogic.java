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
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CiudadLogic 
{
    @Inject private CiudadPersistence persistence;
    
    /*
     * Obtiene el conjunto de los registros de ciudades
     * @return conjunto de objetos de tipo CiudadEntity
     */
    public List<CiudadEntity> getCities()
    {
        return persistence.finAll();
    }
    
    public CiudadEntity getCity(Long id)
    {
        return persistence.find(id);
    }

    public CiudadEntity createCity(CiudadEntity ciudadEntity) throws BusinessLogicException 
    {

            persistence.create(ciudadEntity);  
            return ciudadEntity;
    }

    public CiudadEntity updateCity(CiudadEntity ciudadEntity) 
    {
        return persistence.update(ciudadEntity);
    }

    public void deleteCity(Long id) 
    {
        persistence.delete(id);
    }
    
}