package RMate.conf.factory;

import RMate.domain.Chip;
import RMate.domain.Cycler;

/**
 * Created by User on 2015/09/13.
 */
public class ChipFactory {
    public static Chip createChip(Cycler cycler){
        Chip chip = new Chip.Builder(cycler).build();
        return chip;
    }
}
