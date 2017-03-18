/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;


// TODO quitar los imports que no se utilizan
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
//TODO faltan las reglas de negocio para crear uan función o cambiarla. 
// TODO Por ejemplo, no se debería crear una función sin saber si la feria viene en el entity y existe
//TODO Al menos el festival tiene que existir.

@Stateless
public class FuncionLogic {

    @Inject
    private FuncionPersistence funcionPersistence;
    @Inject
    private EntradaPersistence entradaPersistence;

    public List<FuncionEntity> getFunciones() {
        return funcionPersistence.findAll();
    }

    public FuncionEntity getFuncion(Long id) throws Exception {
        FuncionEntity funcion = funcionPersistence.find(id);
        if(funcion != null )
        return funcionPersistence.find(id);
        throw new Exception ("No existe una funcion con dicho id"); //TODO esto se debe detectar en la clase recurso
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

    // TODO quién llama este método?
    // TODO verificar que el venue exista y esté disponible
    public FuncionEntity agregarVenueEntity(Long funID, Long venueID) {
        return funcionPersistence.agregarVenue(venueID, funID);
    }

   //public FuncionEntity agregarEntrada(EntradaEntity entity) throws BusinessLogicException {
      //  FuncionEntity fun = funcionPersistence.find(entity.getFuncionEntity().getId());
       // int ent = fun.getEntradasDisponibles();
      //  if(ent > 0){
        //    fun.setEntradasDisponibles(ent--);
          //  return funcionPersistence.agregarEntrada(entity.getId(),entity.getFuncionEntity().getId());
      //  } 
       // else {
        //    throw new BusinessLogicException("No hay mas entradas disponibles para esta funcion");
       // }
    
   
}
