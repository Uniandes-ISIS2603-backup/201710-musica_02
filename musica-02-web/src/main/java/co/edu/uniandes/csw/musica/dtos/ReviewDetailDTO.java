/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jd.gonzaleza
 */
@XmlRootElement
public class ReviewDetailDTO extends ReviewDTO{

        private FuncionDTO funcionDTO;
        private ClienteDTO clienteDTO;
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

    public ReviewDetailDTO() {
        super();
    }

    public ReviewDetailDTO(ReviewEntity entity) {
        super(entity);
        funcionDTO = new FuncionDTO(entity.getFuncion());
        clienteDTO = new ClienteDTO(entity.getCliente());

    }

    @Override
    public ReviewEntity toEntity() {
        
        ReviewEntity enti = super.toEntity();
        enti.setFuncion(getFuncionDTO().toEntity());
        enti.setCliente(getClietneDTO().toEntity());
        return enti;
        
    }

    /**
     * @return the clietneDTO
     */
    public ClienteDTO getClietneDTO() {
        return clienteDTO;
    }

    /**
     * @param clietneDTO the clietneDTO to set
     */
    public void setClietneDTO(ClienteDTO clietneDTO) {
        this.clienteDTO = clietneDTO;
    }
}
