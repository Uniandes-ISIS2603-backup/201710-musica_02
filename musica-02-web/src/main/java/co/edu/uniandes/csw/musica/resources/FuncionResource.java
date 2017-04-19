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
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.FuncionDTO;
import co.edu.uniandes.csw.musica.dtos.FuncionDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.FestivalLogic;
import co.edu.uniandes.csw.musica.ejbs.FuncionLogic;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jd.gonzaleza
 */
@Path("/funciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//TODO los métodos que reciben el id de la función deben verificar que exista y si no, disparar un WebApplication Exception 404

public class FuncionResource {

    @Inject
    private FuncionLogic logic;
    @Inject
    private FestivalLogic festLogic;
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

    @GET
    @Path("/fechas")
    public List<FuncionDetailDTO> getFuncionesFecha(@QueryParam("fecha") Date fecha) {
        System.out.println(fecha);
        return listEntity2DTO(logic.getFuncionesFecha(fecha));
    }

    @GET
    @Path("/pagas")
    public List<FuncionDetailDTO> getFuncionesPagas(@QueryParam("esPaga") Boolean esPaga) {
        System.out.println(esPaga);
        return listEntity2DTO(logic.getFuncionesEsPaga(esPaga));
    }

    @POST
    public FuncionDetailDTO createFuncion(FuncionDetailDTO dto) throws BusinessLogicException {
        FestivalEntity festival;
        if(dto.getFestivalDTO()!=null){
        festival = festLogic.getFestival(dto.getFestivalDTO().getId());
        }
        else festival=null;
        FuncionEntity fun = null;
        if (festival == null) {
            throw new BusinessLogicException("Debe existir el festival para poder añadir la función");
        } else {
            fun = logic.createFuncion(dto.toEntity());
        }
        return new FuncionDetailDTO(fun);

    }

    @PUT
    @Path("{id: \\d+}")
    public FuncionDetailDTO updateFuncion(@PathParam("id") Long id, FuncionDTO dto) throws BusinessLogicException, Exception {
        FuncionEntity entity = dto.toEntity();
        FuncionEntity funBuscada = logic.getFuncion(id);

        if (funBuscada == null){
            throw new BusinessLogicException("No existe una funcion con este id");
        } else {
            entity.setId(id);
            return new FuncionDetailDTO(logic.updateFuncion(entity));
        }
    }

    @GET
    @Path("{id: \\d+}")
    public FuncionDetailDTO getFuncion(@PathParam("id") Long id) throws Exception {
        FuncionEntity funBuscada = logic.getFuncion(id);
        if (funBuscada == null) {
            throw new BusinessLogicException("No existe una funcion con este id");
        } else {
            return new FuncionDetailDTO(logic.getFuncion(id));
        }
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteFuncion(@PathParam("id") Long id) throws BusinessLogicException, Exception {
        FuncionEntity funBuscada = logic.getFuncion(id);
        if (funBuscada == null) {
            throw new BusinessLogicException("No existe una funcion con este id");
        } else {
            logic.deleteFuncion(id);
        }
    }
}
