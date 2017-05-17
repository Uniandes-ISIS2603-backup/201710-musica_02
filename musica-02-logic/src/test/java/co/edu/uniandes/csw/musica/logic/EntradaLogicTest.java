/*
 * The MIT License
 *
 * Copyright 2017 p.salazar12.
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
package co.edu.uniandes.csw.musica.logic;

import co.edu.uniandes.csw.musica.ejbs.EntradaLogic;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.persistence.EntradaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author p.salazar12
 */
@RunWith(Arquillian.class)
public class EntradaLogicTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntradaEntity.class.getPackage())
                .addPackage(EntradaLogic.class.getPackage())
                .addPackage(EntradaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private EntradaLogic entradaLogic;
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<EntradaEntity> data = new ArrayList<>();

    
    public EntradaLogicTest() {
    }

    /**
     * Test of getEntradas method, of class EntradaLogic.
     */
    @Test
    public void testGetEntradas() throws Exception {
    }

    /**
     * Test of createEntrada method, of class EntradaLogic.
     */
    @Test
    public void testCreateEntrada() throws Exception {
    }

    /**
     * Test of getByCliente method, of class EntradaLogic.
     */
    @Test
    public void testGetByCliente() throws Exception {
    }

    /**
     * Test of getByFuncion method, of class EntradaLogic.
     */
    @Test
    public void testGetByFuncion() throws Exception {
    }

    /**
     * Test of getCliente method, of class EntradaLogic.
     */
    @Test
    public void testGetCliente() throws Exception {
    }
    
}
