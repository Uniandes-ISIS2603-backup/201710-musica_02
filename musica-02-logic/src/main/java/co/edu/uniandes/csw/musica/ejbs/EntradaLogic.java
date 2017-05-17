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
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.EntradaPersistence;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author p.salazar12
 */
// TODO falta implementar las reglas de negocio. 
// TODO  YA Por ejemplo crear una entrada debe verificar que la función si existe y que hay disoonibilidad.
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

    public List<EntradaEntity> getByCliente(Long id) {
        return entradaPersistence.findByCliente(id);
    }

    public List<EntradaEntity> getByFuncion(Long id) throws Exception{
         List<EntradaEntity> e = entradaPersistence.findByFuncion(id);
         if(e == null) throw new WebApplicationException(404);
        return e;
    }

    public ClienteEntity getCliente(Long id) {
        return entradaPersistence.getCliente(id);
    }
}
