package RMate.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by User on 2015/09/13.
 */
public class CyclerDomTest  {
    @Test
    public void testCreate() throws Exception{

        Cycler cycler = new Cycler.Builder("John").last("Edwards").age(39).build();

        Assert.assertEquals("John", cycler.getFirst());
        Assert.assertEquals("Edwards",cycler.getLast());
        Assert.assertEquals(39,cycler.getAge());

    }

    @Test
    public void update() throws Exception{
        Cycler cycler = new Cycler.Builder("Sasha").last("Grey").age( 23).build();

        Cycler newcycler = new Cycler.Builder(cycler.getFirst()).last(cycler.getLast()).age(24).build();
        Assert.assertEquals("Sasha",newcycler.getFirst());
        Assert.assertEquals("Grey",newcycler.getLast());
        Assert.assertEquals(24, newcycler.getAge());

    }
}

