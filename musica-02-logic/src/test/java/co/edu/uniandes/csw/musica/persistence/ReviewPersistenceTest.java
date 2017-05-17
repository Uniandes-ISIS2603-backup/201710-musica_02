/*
 * The MIT License
 *
 * Copyright 2017 jd.gonzaleza.
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

import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
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
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jd.gonzaleza
 */
@RunWith(Arquillian.class)
public class ReviewPersistenceTest {
    
    @Deployment
    public static JavaArchive createDevelopment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReviewEntity.class.getPackage())
                .addPackage(ReviewPersistence.class.getPackage())
                .addPackage(ReviewEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
        
    }
    FuncionEntity fatherEntity;
    
    private List<ReviewEntity> reviewData = new ArrayList<>();
    
    @Inject
    private ReviewPersistence reviewPersistence;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserTransaction utx;
    @Before
    public void setUp(){
        try{
        utx.begin();
        em.joinTransaction();
        }catch(Exception e){
            try{
            utx.rollback();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        fatherEntity = factory.manufacturePojo(FuncionEntity.class);
        fatherEntity.setId(1L);
        em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            ReviewEntity entity = factory.manufacturePojo(ReviewEntity.class);
            entity.setFuncion(fatherEntity);
            reviewData.add(entity);
            em.persist(entity);
        }

    }
    
    private void clearData() {
        em.createQuery("delete  from ReviewEntity").executeUpdate();
        em.createQuery("delete  from FuncionEntity").executeUpdate();
    }
    @Test
    public void createReviewTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ReviewEntity newEntity = factory.manufacturePojo(ReviewEntity.class);
        newEntity.setFuncion(fatherEntity);
        ReviewEntity result = reviewPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ReviewEntity entity = em.find(ReviewEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    @Test
    public void findTest(){
        ReviewEntity entity = reviewData.get(0);
        ReviewEntity newEntity = reviewPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    @Test
    public void deleteTest(){
        ReviewEntity entity = reviewData.get(0);
        reviewPersistence.delete(entity.getId());
        ReviewEntity deleted = em.find(ReviewEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    @Test
    public void update(){
        ReviewEntity entity = reviewData.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReviewEntity newEntity = factory.manufacturePojo(ReviewEntity.class);
        
        newEntity.setId(entity.getId());
        
        reviewPersistence.update(newEntity);
        
        ReviewEntity resp = em.find(ReviewEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
    @Test
    public void findAllparaFuncion(){
        List<ReviewEntity> list = reviewPersistence.findAllparaFuncion(fatherEntity.getId());
        Assert.assertEquals(reviewData.size(), list.size());
        for(ReviewEntity ent : list){
            boolean found = false;
            for(ReviewEntity entity: reviewData){
                if(ent.getId().equals(entity.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    public ReviewPersistenceTest() {
    }

    @Test
    public void testSomeMethod() {
    }
    
}
