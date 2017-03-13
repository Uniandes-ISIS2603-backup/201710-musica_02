/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
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
   
   public ClienteEntity getCliente(String usuario) {
       return persistence.find(usuario);
   }
   
   public ClienteEntity updateCliente(ClienteEntity entity)
   {
       return persistence.update(entity);
   }
   public void deleteCliente(String usuario)
   {
       persistence.delete(usuario);
   }
    
}
