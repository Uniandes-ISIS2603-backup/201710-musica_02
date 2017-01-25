/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.employee.resources;


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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.employee.dtos.EmployeeDetailDTO;
import co.edu.uniandes.csw.employee.ejbs.EmployeeLogic;
import co.edu.uniandes.csw.employee.entities.EmployeeEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: employees/
 * @generated
 */
@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject private EmployeeLogic employeeLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de EmployeeEntity a una lista de EmployeeDetailDTO.
     *
     * @param entityList Lista de EmployeeEntity a convertir.
     * @return Lista de EmployeeDetailDTO convertida.
     * @generated
     */
    private List<EmployeeDetailDTO> listEntity2DTO(List<EmployeeEntity> entityList){
        List<EmployeeDetailDTO> list = new ArrayList<>();
        for (EmployeeEntity entity : entityList) {
            list.add(new EmployeeDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Employee
     *
     * @return Colección de objetos de EmployeeDetailDTO
     * @generated
     */
    @GET
    public List<EmployeeDetailDTO> getEmployees() {
        
        return listEntity2DTO(employeeLogic.getEmployees());
    }

    /**
     * Obtiene los datos de una instancia de Employee a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EmployeeDetailDTO con los datos del Employee consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public EmployeeDetailDTO getEmployee(@PathParam("id") Long id) {
        return new EmployeeDetailDTO(employeeLogic.getEmployee(id));
    }

    /**
     * Se encarga de crear un Employee en la base de datos
     *
     * @param dto Objeto de EmployeeDetailDTO con los datos nuevos
     * @return Objeto de EmployeeDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    public EmployeeDetailDTO createEmployee(EmployeeDetailDTO dto) {
        return new EmployeeDetailDTO(employeeLogic.createEmployee(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Employee
     *
     * @param id Identificador de la instancia de Employee a modificar
     * @param dto Instancia de EmployeeDetailDTO con los nuevos datos
     * @return Instancia de EmployeeDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public EmployeeDetailDTO updateEmployee(@PathParam("id") Long id, EmployeeDetailDTO dto) {
        EmployeeEntity entity = dto.toEntity();
        entity.setId(id);
        return new EmployeeDetailDTO(employeeLogic.updateEmployee(entity));
    }

    /**
     * Elimina una instancia de Employee de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEmployee(@PathParam("id") Long id) {
        employeeLogic.deleteEmployee(id);
    }
    
}
