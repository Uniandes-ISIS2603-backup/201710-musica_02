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

import co.edu.uniandes.csw.musica.entities.FuncionEntity;
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

}
