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

import javax.xml.bind.annotation.XmlRootElement;
import co.edu.uniandes.csw.musica.entities.CancionEntity;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class CancionDetailDTO extends CancionDTO
{
    
    private DiscoDTO discoDTO;
    
    public CancionDetailDTO(){
        super();
    }
    
    public CancionDetailDTO(CancionEntity entity)
    {
        super(entity);
        
        if(entity.getDiscoEntity() != null){
            discoDTO = new DiscoDTO(entity.getDiscoEntity());
        }
        
    }
    
    @Override
    public CancionEntity toEntity()
    {
         CancionEntity entity = super.toEntity();
         if(getDiscoDTO() != null){
             entity.setDiscoEntity(getDiscoDTO().toEntity());
         }
         return entity;
    }

    /**
     * @return the discoDTO
     */
    public DiscoDTO getDiscoDTO() {
        return discoDTO;
    }

    /**
     * @param discoDTO the discoDTO to set
     */
    public void setDiscoDTO(DiscoDTO discoDTO) {
        this.discoDTO = discoDTO;
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
