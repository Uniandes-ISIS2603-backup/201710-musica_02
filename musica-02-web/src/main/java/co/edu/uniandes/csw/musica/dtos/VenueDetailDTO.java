package co.edu.uniandes.csw.musica.dtos;


import co.edu.uniandes.csw.musica.entities.VenueEntity;

/**
 *
 * @author a.echeverrir
 */
public class VenueDetailDTO extends VenueDTO
{
	
	public CiudadDTO ciudadDTO;
	
	public FestivalDTO festivalDTO;

	public FuncionDTO funcionDTO;

	public VenueDetailDTO()
        {
		super();
	}
        
        public VenueDetailDTO(VenueEntity entity) 
        {
        super(entity);
        ciudadDTO = new CiudadDTO(entity.getCiudadEntity());
        festivalDTO = new FestivalDTO(entity.getFestivalEntity());
        funcionDTO = new FuncionDTO(entity.getFuncionEntity());
        }

    @Override
    public VenueEntity toEntity() 
    {        
        return super.toEntity();
    }

}

