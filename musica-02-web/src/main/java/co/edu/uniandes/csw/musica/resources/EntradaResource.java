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
//TODO  YA quitar los imports qu eno se necesitan

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
@Path("/clientes/{idCliente: \\d+}/entradas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntradaResource {

    @Inject
    private EntradaLogic entradaLogic;
    @Context
    HttpServlet http;

    private List<EntradaDetailDTO> listEntity2DTO(List<EntradaEntity> entityList) {
        List<EntradaDetailDTO> listDTO = new ArrayList<>();
        if (entityList != null) {
            for (EntradaEntity c : entityList) {
                EntradaDetailDTO est = new EntradaDetailDTO(c);
                listDTO.add(est);
            }
        }
        return listDTO;
    }

    @GET
    //@Path("{idCliente: \\d+}")
    public List<EntradaDetailDTO> getByCliente(@PathParam("idCliente") Long id) {
        if(id != 666) {
        return listEntity2DTO(entradaLogic.getByCliente(id));
        }
        else
        {
            return listEntity2DTO(entradaLogic.getAll());
        }
    }
    

    @GET
    @Path("/funciones/{idFuncion: \\d+}")
    // TODO funciones/{funcion}  es la convención navegar sobre las colecciones (es decir en plural) 
    // TODO si el recurso no existe se debe disparar WebApplication Exception 404
    public List<EntradaDetailDTO> getByFuncion(@PathParam("idFuncion") Long id) throws Exception {
        return listEntity2DTO(entradaLogic.getByFuncion(id));
    }

    //@POSTs
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
