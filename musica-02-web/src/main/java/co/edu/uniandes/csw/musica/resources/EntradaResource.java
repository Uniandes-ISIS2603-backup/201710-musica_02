/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;
//TODO quitar los imports qu eno se necesitan
import co.edu.uniandes.csw.musica.dtos.EntradaDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.EntradaLogic;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

/**
 *
 * @author p.salazar12
 */
// TODO según el diagrama de clases, entrada es un subrecurso de cliente. 
// TODO sería el path "/clientes/{idCliente\\+d}/entradas" 
// TODO Cada método tendría el idCliente como PathParam
@Path("/clientes/{idCliente}/entradas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntradaResource {

    @Inject
    private EntradaLogic entradaLogic;
    @Context
    HttpServlet http;

    private List<EntradaDetailDTO> listEntity2DTO(List<EntradaEntity> entityList) {
        List<EntradaDetailDTO> listDTO = new ArrayList<>();
        for (EntradaEntity c : entityList) {
            EntradaDetailDTO est = new EntradaDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<EntradaDetailDTO> getEntradas() {
        return listEntity2DTO(entradaLogic.getEntradas());
    }

    @GET
    @Path("usuario/{usuario}")
    // TODO Revisar con los TODOs del principio
    // TODO: documentar lo que retorna el método. Las entradas de un usuario sin importar la feria ni la función  ?
    // TODO si el recurso no existe se debe disparar WebApplication Exception 404
    public List<EntradaDetailDTO> getByCliente(@PathParam("usuario") String usuario) {
        return listEntity2DTO(entradaLogic.getByCliente(usuario));
    }

    @GET
    @Path("funcion/{funcion}")
    // TODO funciones/{funcion}  es la convención navegar sobre las colecciones (es decir en plural) 
    // TODO si el recurso no existe se debe disparar WebApplication Exception 404
   
    public List<EntradaDetailDTO> getByFuncion(@PathParam("funcion") Long id) {
        return listEntity2DTO(entradaLogic.getByFuncion(id));
    }

    //@POST
    // TODO documentar qué hace el método. Crea una entrada para qué función? 
    // de qué feria....?
    //public EntradaDetailDTO create(EntradaDetailDTO dto) {
    //    return new EntradaDetailDTO(entradaLogic.createEntrada(dto.toEntity()));
    //}
   // @POST
   // public EntradaDetailDTO create(EntradaDetailDTO dto) throws BusinessLogicException {
    //    funcionLogic.agregarEntrada(dto.toEntity());
     //   return new EntradaDetailDTO(entradaLogic.createEntrada(dto.toEntity()));
   // }

}
