/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.DiscoDTO;
import co.edu.uniandes.csw.musica.dtos.DiscoDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.DiscoLogic;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
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
@Path("/artistas/{idArtista}/discos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiscoResource 
{
    @Inject
    private DiscoLogic logic;
    @Context
    HttpServlet http;
    
    private List<DiscoDetailDTO> listEntity2DTO(List<DiscoEntity> entityList) {
        List<DiscoDetailDTO> listDTO = new ArrayList<>();
        for (DiscoEntity c : entityList) {
            DiscoDetailDTO est = new DiscoDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<DiscoDetailDTO> getDiscos(@PathParam("idArtista") Long id) {
        
        return listEntity2DTO(logic.getDiscos(id));
    }

    @POST
    public DiscoDetailDTO createDisco(DiscoDTO dto) throws BusinessLogicException {
        DiscoEntity disco = logic.createDisco(dto.toEntity());
        return new DiscoDetailDTO(disco);
    }
    @GET 
    @Path("{id}")
    public DiscoDetailDTO getDisco(@PathParam("id") Long id) throws BusinessLogicException
    {
        return new DiscoDetailDTO(logic.getDisco(id));
    }
    
}
