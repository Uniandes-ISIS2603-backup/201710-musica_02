/*
 * The MIT License
 *
 * Copyright 2017 af.olivares10.
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

import co.edu.uniandes.csw.musica.dtos.GeneroDTO;
import co.edu.uniandes.csw.musica.ejbs.GeneroLogic;
import co.edu.uniandes.csw.musica.entities.GeneroEntity;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author af.olivares10
 */
@Path("/generos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GeneroResource {
    
    @Inject
    private GeneroLogic logic;
    @Context
    HttpServlet http;

    private List<GeneroDTO> listEntity2DTO(List<GeneroEntity> entityList) {
        List<GeneroDTO> listDTO = new ArrayList<>();
        for (GeneroEntity c : entityList) {
            GeneroDTO est = new GeneroDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }
    
    @GET
    public  List<GeneroDTO> getGeneros()
    {
        return listEntity2DTO(logic.getGeneros());
    }
    
    @GET
    @Path("{id: \\d+}")
    public GeneroDTO getGenero (@PathParam("id") Long id) throws WebApplicationException
    {
        GeneroEntity gen = logic.getGenero(id);
        if (gen != null)
        return new GeneroDTO(gen);
        throw new WebApplicationException("No se encontró un genero con ese id", 404);
    }

    @POST
    public GeneroDTO createGenero (GeneroDTO genero) 
    {
        return new GeneroDTO(logic.createGenero(genero.toEntity()));
    }
    @PUT
    public GeneroDTO updateGenero (GeneroDTO genero)
    {
        return new GeneroDTO(logic.updateGenero(genero.toEntity()));
    }
    
}
