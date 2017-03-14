/**
 * @author ca.anzola
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.CiudadDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.CiudadLogic;
import co.edu.uniandes.csw.musica.entities.CiudadEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * URI: ciudades/
 */
@Path("/ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadResource 
{
    @Inject private CiudadLogic ciudadLogic;
    @Context private HttpServletResponse http;
    
    /**
     * Convierte una lista de CiudadEntity a una lista de CiudadDetailDTO.
     *
     * @param entityList Lista de CiudadEntity a convertir.
     * @return Lista de CiudadDetailDTO convertida.
     */
    private List<CiudadDetailDTO> listEntity2DTO(List<CiudadEntity> entityList)
    {
        List<CiudadDetailDTO> list = new ArrayList<>();
        for (CiudadEntity entityCity : entityList) 
        {
            list.add(new CiudadDetailDTO(entityCity));
        }
        return list;
    }
    
    @GET
    public List<CiudadDetailDTO> getCities()
    {
        System.out.println("co.edu.uniandes.csw.musica.resources.CiudadResource.getCities()");
        return listEntity2DTO(ciudadLogic.getCities());
    }
    
    @GET
    @Path("name")
    public CiudadDetailDTO getCityByName(@PathParam("name")String name)
    {
        CiudadEntity buscada = ciudadLogic.getCityByName(name);
        if(buscada == null)
        {
            throw new WebApplicationException("La ciudad con ese nombre no existe", 404);
        }
        else
        {
             return new CiudadDetailDTO(buscada);
        }
    }
    
    @POST
    public CiudadDetailDTO createCity(CiudadDetailDTO ciudadDto) throws BusinessLogicException
    {
        return new CiudadDetailDTO(ciudadLogic.createCity(ciudadDto.toEntity()));
    }
    
    @PUT
    @Path("name")
    public CiudadDetailDTO updateCity(@PathParam("name") String name, CiudadDetailDTO ciudadDto)
    {
        CiudadEntity entity = ciudadDto.toEntity();
        entity.setName(name);
        return new CiudadDetailDTO(ciudadLogic.updateCity(entity));
    }
    
    @DELETE  
    @Path("/{name}")
    public void deleteCity(@PathParam("name")String name)
    {
        ciudadLogic.deleteCity(name);
    }
    
    
}
