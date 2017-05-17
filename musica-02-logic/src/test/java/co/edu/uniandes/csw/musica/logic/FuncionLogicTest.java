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

import co.edu.uniandes.csw.musica.ejbs.FuncionLogic;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.entities.EntradaEntity;
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.entities.FuncionEntity;
import co.edu.uniandes.csw.musica.entities.ReviewEntity;
import co.edu.uniandes.csw.musica.entities.VenueEntity;
import co.edu.uniandes.csw.musica.persistence.FuncionPersistence;
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
public class FuncionLogicTest {
   
    private PodamFactory factory = new PodamFactoryImpl();
   @Inject
    private FuncionLogic funcionLogic;

    @PersistenceContext(unitName = "musicaPU")
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
    private List<FuncionEntity> data = new ArrayList<>(); 
    
    
    private List<EntradaEntity> entradaData = new ArrayList<>();
    
    private List<ArtistaEntity> artistasData = new ArrayList<>();
    private List<ReviewEntity> reviewsData = new ArrayList<>();
    private FestivalEntity festivalesData = new FestivalEntity();
    private VenueEntity venuesData = new VenueEntity();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FuncionEntity.class.getPackage())
                .addPackage(FuncionLogic.class.getPackage())
                .addPackage(FuncionPersistence.class.getPackage())
                .addPackage(VenueEntity.class.getPackage())
                .addPackage(FestivalEntity.class.getPackage())
                .addPackage(ReviewEntity.class.getPackage())
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(EntradaEntity.class.getPackage())
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
        em.createQuery("delete from EntradaEntity").executeUpdate();
        em.createQuery("delete from VenueEntity").executeUpdate();
        em.createQuery("delete from ReviewEntity").executeUpdate();
        em.createQuery("delete from ArtistaEntity").executeUpdate();
        em.createQuery("delete from FuncionEntity").executeUpdate();
        em.createQuery("delete from FestivalEntity").executeUpdate();
    }
    
    private void insertData(){
       festivalesData= factory.manufacturePojo(FestivalEntity.class);
        festivalesData.setId(1L);
        em.persist(festivalesData);
        
        venuesData = factory.manufacturePojo(VenueEntity.class);
        venuesData.setId(1L);
        em.persist(venuesData);
        for(int i = 0; i<3;i++){
            EntradaEntity entradas = factory.manufacturePojo(EntradaEntity.class);
            em.persist(entradas);
            entradaData.add(entradas);
        }
        for(int i = 0; i<3; i++){
            ReviewEntity entity = factory.manufacturePojo(ReviewEntity.class);
            em.persist(entity);
            reviewsData.add(entity);
        }
        for(int i =0; i<3 ;i++){
            ArtistaEntity artista = factory.manufacturePojo(ArtistaEntity.class);
            em.persist(artista);
            artistasData.add(artista);
        }
        for (int i =0; i<3;i++){
            FuncionEntity funcion = factory.manufacturePojo(FuncionEntity.class);
            funcion.setArtistas(artistasData);
            funcion.setEntradas(entradaData);
            funcion.setReviews(reviewsData);
            funcion.setVenueEntity(venuesData);
            funcion.setFestivalEntity(festivalesData);
            data.add(funcion);  
        }
    }
    
    @Test
    public void createFuncionTest(){
        FuncionEntity newEntity = factory.manufacturePojo(FuncionEntity.class);
        FuncionEntity result = funcionLogic.createFuncion(newEntity);
        Assert.assertNotNull(result);
        FuncionEntity entity = em.find(FuncionEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    @Test
    public void getFuncionesTest(){
        List<FuncionEntity> list = funcionLogic.getFunciones();
        Assert.assertEquals(data.size(), list.size());
        for(FuncionEntity entity: list){
            boolean found = false;
            for(FuncionEntity storedEntity: data){
                if(entity.getId().equals(storedEntity.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    @Test
    public void getFuncionTest() throws Exception{
        FuncionEntity entity = data.get(0);
        FuncionEntity resultEntity = funcionLogic.getFuncion(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        
    }
    @Test
    public void deleteFuncionTest(){
     FuncionEntity entity = data.get(0);
     funcionLogic.deleteFuncion(entity.getId());
     FuncionEntity deleted = em.find(FuncionEntity.class, entity.getId());
     Assert.assertNull(deleted);
    }
    @Test
    public void updateFuncionTest(){
        FuncionEntity entity = data.get(0);
        FuncionEntity pojoEntity = factory.manufacturePojo(FuncionEntity.class);
        pojoEntity.setId(entity.getId());
        funcionLogic.updateFuncion(pojoEntity);
        FuncionEntity resp = em.find(FuncionEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }
    
    public FuncionLogicTest() {
    }
    
}
