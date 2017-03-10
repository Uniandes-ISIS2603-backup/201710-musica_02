package co.edu.uniandes.csw.musica.dtos;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlRootElement
public class FuncionDTO implements Serializable
{

	private Date fecha;

	private Integer duracion;

	private Boolean esPaga;

	private Integer entradasDisponibles;

	private Long id;
        
      
	public FuncionDTO(){
            
	}
        public FuncionDTO(FuncionEntity enti)
        {
            if(enti != null)
            {
                id = enti.getId();
                fecha = enti.getFecha();
                entradasDisponibles = enti.getEntradasDisponibles();
                esPaga = enti.getEsPaga();
                duracion = enti.getDuracion();
            }
        }
       public FuncionEntity toEntity()
       {
           FuncionEntity entity = new FuncionEntity();
           entity.setId(this.id);
           entity.setDuracion(this.duracion);
           entity.setEsPaga(this.esPaga);
           entity.setEntradasDisponibles(this.entradasDisponibles);
           entity.setFecha(this.fecha);
            return entity;
       }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the duracion
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the esPaga
     */
    public Boolean getEsPaga() {
        return esPaga;
    }

    /**
     * @param esPaga the esPaga to set
     */
    public void setEsPaga(Boolean esPaga) {
        this.esPaga = esPaga;
    }

    /**
     * @return the entradasDisponibles
     */
    public Integer getEntradasDisponibles() {
        return entradasDisponibles;
    }

    /**
     * @param entradasDisponibles the entradasDisponibles to set
     */
    public void setEntradasDisponibles(Integer entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the review
     */


    
}

