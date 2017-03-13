/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.VenueDTO;
import co.edu.uniandes.csw.musica.dtos.VenueDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.VenueLogic;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
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
@Path("/venues")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VenueResource {

    @Inject
    private VenueLogic logic;
    @Context
    HttpServlet http;

    private List<VenueDetailDTO> listEntity2DTO(List<VenueEntity> entityList) {
        List<VenueDetailDTO> listDTO = new ArrayList<>();
        for (VenueEntity c : entityList) {
            VenueDetailDTO est = new VenueDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<VenueDetailDTO> getVenues() {
        System.out.println("hola");
        return listEntity2DTO(logic.getVenues());
          
    }

    @POST
    public VenueDetailDTO createVenue(VenueDTO dto) throws BusinessLogicException {        
        VenueEntity venue = logic.createVenue(dto.toEntity());
        logic.agregarVenueFuncion(dto.toEntity().getId(), dto.toEntity().getFuncionEntity().getId());
        return new VenueDetailDTO(venue);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public VenueDetailDTO updateVenue(@PathParam("id") Long id, VenueDTO dto)
    {
        VenueEntity entity = dto.toEntity();
        entity.setId(id);
        return new VenueDetailDTO(logic.updateVenue(entity)); 
    }
    @GET 
    @Path("{id: \\d+}")
    public VenueDetailDTO getVenue(@PathParam("id") Long id)
    {
        return new VenueDetailDTO(logic.getVenue(id));
    }
    
}
