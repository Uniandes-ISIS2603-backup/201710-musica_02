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
    
    

}

