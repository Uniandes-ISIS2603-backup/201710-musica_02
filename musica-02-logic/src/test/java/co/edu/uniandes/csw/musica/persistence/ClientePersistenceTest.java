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
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author p.salazar12
 */
@RunWith(Arquillian.class)
public class ClientePersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).
                addPackage(ClienteEntity.class.getPackage()).
                addPackage(ClientePersistence.class.getPackage()).
                addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    


    @Inject
    private ClientePersistence clientePersistence;
    
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<ClienteEntity> data = new ArrayList<>();
    
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }
    
    private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    private void insertData() {
         PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    

    /**
     * Test of findAll method, of class ClientePersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        List<ClienteEntity> expResult = null;
        List<ClienteEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ClientePersistence.
     */
    @Test
    public void testCreate() throws Exception {
//        System.out.println("create");
        ClienteEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        ClienteEntity expResult = null;
        ClienteEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientePersistence.
     */
    @Test
    public void testUpdate() throws Exception {
//        System.out.println("update");
        ClienteEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        ClienteEntity expResult = null;
        ClienteEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientePersistence.
     */
    @Test
    public void testDelete() throws Exception {
//        System.out.println("delete");
        String id = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        instance.delete(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findByUsuario method, of class ClientePersistence.
     */
    @Test
    public void testFindByUsuario() throws Exception {
//        System.out.println("findByUsuario");
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        ClienteEntity expResult = null;
        ClienteEntity result = instance.findByUsuario(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllAbonados method, of class ClientePersistence.
     */
    @Test
    public void testFindAllAbonados() throws Exception {
//        System.out.println("findAllAbonados");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientePersistence instance = (ClientePersistence)container.getContext().lookup("java:global/classes/ClientePersistence");
        List<ClienteEntity> expResult = null;
        List<ClienteEntity> result = instance.findAllAbonados();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
