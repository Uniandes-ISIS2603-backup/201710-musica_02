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

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@XmlRootElement
public class ClienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private Integer abono;
    private String documento;
    private String tipoDocumento;
    private Boolean registradoBlog;
    private String usuario;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated
     */
    public ClienteDTO() {
    }

    public ClienteDTO(ClienteEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.abono = entity.getAbono();
            this.documento = entity.getDocumento();
            this.tipoDocumento = entity.getTipoDocumento();
            this.registradoBlog = entity.isRegistradoBlog();
            this.usuario = entity.getUsuario();
        }
    }
    public ClienteEntity toEntity() {
        ClienteEntity e = new ClienteEntity();
        e.setId(getId());
        e.setAbono(getAbono());
        e.setDocumento(getDocumento());
        e.setNombre(getNombre());
        e.setRegistradoBlog(isRegistradoBlog());
        e.setTipoDocumento(getTipoDocumento());
        e.setUsuario(getUsuario());
        return e;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param abono the abono to set
     */
    public void setAbono(Integer abono) {
        this.abono = abono;
    }

    /**
     * @return the registradoBlog
     */
    public Boolean getRegistradoBlog() {
        return registradoBlog;
    }

    /**
     * @param registradoBlog the registradoBlog to set
     */
    public void setRegistradoBlog(Boolean registradoBlog) {
        this.registradoBlog = registradoBlog;
    }


    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the abono
     */
    public Integer getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(int abono) {
        this.setAbono((Integer) abono);
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the registradoBlog
     */
    public Boolean isRegistradoBlog() {
        return getRegistradoBlog();
    }

    /**
     * @param registradoBlog the registradoBlog to set
     */
    public void setRegistradoBlog(boolean registradoBlog) {
        this.setRegistradoBlog((Boolean) registradoBlog);
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
