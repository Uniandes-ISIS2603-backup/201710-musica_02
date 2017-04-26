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
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author p.salazar12
 */
@RunWith(Arquillian.class)
public class EntradaPersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addPackage(EntradaEntity.class.getPackage()).addPackage(EntradaPersistence.class.getPackage()).addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     @Inject
    private EntradaPersistence EntradaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<EntradaEntity> data = new ArrayList<EntradaEntity>();
    
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
        em.createQuery("delete from EntradaEntity").executeUpdate();
    }
    private void insertData() {
         PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EntradaEntity entity = factory.manufacturePojo(EntradaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class EntradaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        EntradaEntity expResult = null;
        EntradaEntity result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EntradaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        List<EntradaEntity> expResult = null;
        List<EntradaEntity> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCliente method, of class EntradaPersistence.
     */
    @Test
    public void testFindByCliente() throws Exception {
        System.out.println("findByCliente");
        String usuario = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        List<EntradaEntity> expResult = null;
        List<EntradaEntity> result = instance.findByCliente(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByFuncion method, of class EntradaPersistence.
     */
    @Test
    public void testFindByFuncion() throws Exception {
        System.out.println("findByFuncion");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        List<EntradaEntity> expResult = null;
        List<EntradaEntity> result = instance.findByFuncion(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class EntradaPersistence.
     */
    @Test
    public void testGetCliente() throws Exception {
        System.out.println("getCliente");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        ClienteEntity expResult = null;
        ClienteEntity result = instance.getCliente(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class EntradaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntradaEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        EntradaEntity expResult = null;
        EntradaEntity result = instance.create(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EntradaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        EntradaEntity entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        EntradaEntity expResult = null;
        EntradaEntity result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EntradaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EntradaPersistence instance = (EntradaPersistence)container.getContext().lookup("java:global/classes/EntradaPersistence");
        instance.delete(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
