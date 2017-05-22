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

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a.echeverrir
 */
@XmlRootElement
public class ArtistaDetailDTO extends ArtistaDTO
{
    
    private List<FuncionDTO> funcionesDTOs;
    private GeneroDTO generoDTO;
    
	
    public ArtistaDetailDTO()
    {
	super();
    }
        
    public ArtistaDetailDTO(ArtistaEntity entity) 
    {
        super(entity);
        
        funcionesDTOs = new ArrayList<FuncionDTO>();
        
         for (FuncionEntity c : entity.getFunciones())
        {
            funcionesDTOs.add(new FuncionDTO(c));
        }
        
         if (entity.getGenero() != null) 
         {
                generoDTO = new GeneroDTO(entity.getGenero());
         }
        
    }

    @Override
    public ArtistaEntity toEntity()     
    {  
        ArtistaEntity entity = super.toEntity();
        
        List <FuncionEntity> funciones = new ArrayList<>();
        if(funcionesDTOs != null)
        {
           for (FuncionDTO c : funcionesDTOs) 
           {
            funciones.add(c.toEntity());
           }
           entity.setFunciones(funciones);
        }
        if (generoDTO!= null)
        {
            entity.setGenero(generoDTO.toEntity());
        }
        
        return entity;
    }

    /**
     * @return the funcionesDTOs
     */
    public List<FuncionDTO> getFuncionesDTOs() 
    {
        return funcionesDTOs;
    }

    /**
     * @param funcionesDTOs the funcionesDTOs to set
     */
    public void setFuncionesDTOs(List<FuncionDTO> funcionesDTOs) {
        this.funcionesDTOs = funcionesDTOs;
    }
    
    /**
     * @return the generoDTO
     */
    public GeneroDTO getGeneroDTO() {
        return generoDTO;
    }

    /**
     * @param generoDTO the generoDTO to set
     */
    public void setGeneroDTO(GeneroDTO generoDTO) {
        this.generoDTO = generoDTO;
    }
    
    

}

