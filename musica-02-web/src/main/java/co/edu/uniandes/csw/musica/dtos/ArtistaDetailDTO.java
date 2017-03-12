package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
/**
 *
 * @author a.echeverrir
 */

public class ArtistaDetailDTO extends ArtistaDTO
{
	
	private FuncionDTO funcionDTO;

	
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

}

