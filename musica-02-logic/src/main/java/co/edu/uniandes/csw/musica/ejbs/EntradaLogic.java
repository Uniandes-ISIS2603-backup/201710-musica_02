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
    
    public List<EntradaEntity> getEntradaParam(String usuario) {
        return persistence.findAllParaCliente(usuario);
    }
    
    public ClienteEntity getCliente(Long id) {
        return persistence.getCliente(id);
    }
}
