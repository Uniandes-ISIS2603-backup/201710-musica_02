/*
 * The MIT License
 *
 * Copyright 2017 ca.anzola.
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

import co.edu.uniandes.csw.musica.entities.CiudadEntity;
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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ca.anzola
 */
@RunWith(Arquillian.class)
public class CiudadPersistenceTest 
{
    
    @Deployment
    public static JavaArchive createDeployment() 
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CiudadEntity.class.getPackage())
                .addPackage(CiudadPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CiudadPersistence ciudadPersistance;
    
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<CiudadEntity> data = new ArrayList<>();
    
    @Before
    public void setUp() throws Exception
    {
        try 
        {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
                fail("Configuration database fail");
            }
        }
    }
    
    private void clearData() 
    {
        em.createQuery("delete from CiudadEntity").executeUpdate();
    }
    
    private void insertData() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) 
        {
            CiudadEntity entity = factory.manufacturePojo(CiudadEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createCiudadTest() 
    {
        PodamFactory factory = new PodamFactoryImpl();
        CiudadEntity newEntity = factory.manufacturePojo(CiudadEntity.class);

        CiudadEntity result = ciudadPersistance.create(newEntity);
        Assert.assertNotNull(result);
        CiudadEntity entity = em.find(CiudadEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    @Test
    public void getCiudadesTest() 
    {
        List<CiudadEntity> list = ciudadPersistance.finAll();
        Assert.assertEquals(data.size(), list.size());
        for (CiudadEntity ent : list) 
        {
            boolean found = false;
            for (CiudadEntity entity : data) 
            {
                if (ent.getId().equals(entity.getId())) 
                {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getCiudadTest() 
    {
        CiudadEntity entity = data.get(0);
        CiudadEntity newEntity = ciudadPersistance.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    @Test
    public void updateCiudadTest() 
    {
        CiudadEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CiudadEntity newEntity = factory.manufacturePojo(CiudadEntity.class);

        newEntity.setId(entity.getId());

        ciudadPersistance.update(newEntity);

        CiudadEntity resp = em.find(CiudadEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
//    @Test
//    public void deleteCiudadTest() 
//    {
//        CiudadEntity entity = data.get(0);
//        ciudadPersistance.delete(entity.getName());
//        CiudadEntity deleted = em.find(CiudadEntity.class, entity.getId());
//        Assert.assertNull(deleted);
//    }
//    
//    @Test
//    public void getCiudadByNameTest() 
//    {
//        CiudadEntity entity = data.get(0);
//        CiudadEntity newEntity = ciudadPersistance.findByName(entity.getName());
//        Assert.assertNotNull(newEntity);
//        Assert.assertEquals(entity.getName(), newEntity.getName());
//        Assert.assertEquals(newEntity.getId(), entity.getId());
//    }
    
    public CiudadPersistenceTest() 
    {
        
    }
    
}
