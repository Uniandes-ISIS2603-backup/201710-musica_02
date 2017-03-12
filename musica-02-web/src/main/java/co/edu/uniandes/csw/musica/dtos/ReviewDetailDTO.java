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
     * @return the funcionDTO
     */
    public FuncionDTO getFuncionDTO() {
        return funcionDTO;
    }

    /**
     * @param funcionDTO the funcionDTO to set
     */
    public void setFuncionDTO(FuncionDTO funcionDTO) {
        this.funcionDTO = funcionDTO;
    }
     /**
     * @generated
     */
    private FuncionDTO funcionDTO;
    public ReviewDetailDTO() {
        super();
    }

    public ReviewDetailDTO(ReviewEntity entity) {
        super(entity);
        funcionDTO = new FuncionDTO();

    }

    @Override
    public ReviewEntity toEntity() {
        ReviewEntity enti = super.toEntity();
        enti.setFuncion(getFuncionDTO().toEntity());
        return enti;
        
    }
}
