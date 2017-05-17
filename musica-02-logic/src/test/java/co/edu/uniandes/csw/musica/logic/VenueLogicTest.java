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
package co.edu.uniandes.csw.musica.logic;

import co.edu.uniandes.csw.musica.ejbs.VenueLogic;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import co.edu.uniandes.csw.musica.persistence.VenuePersistence;
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

/**
 *
 * @author ca.anzola
 */
@RunWith(Arquillian.class)
public class VenueLogicTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VenueEntity.class.getPackage())
                .addPackage(VenueLogic.class.getPackage())
                .addPackage(VenuePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private VenueLogic venueLogic;
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;
    @Inject
    UserTransaction utx;

    private List<VenueEntity> data = new ArrayList<>();

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
        em.createQuery("delete from VenueEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            VenueEntity venue = factory.manufacturePojo(VenueEntity.class);
            em.persist(venue);
            data.add(venue);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of find method, of class FestivalPersistence.
     */
    @Test
    public void testGetVenue() throws Exception {
        VenueEntity entity = data.get(0);
        VenueEntity newEntity = venueLogic.getVenue(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getCapacidadMax(), newEntity.getCapacidadMax());
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
        Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
        Assert.assertEquals(entity.getMapa(), newEntity.getMapa());
        Assert.assertEquals(entity.getImagen(), newEntity.getImagen());
    }

    /**
     * Test of findAll method, of class FestivalPersistence.
     */
    @Test
    public void testGetVenues() throws Exception {
        List<VenueEntity> list = venueLogic.getVenues();
        Assert.assertEquals(data.size(), list.size());
        for (VenueEntity ent : list) {
            boolean found = false;
            for (VenueEntity entity : data) {
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
    public void testCreateVenue() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        VenueEntity newEntity = factory.manufacturePojo(VenueEntity.class);

        VenueEntity result = venueLogic.createVenue(newEntity);

        Assert.assertNotNull(result);
        VenueEntity entity = em.find(VenueEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(entity.getCapacidadMax(), newEntity.getCapacidadMax());
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
        Assert.assertEquals(entity.getMapa(), newEntity.getMapa());
        Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
        Assert.assertEquals(entity.getImagen(), newEntity.getImagen());
    }

    /**
     * Test of update method, of class FestivalPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        VenueEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VenueEntity newEntity = factory.manufacturePojo(VenueEntity.class);

        newEntity.setId(entity.getId());

        venueLogic.updateVenue(newEntity);

        VenueEntity resp = em.find(VenueEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(resp.getCapacidadMax(), newEntity.getCapacidadMax());
        Assert.assertEquals(resp.getDireccion(), newEntity.getDireccion());
        Assert.assertEquals(resp.getMapa(), newEntity.getMapa());
        Assert.assertEquals(resp.getTipo(), newEntity.getTipo());
        Assert.assertEquals(resp.getImagen(), newEntity.getImagen());
    }

    
}
