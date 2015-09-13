package RMate.conf.factory;

import RMate.domain.Reader;

/**
 * Created by User on 2015/09/13.
 */
public class ReaderFactory {
    public static Reader createReader(Double distance){
        Reader reader = new Reader.Builder(distance).build();
        return reader;
    }
}
