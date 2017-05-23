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
