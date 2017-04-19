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
package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlRootElement
public class ClienteDetailDTO extends ClienteDTO
{

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(List<EntradaDTO> entradas) {
        this.entradas = entradas;
    }
	
	
    private List<EntradaDTO> entradas;

    private List<ReviewDTO> reviewDTOs;


    public ClienteDetailDTO(){
            super();
    }

    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
        if(entity != null){
            entradas = new ArrayList<EntradaDTO>();
            reviewDTOs = new ArrayList<ReviewDTO>();
            for(ReviewEntity c : entity.getReviews())
            {
                reviewDTOs.add(new ReviewDTO(c));
            }
            for(EntradaEntity e : entity.getEntradas())
            {
                entradas.add(new EntradaDTO(e));
            }
        }
        
    }

    @Override
    public ClienteEntity toEntity() {
        
        ClienteEntity entity = super.toEntity();
        List<EntradaEntity> entradasEn = new  ArrayList<>();
        List<ReviewEntity> revs = new  ArrayList<>();
        if(getEntradas() != null)
        {
             for (EntradaDTO c : getEntradas()) {
            entradasEn.add(c.toEntity());
        }
             entity.setEntradas(entradasEn);
        }
        if(getReviewDTOs() != null)
        {
            for(ReviewDTO f : getReviewDTOs()){
               revs.add(f.toEntity());
            }
            entity.setReviews(revs);
        }
        return entity;
        
    }

    /**
     * @return the entradas
     */
    public List<EntradaDTO> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(ArrayList<EntradaDTO> entradas) {
        this.setEntradas(entradas);
    }

   
    /**
     * @return the reviewDTOs
     */
    public List<ReviewDTO> getReviewDTOs() {
        return reviewDTOs;
    }

    /**
     * @param reviewDTOs the reviewDTOs to set
     */
    public void setReviewDTOs(List<ReviewDTO> reviewDTOs) {
        this.reviewDTOs = reviewDTOs;
    }

}

