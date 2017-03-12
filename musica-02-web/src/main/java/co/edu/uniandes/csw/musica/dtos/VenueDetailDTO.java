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
        VenueEntity entity = super.toEntity();
        entity.setFestivalEntity(festivalDTO.toEntity());
        entity.setCiudadEntity(ciudadDTO.toEntity());
        entity.setFuncionEntity(funcionDTO.toEntity());
        return super.toEntity();
    }

}

