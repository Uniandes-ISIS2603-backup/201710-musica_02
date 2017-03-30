/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.CancionDetailDTO;
import co.edu.uniandes.csw.musica.dtos.ReviewDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.CancionLogic;
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author a.echeverrir
 */
@Path("/artistas/{idArtista}/discos/{idDisco}/canciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CancionResource 
{
    @Inject
    private CancionLogic logic;
    @Context
    HttpServlet http;
     
    private List<CancionDetailDTO> listEntity2DTO(List<CancionEntity> entityList) 
    {
        List<CancionDetailDTO> listDTO = new ArrayList<>();
        for (CancionEntity c : entityList) {
            CancionDetailDTO est = new CancionDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }
    
    @GET
    public List<CancionDetailDTO> getCanciones(@PathParam("idDisco") Long id) 
    {
        return listEntity2DTO(logic.getCanciones(id));
    } 
    @POST
    public CancionDetailDTO createCancion(CancionDetailDTO dto)
    {
        CancionEntity rev = logic.createCancion(dto.toEntity());
        return new CancionDetailDTO(rev);
    }
    
    
}
