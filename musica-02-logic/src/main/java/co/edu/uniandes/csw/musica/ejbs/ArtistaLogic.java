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

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.persistence.ArtistaPersistence;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.echeverrir
 */
@Stateless

public class ArtistaLogic {

    @Inject
    private ArtistaPersistence persistence;
    @Inject
    private FuncionPersistence persistenceFuncion;

    public List<ArtistaEntity> getArtistas() {
        return persistence.findAll();
    }

    public ArtistaEntity getArtista(Long id) throws BusinessLogicException {
        ArtistaEntity entity = persistence.find(id);
        if (entity != null) {
            return persistence.find(id);
        } else {
            throw new BusinessLogicException("No se ha encontrado un artista con dicho Id");
        }
    }

    public ArtistaEntity createArtista(ArtistaEntity entity) {
        return persistence.create(entity);
    }

    public ArtistaEntity updateArtista(ArtistaEntity entity) {
        return persistence.update(entity);
    }

    public void deleteArtista(Long id) {
        persistence.delete(id);
    }

    public List<ArtistaEntity> getArtistasPorFestival(Long idFest) {
        List<FuncionEntity> funciones = persistenceFuncion.findByFestival(idFest);
        List<ArtistaEntity> artistas = new ArrayList<>();
        if(funciones!=null)
        for (FuncionEntity funcion : funciones) {
            if (funcion != null) {
                List<ArtistaEntity> actuales = persistence.findByFuncion(funcion.getId());
                if(actuales!=null)
                for (ArtistaEntity artista : actuales) {
                    if (artista != null) {
                        artistas.add(artista);    
                    }
                }
            }
        }
        return artistas;
    }
     public List<ArtistaEntity> getArtistasPorFuncion(Long idFun){
        return persistence.findByFuncion(idFun);
    }
}
