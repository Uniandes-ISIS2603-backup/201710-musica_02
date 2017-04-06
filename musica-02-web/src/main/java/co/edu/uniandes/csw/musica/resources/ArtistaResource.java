/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.ArtistaDTO;
import co.edu.uniandes.csw.musica.dtos.ArtistaDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.ArtistaLogic;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author a.echeverrir
 */
@Path("/artistas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistaResource 
{
    @Inject
    private ArtistaLogic logic;
    @Context
    HttpServlet http;

    private List<ArtistaDetailDTO> listEntity2DTO(List<ArtistaEntity> entityList) {
        List<ArtistaDetailDTO> listDTO = new ArrayList<>();
        for (ArtistaEntity c : entityList) {
            ArtistaDetailDTO est = new ArtistaDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<ArtistaDetailDTO> getArtistas() {
        return listEntity2DTO(logic.getArtistas());
          
    }

    @POST
    public ArtistaDetailDTO createArtista(ArtistaDTO dto) throws BusinessLogicException 
    {
        ArtistaEntity artista = logic.createArtista(dto.toEntity());
        return new ArtistaDetailDTO(artista);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ArtistaDetailDTO updateArtista(@PathParam("id") Long id, ArtistaDTO dto)
    {
        ArtistaEntity entity = dto.toEntity();
        entity.setId(id);
        return new ArtistaDetailDTO(logic.updateArtista(entity)); 
    }
    @GET 
    @Path("{id: \\d+}")
    public ArtistaDetailDTO getArtista(@PathParam("id") Long id) throws BusinessLogicException
    {
        return new ArtistaDetailDTO(logic.getArtista(id));
    }
 
    // TODO implementar get /artistas/:id/funciones funciones en las que actuará el artista

}
