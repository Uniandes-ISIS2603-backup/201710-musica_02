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
//TODO quitar los imports qu eno se necesitan
import co.edu.uniandes.csw.musica.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.ClienteLogic;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author p.salazar12
 */
 // TODO si el recurso con el id dado no existe se debe disparar WebApplication Exception 404
   
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteLogic logic;

    private List<ClienteDetailDTO> listEntity2DTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> listDTO = new ArrayList<>();
        for (ClienteEntity c : entityList) {
            ClienteDetailDTO est = new ClienteDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<ClienteDetailDTO> getClientes() {
        return listEntity2DTO(logic.getClientes());
    }

    @GET
    @Path("/abonados")
    public List<ClienteDetailDTO> getAbonados() {
        return listEntity2DTO(logic.getAbonados());
    }

    @GET
    @Path("{id: \\d+}")
     // TODO si el recurso no existe se debe disparar WebApplication Exception 404
    // TODO si es un strig usuario entonces el pattern matching no estaá bien
    public ClienteDetailDTO getClienteByUser(@PathParam("id") Long id) throws BusinessLogicException {
        return new ClienteDetailDTO(logic.getById(id));
    }

    @POST
    public ClienteDetailDTO create(ClienteDetailDTO dto) throws BusinessLogicException {
        return new ClienteDetailDTO(logic.createCliente(dto.toEntity()));
    }
    
    @PUT
    public ClienteDetailDTO updateCliente(ClienteDetailDTO cliente) {
        return new ClienteDetailDTO(logic.updateCliente(cliente.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public ClienteDetailDTO deleteCliente(@PathParam("id") Long id) throws WebApplicationException {
        ClienteEntity cliente;
        if((cliente = logic.deleteCliente(id))!= null) {
            return new ClienteDetailDTO(cliente);
        }
        else {
            throw new WebApplicationException("No hay un cliente con ese id");
        }
    }
}
