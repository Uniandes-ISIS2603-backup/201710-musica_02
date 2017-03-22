/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;
//TODO quitar los imports qu eno se necesitan
import co.edu.uniandes.csw.musica.dtos.ReviewDetailDTO;
import co.edu.uniandes.csw.musica.ejbs.ReviewLogic;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jd.gonzaleza
 */
@Path("/funciones/{idFuncion}/reviews") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {
    @Inject
    private ReviewLogic logic;
    @Context
    HttpServlet http;

    
     private List<ReviewDetailDTO> listEntity2DTO(List<ReviewEntity> entityList) {
        List<ReviewDetailDTO> listDTO = new ArrayList<>();
        for (ReviewEntity c : entityList) {
            ReviewDetailDTO est = new ReviewDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }
    
    @GET
    public List<ReviewDetailDTO> getReviews(@PathParam("id") Long id) 
    {
        return listEntity2DTO(logic.getReviews(id));
    } 
    @POST
    public ReviewDetailDTO createReview(ReviewDetailDTO dto)
    {
        ReviewEntity rev = logic.createReview(dto.toEntity());
        return new ReviewDetailDTO(rev);
    }
}
