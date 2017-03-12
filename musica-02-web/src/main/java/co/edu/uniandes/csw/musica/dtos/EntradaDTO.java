package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@XmlRootElement
public class EntradaDTO implements Serializable{
    private Long id;

    private Integer noEntrada;

    private String silla;

    private Double precio;

    private Boolean libre;

    public EntradaDTO(){
    }

    public EntradaDTO(EntradaEntity entity){
        if(entity != null){
            this.id = entity.getId();
            this.noEntrada = entity.getNoEntrada();
            this.silla = entity.getSilla();
            this.precio = entity.getPrecio();
            this.libre = entity.getLibre();
        }
    }
    
    public EntradaEntity toEntity() {
        EntradaEntity e = new EntradaEntity();
        e.setId(this.getId());
        e.setNoEntrada(this.getNoEntrada());
        e.setSilla(this.getSilla());
        e.setPrecio(this.getPrecio());
        e.setLibre(this.getLibre());
        return e;
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
     * @return the noEntrada
     */
    public Integer getNoEntrada() {
        return noEntrada;
    }

    /**
     * @param noEntrada the noEntrada to set
     */
    public void setNoEntrada(Integer noEntrada) {
        this.noEntrada = noEntrada;
    }

    /**
     * @return the silla
     */
    public String getSilla() {
        return silla;
    }

    /**
     * @param silla the silla to set
     */
    public void setSilla(String silla) {
        this.silla = silla;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the libre
     */
    public Boolean getLibre() {
        return libre;
    }

    /**
     * @param libre the libre to set
     */
    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

        

}

