/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.employee.dtos;

import co.edu.uniandes.csw.employee.entities.EmployeeEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class EmployeeDTO  implements Serializable{

    private Long id;
    private String name;
    private Double salary;
    private String image;
    private Integer gender;


    /**
     * @generated
     */
    public EmployeeDTO() {
    }

    /**
     * Crea un objeto EmployeeDTO a partir de un objeto EmployeeEntity.
     *
     * @param entity Entidad EmployeeEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public EmployeeDTO(EmployeeEntity entity) {
	   if (entity!=null){
        this.id=entity.getId();
        this.name=entity.getName();
        this.salary=entity.getSalary();
        this.image=entity.getImage();
        this.gender=entity.getGender();
       }
    }

    /**
     * Convierte un objeto EmployeeDTO a EmployeeEntity.
     *
     * @return Nueva objeto EmployeeEntity.
     * @generated
     */
    public EmployeeEntity toEntity() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setSalary(this.getSalary());
        entity.setImage(this.getImage());
        entity.setGender(this.getGender());
    return entity;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo name.
     *
     * @return atributo name.
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del atributo name.
     *
     * @param name nuevo valor del atributo
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el atributo salary.
     *
     * @return atributo salary.
     * @generated
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Establece el valor del atributo salary.
     *
     * @param salary nuevo valor del atributo
     * @generated
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Obtiene el atributo image.
     *
     * @return atributo image.
     * @generated
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece el valor del atributo image.
     *
     * @param image nuevo valor del atributo
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Obtiene el atributo gender.
     *
     * @return atributo gender.
     * @generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * Establece el valor del atributo gender.
     *
     * @param gender nuevo valor del atributo
     * @generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }


}
