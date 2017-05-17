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
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author af.olivares10
 */
@Path("/festivales")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

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
    public List<FestivalDetailDTO> getFestivales() {
        return listEntity2DTODETAIL(logic.getFestivales());
    }

    @GET
    @Path("{id: \\d+}")
    public FestivalDetailDTO getFestival(@PathParam("id") Long id) throws WebApplicationException {
        FestivalEntity fest = logic.getFestival(id);
        if (fest != null) {
            return new FestivalDetailDTO(fest);
        }
        throw new WebApplicationException("No se encontró un festival con ese id", 404);
    }

    @GET
    @Path("genero/{genero}")
    public List<FestivalDetailDTO> getFestivalesPorGenero(@PathParam("genero") Long genero) throws WebApplicationException {
        return listEntity2DTODETAIL(logic.getFestivalesPorGenero(genero));

    }

    @POST
    public FestivalDetailDTO createFestival(FestivalDetailDTO festival) {
        return new FestivalDetailDTO(logic.createFestival(festival.toEntity()));
    }

    @PUT
    public FestivalDetailDTO updateFestival(FestivalDetailDTO festival) {
        return new FestivalDetailDTO(logic.updateFestival(festival.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public FestivalDetailDTO deleteFestiva(@PathParam("id") Long id) throws WebApplicationException {
        FestivalEntity fest;
        if ((fest = logic.deleteFestival(id)) != null) {
            return new FestivalDetailDTO(fest);
        } else {
            throw new WebApplicationException("No hay un festival con ese ID.");
        }

    }

}
