/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.persistence.EntradaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author p.salazar12
 */

// TODO falta implementar las reglas de negocio. 
// TODO Por ejemplo crear una entrada debe verificar que la función si existe y que hay disoonibilidad.
@Stateless
public class EntradaLogic {
    
    @Inject
    private EntradaPersistence persistence;
    
    public List<EntradaEntity> getEntradas() {
        return persistence.findAll();
    }
    
    public EntradaEntity createEntrada(EntradaEntity entity) {
        return persistence.create(entity);
    }
    
    public List<EntradaEntity> getByCliente(String usuario) {
        return persistence.findByCliente(usuario);
    }
    
    public List<EntradaEntity> getByFuncion(Long id) {
        return persistence.findByFuncion(id);
    }
    
    public ClienteEntity getCliente(Long id) {
        return persistence.getCliente(id);
    }
}
