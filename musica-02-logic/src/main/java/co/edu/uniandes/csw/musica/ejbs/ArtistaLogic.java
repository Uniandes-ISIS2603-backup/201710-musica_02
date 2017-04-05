/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
