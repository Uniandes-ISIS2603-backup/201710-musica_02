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
package co.edu.uniandes.csw.musica.logic;

import co.edu.uniandes.csw.musica.ejbs.CancionLogic;
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import co.edu.uniandes.csw.musica.persistence.CancionPersistence;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a.echeverrir
 */
@RunWith(Arquillian.class)
public class CancionLogicTest {
    
   @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CancionEntity.class.getPackage())
                .addPackage(CancionLogic.class.getPackage())
                .addPackage(CancionPersistence.class.getPackage())
                .addPackage(DiscoEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CancionLogic cancionLogic;
    PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    
    @Inject
    UserTransaction utx;

    private List<CancionEntity> data = new ArrayList<>();
    private DiscoEntity discoData = new DiscoEntity(); 

    @Before
     public void setUp(){
        try{
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        }catch(Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from DiscoEntity").executeUpdate();
        em.createQuery("delete from ArtistaEntity").executeUpdate();
        em.createQuery("delete from CancionEntity").executeUpdate();
    }

    private void insertData() {
    
        discoData = factory.manufacturePojo(DiscoEntity.class);
        discoData.setId(1L);
        em.persist(discoData);
        
        for (int i = 0; i < 3; i++) {
            CancionEntity cancion = factory.manufacturePojo(CancionEntity.class);
            cancion.setDiscoEntity(discoData);
            data.add(cancion);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of findAll method, of class CancionPersistence.
     */
    @Test
    public void testGetCanciones() throws Exception {
        List<CancionEntity> list = cancionLogic.getCanciones(discoData.getId());
        Assert.assertEquals(data.size(), list.size());
        for (CancionEntity ent : list) {
            boolean found = false;
            for (CancionEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class DiscoPersistence.
     */
    @Test
    public void testCreateCancion() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        CancionEntity newEntity = factory.manufacturePojo(CancionEntity.class);

        CancionEntity result = cancionLogic.createCancion(newEntity);

        Assert.assertNotNull(result);
        CancionEntity entity = em.find(CancionEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getDuracion(), newEntity.getDuracion());
    }
    
    
    
    
    
}
