/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.FuncionDTO;
import co.edu.uniandes.csw.musica.dtos.FuncionDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.FuncionLogic;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jd.gonzaleza
 */
@Path("/funciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionResource {

    @Inject
    private FuncionLogic logic;
    @Context
    HttpServlet http;

    private List<FuncionDetailDTO> listEntity2DTO(List<FuncionEntity> entityList) {
        List<FuncionDetailDTO> listDTO = new ArrayList<>();
        for (FuncionEntity c : entityList) {
            FuncionDetailDTO est = new FuncionDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<FuncionDetailDTO> getFunciones() {
        System.out.println("hola");
        return listEntity2DTO(logic.getFunciones());
          
    }

    @POST
    public FuncionDetailDTO createFuncion(FuncionDTO dto) throws BusinessLogicException {
        FuncionEntity fun = logic.createFuncion(dto.toEntity());
        return new FuncionDetailDTO(fun);
    }
    @PUT
   @Path("{id: \\d+}")
    public FuncionDetailDTO updateFuncion(@PathParam("id") Long id, FuncionDTO dto)
    {
        FuncionEntity entity = dto.toEntity();
        entity.setId(id);
        return new FuncionDetailDTO(logic.updateFuncion(entity)); 
    }
    @GET 
    @Path("{id: \\d+}")
    public FuncionDetailDTO getFuncion(@PathParam("id") Long id)
    {
        return new FuncionDetailDTO(logic.getFuncion(id));
    }
    

}
