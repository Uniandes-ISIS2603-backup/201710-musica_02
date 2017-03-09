/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.ReviewDTO;
import co.edu.uniandes.csw.musica.ejbs.ReviewLogic;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jd.gonzaleza
 */
@Path("/reviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {
    @Inject
    private ReviewLogic logic;
    @Context
    HttpServlet http;
    
     private List<ReviewDTO> listEntity2DTO(List<ReviewEntity> entityList) {
        List<ReviewDTO> listDTO = new ArrayList<>();
        for (ReviewEntity c : entityList) {
            ReviewDTO est = new ReviewDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<ReviewDTO> getEstudiantes() {

        return listEntity2DTO(logic.getReviews());
    }

    @POST
    public ReviewDTO createEstudiante(ReviewDTO dto) throws BusinessLogicException {
        ReviewEntity estu = logic.createReview(dto.toEntity());
        return new ReviewDTO(estu);
    }
    
}
