/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author p.salazar12
 */
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
    
    @POST
    public ClienteDetailDTO create(ClienteDetailDTO dto) throws BusinessLogicException {
         return new ClienteDetailDTO(dto.toEntity());   
    }
    
    
}
