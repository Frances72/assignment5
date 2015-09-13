package RMate.repository;

import RMate.App;
import RMate.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ReaderCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private Double distance;

    @Autowired
    private ReaderRepository repository;

    @Test
    public void create() throws Exception{
        Reader reader = new Reader.Builder(5.05).build();
        repository.save(reader);
        id = reader.getReaderId();
        Assert.assertNotNull(reader.getReaderId());
    }



    @Test(dependsOnMethods = "create")
    public void read ()throws Exception {
        Reader reader= repository.findOne(id);
        Assert.assertNotNull(reader.getReaderId());

    }



    //struggling to find out why the update method doesn't work
    @Test(dependsOnMethods = "read")
    public void update ()throws Exception {
        Reader reader = repository.findOne(id);
        Reader newReader = new Reader.Builder(7.8).build();
        repository.save(newReader);
        id = newReader.getReaderId();
        Reader updatedReader = repository.findOne(id);
        Assert.assertEquals(7.2, updatedReader.getDistance());


    }

/*
   @Test(dependsOnMethods = "update")

    public void delete ()throws Exception {
        Reader reader = repository.findOne(id);
        repository.delete(reader);
        Reader deletedReader = repository.findOne(id);
        Assert.assertNull(deletedReader);


    }
*/

}


