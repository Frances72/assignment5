package RMate.repository;

import RMate.App;
import RMate.conf.factory.ChipFactory;
import RMate.domain.Chip;
import RMate.domain.Cycler;
import RMate.domain.Reader;
import RMate.domain.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by User on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ReadingCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ReadingRepository repository;

    private Long id;
    private Chip chip;
    private Cycler cycler;
    private Reader reader;
    private Date readTime;



    @Test
    public void create() throws Exception{

        Reader reader = new Reader.Builder(9.99).build();
        Cycler cycler = new Cycler.Builder("ReadingCrud").last("Test").age(99).build();
        Chip chip = ChipFactory.createChip(cycler);


        Reading reading = new Reading.Builder(chip).cycler(cycler).reader(reader).readTime(new Date()).build();
        repository.save(reading);
        id = reading.getReadingId();
        Assert.assertNotNull(id);
        System.out.println("This is inside the create for Reading test");
    }
    @Test(dependsOnMethods = "create")
    public void read ()throws Exception {
        Reading reading = repository.findOne(id);
        Assert.assertNotNull(reading.getReadingId());
        System.out.println("This is inside the read for Reading test");
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Reader reader = new Reader.Builder(3.35).build();
        Cycler cycler = new Cycler.Builder("Reading").last("Update").age(21).build();
        Chip chip = ChipFactory.createChip(cycler);
        Reading reading = repository.findOne(id);
        Reading readings = new Reading.Builder(chip).cycler(chip.getCyclerID()).reader(reader).readTime(new Date()).build();
        repository.save(reading);
        Reading updatedReading = repository.findOne(id);
        Assert.assertNotNull(updatedReading);
        System.out.println("This is inside the update for Reading test");


    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {

        System.out.println("This is inside the delete for Reading test");
    }
}
