/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ReviewEntity;

/**
 *
 * @author jd.gonzaleza
 */
public class ReviewDetailDTO extends ReviewDTO{
     /**
     * @generated
     */
    public ReviewDetailDTO() {
        super();
    }

    public ReviewDetailDTO(ReviewEntity entity) {
        super(entity);

    }

    @Override
    public ReviewEntity toEntity() {

        return super.toEntity();
    }
}
