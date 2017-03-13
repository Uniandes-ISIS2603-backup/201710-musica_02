package co.edu.uniandes.csw.musica.dtos;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
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
    
    private List<DiscoDTO> discosDTOs;
    
	
    public ArtistaDetailDTO()
    {
	super();
    }
        
    public ArtistaDetailDTO(ArtistaEntity entity) 
    {
        super(entity);
        funcionesDTOs = new ArrayList<FuncionDTO>();
        discosDTOs = new ArrayList<DiscoDTO>();
        
         for (FuncionEntity c : entity.getFunciones())
        {
            funcionesDTOs.add(new FuncionDTO(c));
        }
         for (DiscoEntity c : entity.getDiscos())
        {
            discosDTOs.add(new DiscoDTO(c));
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
        
        List <DiscoEntity> discos = new ArrayList<>();
        if( discosDTOs != null )
        {
            for(DiscoDTO c : discosDTOs) 
           {
            discos.add(c.toEntity());
           }
           entity.setDiscos(discos);
            
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

