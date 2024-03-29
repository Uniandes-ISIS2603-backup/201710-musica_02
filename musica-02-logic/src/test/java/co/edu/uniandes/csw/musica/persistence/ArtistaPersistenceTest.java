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

package co.edu.uniandes.csw.musica.persistence;

import org.junit.Test;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


import static org.junit.Assert.*;

/**
 *
 * @author a.echeverrir
 */
@RunWith(Arquillian.class)
public class ArtistaPersistenceTest {
    
    
    
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private ArtistaPersistence artistaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;

    private List<ArtistaEntity> data = new ArrayList<ArtistaEntity>();

    @Before
    public void setUp()
    {
        try 
        {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try 
            {
                utx.rollback();
            } 
            catch (Exception e1) 
            {
                e1.printStackTrace();
            }
        }
    }
    
    
     /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from ArtistaEntity").executeUpdate();
        em.createQuery("delete from DiscoEntity").executeUpdate();
        em.createQuery("delete from CancionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ArtistaEntity entity = factory.manufacturePojo(ArtistaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Artista.
     */
    @Test
    public void createArtistaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ArtistaEntity newEntity = factory.manufacturePojo(ArtistaEntity.class);

        ArtistaEntity result = artistaPersistence.create(newEntity);

        Assert.assertNotNull(result);
        ArtistaEntity entity = em.find(ArtistaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }
    
    /**
     * Prueba para consultar la lista de Artistas.
     *
     */
    @Test
    public void getArtistasTest() {
        List<ArtistaEntity> list = artistaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ArtistaEntity ent : list) {
            boolean found = false;
            for (ArtistaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Artista.
     */
    @Test
    public void getArtistaTest() {
        ArtistaEntity entity = data.get(0);
        ArtistaEntity newEntity = artistaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }
    
    /**
     * Prueba para eliminar un Artista.
     */
    @Test
    public void deleteArtistaTest() {
        ArtistaEntity entity = data.get(0);
        artistaPersistence.delete(entity.getId());
        ArtistaEntity deleted = em.find(ArtistaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Artista.
     */
    @Test
    public void updateArtistaTest() {
        ArtistaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ArtistaEntity newEntity = factory.manufacturePojo(ArtistaEntity.class);

        newEntity.setId(entity.getId());

        artistaPersistence.update(newEntity);

        ArtistaEntity resp = em.find(ArtistaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }
    
    
}
