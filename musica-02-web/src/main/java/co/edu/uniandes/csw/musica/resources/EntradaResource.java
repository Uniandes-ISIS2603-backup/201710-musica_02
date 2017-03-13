/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.EntradaDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.EntradaLogic;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


/**
 *
 * @author p.salazar12
 */

@Path("/entradas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntradaResource {
   
    @Inject
    private EntradaLogic logic;
    @Context
    HttpServlet http;
    
    private List<EntradaDetailDTO> listEntity2DTO(List<EntradaEntity> entityList) {
        List<EntradaDetailDTO> listDTO = new ArrayList<>();
        for (EntradaEntity c : entityList) {
            EntradaDetailDTO est = new EntradaDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }
    
    @GET
    @Path("{usuario}")
    public List<EntradaDetailDTO> getEntradas(@PathParam("usuario") String id) 
    {
        return listEntity2DTO(logic.getEntradaParam(id));
    } 
    
    
}
