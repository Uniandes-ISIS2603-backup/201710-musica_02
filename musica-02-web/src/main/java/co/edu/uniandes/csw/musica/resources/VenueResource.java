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
    public VenueDetailDTO createVenue(VenueDetailDTO dto) throws BusinessLogicException {        
        VenueEntity venue = logic.createVenue(dto.toEntity());
        return new VenueDetailDTO(venue);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public VenueDetailDTO updateVenue(@PathParam("id") Long id, VenueDTO dto)
    {
         // TODO verficar que exista el venue y si no, disparar WebApplicationException con 404
        VenueEntity entity = dto.toEntity();
        entity.setId(id);
        return new VenueDetailDTO(logic.updateVenue(entity)); 
    }
    @GET 
    @Path("{id: \\d+}")
    public VenueDetailDTO getVenue(@PathParam("id") Long id) throws BusinessLogicException
    {
        // TODO verficar que exista el venue y si no, disparar WebApplicationException con 404
       
        return new VenueDetailDTO(logic.getVenue(id));
    }
    
}
