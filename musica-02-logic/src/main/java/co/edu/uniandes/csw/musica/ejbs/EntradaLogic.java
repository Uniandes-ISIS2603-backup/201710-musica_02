/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.EntradaPersistence;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
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
    private EntradaPersistence entradaPersistence;

    @Inject
    private FuncionPersistence funcionPersistence;

    public List<EntradaEntity> getEntradas() {
        return entradaPersistence.findAll();
    }

    public EntradaEntity createEntrada(EntradaEntity entity) throws Exception {
        if (funcionPersistence.find(entity.getFuncionEntity().getId()) == null) {
            throw new BusinessLogicException("No existe la funcion");
        } else if(entity.getFuncionEntity().getEntradasDisponibles()>0){
            return entradaPersistence.create(entity);
        }
        else {
            throw new BusinessLogicException("No hay entradas disponibles en esa funcion");
        }

    }

    public List<EntradaEntity> getByCliente(String usuario) {
        return entradaPersistence.findByCliente(usuario);
    }

    public List<EntradaEntity> getByFuncion(Long id) {
        return entradaPersistence.findByFuncion(id);
    }

    public ClienteEntity getCliente(Long id) {
        return entradaPersistence.getCliente(id);
    }
}
