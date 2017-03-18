/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.FestivalDTO;
import co.edu.uniandes.csw.musica.dtos.FestivalDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.FestivalLogic;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
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
 * @author af.olivares10
 */
@Path("/festivales")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

//TODO los métodos que reciben el id del festival deben verificar que exista y si no, disparar un WebApplication Exception 404
public class FestivalResource {

    @Inject
    private FestivalLogic logic;
    @Context
    HttpServlet http;

    private List<FestivalDetailDTO> listEntity2DTODETAIL(List<FestivalEntity> entityList) {
        List<FestivalDetailDTO> listDTO = new ArrayList<>();
        for (FestivalEntity c : entityList) {
            FestivalDetailDTO est = new FestivalDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }
    
    @GET
    public  List<FestivalDetailDTO> getFestivales()
    {
        return listEntity2DTODETAIL(logic.getFestivales());
    }
    
    @GET
    @Path("{id: \\d+}")
    public FestivalDetailDTO getFestival (@PathParam("id") Long id) throws BusinessLogicException
    {
        return new FestivalDetailDTO(logic.getFestival(id));
    }
    @POST
    public FestivalDetailDTO createFestival (FestivalDetailDTO festival) 
    {
        return new FestivalDetailDTO(logic.createFestival(festival.toEntity()));
    }
    @PUT
    public FestivalDetailDTO updateFestival (FestivalDetailDTO festival)
    {
        return new FestivalDetailDTO(logic.updateFestival(festival.toEntity()));
    }

}
