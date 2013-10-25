package ru.ecmsolutions.test.common;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 25.10.13
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = "classpath:/WEB-INF/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class InitTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveTest() throws Exception {
        Assert.assertNotNull(entityManager);
    }


}
