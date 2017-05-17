/*
 * The MIT License
 *
 * Copyright 2017 af.olivares10.
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
/**
 *
 * @author af.olivares10
 */
package co.edu.uniandes.csw.musica.persistence;

import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class FestivalPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FestivalEntity.class.getPackage())
                .addPackage(FestivalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private FestivalPersistence festivalPersistence;
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    @Inject
    UserTransaction utx;

    private List<FestivalEntity> data = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            try {
                utx.rollback();

            } catch (Exception e1) {
                e.printStackTrace();
                fail("Configuration database fail");
            }

        }
    }

    private void clearData() {
        em.createQuery("delete from FestivalEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            FestivalEntity fest = factory.manufacturePojo(FestivalEntity.class);
            em.persist(fest);
            data.add(fest);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of find method, of class FestivalPersistence.
     */
    @Test
    public void testFind() throws Exception {
        FestivalEntity entity = data.get(0);
        FestivalEntity newEntity = festivalPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getFechaInicio().getDay(), newEntity.getFechaInicio().getDay());
        Assert.assertEquals(entity.getFechaInicio().getMonth(), newEntity.getFechaInicio().getMonth());
        Assert.assertEquals(entity.getFechaInicio().getYear(), newEntity.getFechaInicio().getYear());
        Assert.assertEquals(entity.getFechaFin().getDay(), newEntity.getFechaFin().getDay());
        Assert.assertEquals(entity.getFechaFin().getMonth(), newEntity.getFechaFin().getMonth());
        Assert.assertEquals(entity.getFechaFin().getYear(), newEntity.getFechaFin().getYear());
        Assert.assertEquals(entity.getImagen(), newEntity.getImagen());
    }

    /**
     * Test of findAll method, of class FestivalPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<FestivalEntity> list = festivalPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (FestivalEntity ent : list) {
            boolean found = false;
            for (FestivalEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class FestivalPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        FestivalEntity newEntity = factory.manufacturePojo(FestivalEntity.class);

        FestivalEntity result = festivalPersistence.create(newEntity);

        Assert.assertNotNull(result);
        FestivalEntity entity = em.find(FestivalEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(entity.getFechaInicio().getDay(), newEntity.getFechaInicio().getDay());
        Assert.assertEquals(entity.getFechaInicio().getMonth(), newEntity.getFechaInicio().getMonth());
        Assert.assertEquals(entity.getFechaInicio().getYear(), newEntity.getFechaInicio().getYear());
        Assert.assertEquals(entity.getFechaFin().getDay(), newEntity.getFechaFin().getDay());
        Assert.assertEquals(entity.getFechaFin().getMonth(), newEntity.getFechaFin().getMonth());
        Assert.assertEquals(entity.getFechaFin().getYear(), newEntity.getFechaFin().getYear());
        Assert.assertEquals(entity.getImagen(), newEntity.getImagen());
    }

    /**
     * Test of update method, of class FestivalPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        FestivalEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        FestivalEntity newEntity = factory.manufacturePojo(FestivalEntity.class);

        newEntity.setId(entity.getId());

        festivalPersistence.update(newEntity);

        FestivalEntity resp = em.find(FestivalEntity.class, entity.getId());

        Assert.assertEquals(resp.getNombre(), newEntity.getNombre());
        Assert.assertEquals(resp.getFechaInicio().getDay(), newEntity.getFechaInicio().getDay());
        Assert.assertEquals(resp.getFechaInicio().getMonth(), newEntity.getFechaInicio().getMonth());
        Assert.assertEquals(resp.getFechaInicio().getYear(), newEntity.getFechaInicio().getYear());
        Assert.assertEquals(resp.getFechaFin().getDay(), newEntity.getFechaFin().getDay());
        Assert.assertEquals(resp.getFechaFin().getMonth(), newEntity.getFechaFin().getMonth());
        Assert.assertEquals(resp.getFechaFin().getYear(), newEntity.getFechaFin().getYear());
        Assert.assertEquals(resp.getImagen(), newEntity.getImagen());
    }

}
