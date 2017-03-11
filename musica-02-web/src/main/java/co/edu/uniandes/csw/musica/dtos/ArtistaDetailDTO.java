package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
/**
 *
 * @author a.echeverrir
 */

public class ArtistaDetailDTO extends ArtistaDTO
{
	
	public FuncionDTO funcionDTO;

	
	public ArtistaDetailDTO()
        {
		super();
	}
        
        public ArtistaDetailDTO(ArtistaEntity entity) 
        {
        super(entity);
        funcionDTO = new FuncionDTO(entity.getFuncionEntity());
        }

    @Override
    public ArtistaEntity toEntity() 
            
    {        
        return super.toEntity();
    }

}

