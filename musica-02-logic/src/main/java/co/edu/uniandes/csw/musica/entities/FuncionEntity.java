/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jd.gonzaleza
 */
@Entity
public class FuncionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private Integer duracion;
    private Boolean esPaga;
    private Integer entradasDisponibles;
    
    @OneToMany(mappedBy = "funcion")
    private List<ReviewEntity> reviews = new ArrayList<ReviewEntity>();
    @OneToMany(mappedBy ="funcionEntity")
    private List<EntradaEntity> entradas = new ArrayList<EntradaEntity>();
    @ManyToMany
    private List<ArtistaEntity> artistas = new ArrayList<ArtistaEntity>();
    @ManyToOne
    private FestivalEntity festivalEntity;
    @ManyToOne
    private VenueEntity venueEntity;
    

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getId() != null) {
            return this.getId().equals(((FuncionEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
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
     * Agregar review a la lista
     */
    public void agregarReviewaLista(ReviewEntity rev) {
        reviews.add(rev);
    }

    /**
     * @param entradasDisponibles the entradasDisponibles to set
     */
    public void setEntradasDisponibles(Integer entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }

    /**
     * @return the reviews
     */
    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }



    /**
     * @return the artistas
     */
    public List<ArtistaEntity> getArtistas() {
        return artistas;
    }

    /**
     * @param artistas the artistas to set
     */
    public void setArtistas(List<ArtistaEntity> artistas) {
        this.artistas = artistas;
    }

    /**
     * @return the festivalEntity
     */
    public FestivalEntity getFestivalEntity() {
        return festivalEntity;
    }

    /**
     * @param festivalEntity the festivalEntity to set
     */
    public void setFestivalEntity(FestivalEntity festivalEntity) {
        this.festivalEntity = festivalEntity;
    }

    /**
     * @return the venueEntity
     */
    public VenueEntity getVenueEntity() {
        return venueEntity;
    }

    /**
     * @param venueEntity the venueEntity to set
     */
    public void setVenueEntity(VenueEntity venueEntity) {
        this.venueEntity = venueEntity;
    }
    
    public List<EntradaEntity> getEntradas() {
        return entradas;
    }
    
    public void setEntradas(List<EntradaEntity> entradas) {
        this.entradas = entradas;
    }
    
    public void addEntrada(EntradaEntity entrada) {
        entradas.add(entrada);
    }

}
