package RMate.conf.factory;

import RMate.domain.Chip;
import RMate.domain.Cycler;
import RMate.domain.Reader;
import RMate.domain.Reading;

import java.util.Date;

/**
 * Created by User on 2015/09/13.
 */
public class ReadingFactory {
    public static Reading createReading(Chip chip, Cycler cycler, Reader reader, Date readTime){
        Reading reading = new Reading.Builder(chip).cycler(cycler).reader(reader).readTime(readTime).build();
        return reading;

    }
}
