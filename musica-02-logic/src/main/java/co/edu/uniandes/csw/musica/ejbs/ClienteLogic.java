/* 
 * The MIT License
 *
 * Copyright 2017 Mighty Fingers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.musica.ejbs;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

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

    public ClienteEntity updateCliente(ClienteEntity entity) {
        return persistence.update(entity);
    }

    public void deleteCliente(Long id) {
        persistence.delete(id);
    }

    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {

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

    public ClienteEntity getById(Long id) throws BusinessLogicException {
        
        ClienteEntity e = persistence.findById(id);

        if (e == null) {
            throw new WebApplicationException(404);
        } else {
            return e;
        }
        
    }
    public ClienteEntity getByUsuario(String usuario) throws BusinessLogicException {
        if (persistence.findByUsuario(usuario) == null) {
            throw new WebApplicationException(404);
        } else {
            return persistence.findByUsuario(usuario);
        }
    }

}
