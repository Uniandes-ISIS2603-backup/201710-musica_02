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

import co.edu.uniandes.csw.musica.ejbs.ClienteLogic;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.persistence.ClientePersistence;
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
public class ClienteLogicTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private ClienteLogic clienteLogic;
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    @Inject
    private UserTransaction utx;
    private List<ClienteEntity> data = new ArrayList<>();

    public ClienteLogicTest() {
    }

    /**
     * Test of getClientes method, of class ClienteLogic.
     */
    @Test
    public void testGetClientes() throws Exception {
    }

    /**
     * Test of updateCliente method, of class ClienteLogic.
     */
    @Test
    public void testUpdateCliente() throws Exception {
    }

    /**
     * Test of deleteCliente method, of class ClienteLogic.
     */
    @Test
    public void testDeleteCliente() throws Exception {
    }

    /**
     * Test of createCliente method, of class ClienteLogic.
     */
    @Test
    public void testCreateCliente() throws Exception {
    }

    /**
     * Test of getAbonados method, of class ClienteLogic.
     */
    @Test
    public void testGetAbonados() throws Exception {
    }

    /**
     * Test of getById method, of class ClienteLogic.
     */
    @Test
    public void testGetById() throws Exception {
    }

    /**
     * Test of getByUsuario method, of class ClienteLogic.
     */
    @Test
    public void testGetByUsuario() throws Exception {
    }
    
}
