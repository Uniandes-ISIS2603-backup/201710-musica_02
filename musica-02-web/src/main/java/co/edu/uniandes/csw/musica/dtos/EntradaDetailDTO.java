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
package co.edu.uniandes.csw.musica.dtos;

import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class EntradaDetailDTO extends EntradaDTO {

    private FuncionDTO funcion;
    private ClienteDTO cliente;

    public EntradaDetailDTO() {
        super();
    }

    public EntradaDetailDTO(EntradaEntity entity) {
        super(entity);
        if (entity != null) {
            if(entity.getFuncionEntity() != null)
            funcion = new FuncionDTO(entity.getFuncionEntity());
            if(entity.getClienteEntity() != null)
            cliente = new ClienteDTO(entity.getClienteEntity());
        }
    }

    @Override
    public EntradaEntity toEntity() {
        EntradaEntity e = super.toEntity();
        if(cliente != null) e.setClienteEntity(cliente.toEntity());
        if (funcion != null)e.setFuncionEntity(funcion.toEntity());
        return e;
    }

    /**
     * @return the funcion
     */
    public FuncionDTO getFuncion() {
        return funcion;
    }

    /**
     * @param funcion the funcion to set
     */
    public void setFuncion(FuncionDTO funcion) {
        this.funcion = funcion;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

}
