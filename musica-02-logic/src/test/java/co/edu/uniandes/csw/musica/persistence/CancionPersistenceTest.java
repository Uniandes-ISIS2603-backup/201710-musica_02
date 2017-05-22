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
import co.edu.uniandes.csw.musica.entities.CancionEntity;
import co.edu.uniandes.csw.musica.entities.DiscoEntity;
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
public class CancionPersistenceTest {
    
    
    
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CancionEntity.class.getPackage())
                .addPackage(CancionPersistence.class.getPackage())
                .addPackage(DiscoEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    DiscoEntity fatherEntity;
    
    private List<CancionEntity> cancionData = new ArrayList<CancionEntity>();
    
    @Inject
    private CancionPersistence cancionPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;

    

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
        fatherEntity = factory.manufacturePojo(DiscoEntity.class);
        fatherEntity.setId(1L);
        em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            CancionEntity entity = factory.manufacturePojo(CancionEntity.class);
            entity.setDiscoEntity(fatherEntity);
            cancionData.add(entity);
            em.persist(entity);
            
        }
    }
    
    /**
     * Prueba para crear una Cancion.
     */
    @Test
    public void createCancionTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CancionEntity newEntity = factory.manufacturePojo(CancionEntity.class);
        newEntity.setDiscoEntity(fatherEntity);
        CancionEntity result = cancionPersistence.create(newEntity);

        Assert.assertNotNull(result);
        CancionEntity entity = em.find(CancionEntity.class, result.getId());
        
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }
    
    /**
     * Prueba para consultar la lista de Discos.
     *
     */
    @Test
    public void getCancionesTest() {
        List<CancionEntity> list = cancionPersistence.findAll(fatherEntity.getId());
        Assert.assertEquals(cancionData.size(), list.size());
        for (CancionEntity ent : list) {
            boolean found = false;
            for (CancionEntity entity : cancionData) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
