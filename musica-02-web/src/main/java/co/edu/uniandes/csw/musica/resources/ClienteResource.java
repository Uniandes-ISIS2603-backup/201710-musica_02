/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;
//TODO quitar los imports qu eno se necesitan
import co.edu.uniandes.csw.musica.dtos.ClienteDTO;
import co.edu.uniandes.csw.musica.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.ClienteLogic;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

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
    @Path("{usuario: \\d+}")
     // TODO si el recurso no existe se debe disparar WebApplication Exception 404
    // TODO si es un strig usuario entonces el pattern matching no estaá bien
    public ClienteDetailDTO getClienteByUser(@PathParam("usuario") String usuario) throws BusinessLogicException {
        return new ClienteDetailDTO(logic.getByUsuario(usuario));
    }

    @POST
    public ClienteDetailDTO create(ClienteDetailDTO dto) throws BusinessLogicException {
        return new ClienteDetailDTO(logic.createCliente(dto.toEntity()));
    }

    @PUT
    @Path("abonos/{usuario: \\d+}")
    // TODO si el recurso no existe se debe disparar WebApplication Exception 404
    // TODO si es un strig usuario entonces el pattern matching no estaá bien
    // TODO es abonos o abonados?
    // QUé hace el método? Qué le altera al abono?
    public ClienteDetailDTO alterarAbono(@PathParam("usuario") String usuario, @QueryParam("abono") int abono, ClienteDetailDTO dto) {
        dto.setAbono(abono);
        return new ClienteDetailDTO(logic.updateCliente(dto.toEntity()));
    }
}
