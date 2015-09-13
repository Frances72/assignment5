package RMate.conf.factory;

import RMate.domain.Cycler;

/**
 * Created by User on 2015/09/13.
 */
public class CyclerFactory {
    public static Cycler createCycler (String first, String last, int age){
        Cycler cycler = new Cycler.Builder(first).last(last).age(age).build();
        return cycler;
    }

//    CyclerFactory.createCycler()
}

