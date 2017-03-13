/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author p.salazar12
 */
@Stateless
public class ClienteLogic {
    
   @Inject
   private ClientePersistence persistence;
   
   public List<ClienteEntity> getClientes() {
       return persistence.findAll();
   }
   
   public ClienteEntity updateCliente(ClienteEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteCliente(String usuario)
   {
       persistence.delete(usuario);
   }
   public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException{
       if(persistence.findByUsuario(entity.getUsuario()) != null){
           throw new BusinessLogicException("Ya hay un cliente con ese usuario");
       }
       else{
           return persistence.create(entity);
       }
   } 
   
   public List<ClienteEntity> getAbonados() {
       return persistence.findAllAbonados();
   }
   
   public ClienteEntity getByUsuario(String usuario) throws BusinessLogicException{
       if(persistence.findByUsuario(usuario)== null){
            throw new BusinessLogicException("No hay un cliente con ese usuario");
       }
       else {
           return persistence.findByUsuario(usuario);
       }
   }
   
   
    
}
