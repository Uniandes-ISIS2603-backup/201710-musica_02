/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.EntradaPersistence;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jd.gonzaleza
 */
@Stateless
public class FuncionLogic {

    @Inject
    private FuncionPersistence funcionPersistence;
    @Inject
    private EntradaPersistence entradaPersistence;

    public List<FuncionEntity> getFunciones() {
        return funcionPersistence.findAll();
    }

    public FuncionEntity getFuncion(Long id) {
        return funcionPersistence.find(id);
    }

    public List<FuncionEntity> getFuncionesFecha(Date fecha) {
        return funcionPersistence.findAllFecha(fecha);
    }

    public List<FuncionEntity> getFuncionesEsPaga(Boolean paga) {
        return funcionPersistence.findAllEsPaga(paga);
    }

    public FuncionEntity createFuncion(FuncionEntity entity) {
        return funcionPersistence.create(entity);
    }

    public FuncionEntity updateFuncion(FuncionEntity entity) {
        return funcionPersistence.update(entity);
    }

    public void deleteFuncion(Long id) {
        funcionPersistence.delete(id);
    }

    public FuncionEntity agregarVenueEntity(Long funID, Long venueID) {
        return funcionPersistence.agregarVenue(venueID, funID);
    }

    public FuncionEntity agregarEntrada(EntradaEntity entity) throws BusinessLogicException {
        FuncionEntity fun = funcionPersistence.find(entity.getFuncionEntity().getId());
        int ent = fun.getEntradasDisponibles();
        if(ent > 0){
            fun.setEntradasDisponibles(ent--);
            return funcionPersistence.agregarEntrada(entity.getId(),entity.getFuncionEntity().getId());
        } 
        else {
            throw new BusinessLogicException("No hay mas entradas disponibles para esta funcion");
        }
    }
}
