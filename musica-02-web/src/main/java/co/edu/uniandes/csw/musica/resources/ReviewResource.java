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
    public List<ReviewDetailDTO> getReviews(@PathParam("idFuncion") Long id) 
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
