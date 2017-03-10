/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import co.edu.uniandes.csw.musica.persistence.ReviewPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jd.gonzaleza
 */
@Stateless
public class ReviewLogic {

    @Inject
    private ReviewPersistence persistence;

    public List<ReviewEntity> getReviews() {
        return persistence.findAll();
    }

    public ReviewEntity createReview(ReviewEntity entity) {
        return persistence.create(entity);
    }
    public List<ReviewEntity> getReviewsParam(Long id)
    {
        return persistence.findAllparaFuncion(id);
    }
}
