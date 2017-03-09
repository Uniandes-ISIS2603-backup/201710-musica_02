/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.FuncionDTO;
import co.edu.uniandes.csw.musica.ejbs.FuncionLogic;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

    private List<FuncionDTO> listEntity2DTO(List<FuncionEntity> entityList) {
        List<FuncionDTO> listDTO = new ArrayList<>();
        for (FuncionEntity c : entityList) {
            FuncionDTO est = new FuncionDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<FuncionDTO> getEstudiantes() {

        return listEntity2DTO(logic.getFunciones());
    }

    @POST
    public FuncionDTO createEstudiante(FuncionDTO dto) throws BusinessLogicException {
        FuncionEntity estu = logic.createFuncion(dto.toEntity());
        return new FuncionDTO(estu);
    }

}
