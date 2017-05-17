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
package co.edu.uniandes.csw.musica.logic;

import co.edu.uniandes.csw.musica.ejbs.ReviewLogic;
import co.edu.uniandes.csw.musica.entities.ClienteEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import co.edu.uniandes.csw.musica.persistence.ReviewPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import junit.framework.Assert;
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
 * @author jd.gonzaleza
 */
@RunWith(Arquillian.class)
public class ReviewLogicTest {
    @Inject
    private ReviewLogic reviewLogic;
    private PodamFactory factory = new PodamFactoryImpl();
    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
    private List<ReviewEntity> reviewsData = new ArrayList<ReviewEntity>();
    private FuncionEntity funcionData = new FuncionEntity();
    private ClienteEntity clienteData = new ClienteEntity();
    
    @Deployment
    public static JavaArchive createDebelopment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReviewEntity.class.getPackage())
                .addPackage(ReviewLogic.class.getPackage())
                .addPackage(ReviewPersistence.class.getPackage())
                .addPackage(FuncionEntity.class.getPackage())
                .addPackage(ClienteEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
        
    }
    
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
    
    private void clearData(){
        em.createQuery("delete from ReviewEntity").executeUpdate();
        em.createQuery("delete from FuncionEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    private void insertData(){
        funcionData = factory.manufacturePojo(FuncionEntity.class);
        funcionData.setId(1L);
        em.persist(funcionData);
        
        clienteData = factory.manufacturePojo(ClienteEntity.class);
        clienteData.setUsuario("1");
        for(int i = 0; i<3; i++){
            ReviewEntity review = factory.manufacturePojo(ReviewEntity.class);
            review.setCliente(clienteData);
            review.setFuncion(funcionData);
            reviewsData.add(review);
        }
    }
    @Test
    public void createReviewTest(){
        ReviewEntity newEntity = factory.manufacturePojo(ReviewEntity.class);
        ReviewEntity result = reviewLogic.createReview(newEntity);
        Assert.assertNotNull(result);
        FuncionEntity entity = em.find(FuncionEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    @Test
    public void getReviewsTest(){
        List<ReviewEntity> list = reviewLogic.getReviews(funcionData.getId());
        Assert.assertEquals(reviewsData.size(), list.size());
        for(ReviewEntity entity: list){
            boolean found = false;
            for(ReviewEntity storedEntity: reviewsData){
                if(entity.getId().equals(storedEntity.getId())){
                    found = true;
                }
            }
             Assert.assertTrue(found);
        }
    }
    public ReviewLogicTest() {
    }
    
}
