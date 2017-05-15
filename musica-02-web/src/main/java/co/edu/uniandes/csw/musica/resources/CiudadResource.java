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

import co.edu.uniandes.csw.musica.dtos.CiudadDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.CiudadLogic;
import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * URI: ciudades/
 */
@Path("/ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadResource {

    @Inject
    private CiudadLogic ciudadLogic;
    @Context
    private HttpServletResponse http;

    /**
     * Convierte una lista de CiudadEntity a una lista de CiudadDetailDTO.
     *
     * @param entityList Lista de CiudadEntity a convertir.
     * @return Lista de CiudadDetailDTO convertida.
     */
    private List<CiudadDetailDTO> listEntity2DTO(List<CiudadEntity> entityList) {
        List<CiudadDetailDTO> list = new ArrayList<>();
        for (CiudadEntity entityCity : entityList) {
            list.add(new CiudadDetailDTO(entityCity));
        }
        return list;
    }

    @GET
    public List<CiudadDetailDTO> getCities() {
        return listEntity2DTO(ciudadLogic.getCities());
    }

    @GET
    @Path("{Id: \\d+}")
    public CiudadDetailDTO getCity(@PathParam("Id") Long id) {
        CiudadEntity buscada = ciudadLogic.getCity(id);
        if (buscada == null) {
            throw new WebApplicationException("La ciudad con ese id no existe", 404);
        } else {
            return new CiudadDetailDTO(buscada);
        }
    }

    @POST
    public CiudadDetailDTO createCity(CiudadDetailDTO ciudadDto) throws BusinessLogicException {
        return new CiudadDetailDTO(ciudadLogic.createCity(ciudadDto.toEntity()));
    }

    @PUT
    @Path("name")
    public CiudadDetailDTO updateCity(@PathParam("name") String name, CiudadDetailDTO ciudadDto)
    { 
        CiudadDetailDTO ciudad = getCity(ciudadDto.getId());
        if (ciudad != null) 
        {
            CiudadEntity entity = ciudadDto.toEntity();
            entity.setName(name);
            return new CiudadDetailDTO(ciudadLogic.updateCity(entity));
        }
        else
        {
            throw new WebApplicationException("La ciudad con id <" + ciudadDto.getId() + "> y nombre <" + ciudadDto.getNombre() + "> no existe.", Response.Status.CONFLICT);
        }
    }

    @DELETE
    @Path("{Id: \\d+}")
    public void deleteCity(@PathParam("Id") Long id) 
    {
        CiudadDetailDTO ciudad = getCity(id);
        if (ciudad != null) 
        {
           ciudadLogic.deleteCity(id);
        }
        else
        {
            throw new WebApplicationException("La ciudad con id <" + id + "> no existe.", Response.Status.CONFLICT);
        }
    }

}
