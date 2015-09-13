package RMate.repository;

import RMate.App;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by User on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CyclerCrudTest extends AbstractTestNGSpringContextTests {
/*
    private Long id;
    private String first;
    private String last;
    private int age;

    @Autowired
    private CyclerRepository repository;

       @Test
        public void create() throws Exception{
           Cycler cycler = new Cycler.Builder("Maddy").last("Laine").age(33).build();
            repository.save(cycler);
            id=cycler.getCyclerID();
            Assert.assertNotNull(cycler.getCyclerID());

        }



        @Test(dependsOnMethods = "create")
        public void read ()throws Exception {
            Cycler cycler = repository.findOne(id);
            Assert.assertNotNull(cycler.getCyclerID());

        }

        @Test(dependsOnMethods = "read")
        public void update ()throws Exception {
            Cycler cycler = repository.findOne(id);
            Cycler newCycler = new Cycler.Builder("Sarah"). last("Lee").age(43).build();
            repository.save(newCycler);
            Cycler updatedCycler = repository.findOne(id);
            Assert.assertEquals("Lee",newCycler.getLast());


        }

        @Test(dependsOnMethods = "update")
        public void delete ()throws Exception {
            Cycler cycler = repository.findOne(id);
            repository.delete(cycler);
            Cycler deletedCycler = repository.findOne(id);
            Assert.assertNull(deletedCycler);


        }*/


}


