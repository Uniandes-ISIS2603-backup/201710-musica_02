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

import co.edu.uniandes.csw.musica.ejbs.DiscoLogic;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import co.edu.uniandes.csw.musica.persistence.DiscoPersistence;
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
 * @author a.echeverrir
 */
@RunWith(Arquillian.class)
public class DiscoLogicTest {
    
   /**
     *
     */
    ArtistaEntity fatherEntity;

    /**
     *
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     *
     */
    @Inject
    private DiscoLogic discoLogic;

    /**
     *
     */
    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    @Inject
    private UserTransaction utx;

    /**
     *
     */
    private List<DiscoEntity> discoData = new ArrayList<DiscoEntity>();

    /**
     *
     */
    private List<ArtistaEntity> artistaData = new ArrayList<>();

    /**
     *
     */
    private List<CancionEntity> cancionesData = new ArrayList<>();

    /**
     *
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DiscoEntity.class.getPackage())
                .addPackage(DiscoLogic.class.getPackage())
                .addPackage(DiscoPersistence.class.getPackage())
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(CancionEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from CancionEntity").executeUpdate();
        em.createQuery("delete from DiscoEntity").executeUpdate();
        em.createQuery("delete from ArtistaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            CancionEntity canciones = factory.manufacturePojo(CancionEntity.class);
            em.persist(canciones);
            cancionesData.add(canciones);
        }

        fatherEntity = factory.manufacturePojo(ArtistaEntity.class);
        fatherEntity.setId(1L);
        em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            DiscoEntity entity = factory.manufacturePojo(DiscoEntity.class);
            entity.setArtistaEntity(fatherEntity);
            em.persist(entity);
            discoData.add(entity);

            if (i == 0) {
                cancionesData.get(i).setDiscoEntity(entity);
            }
        }
    }

    /**
     * Prueba para crear un Disco
     *
     *
     */
    @Test
    public void createDiscoTest() throws Exception{
        DiscoEntity newEntity = factory.manufacturePojo(DiscoEntity.class);
        DiscoEntity result = discoLogic.createDisco(newEntity);
        Assert.assertNotNull(result);
        DiscoEntity entity = em.find(DiscoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
 
    /**
     * Prueba para consultar la lista de Discos
     *
     *
     */
    @Test
    public void getDiscosTest() {
        List<DiscoEntity> list = discoLogic.getDiscos(fatherEntity.getId());
        Assert.assertEquals(discoData.size(), list.size());
        for (DiscoEntity entity : list) {
            boolean found = false;
            for (DiscoEntity storedEntity : discoData) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}


