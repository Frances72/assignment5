package RMate.services;

import RMate.domain.Cycler;

import java.util.List;

/**
 * Created by User on 2015/09/13.
 */
public interface CyclerService {
    List<Cycler> getAllCyclers();
    void createCycler(Cycler Entity);
    void  updateCycler(Cycler Entity);
    Cycler findCycler(Long Id);
    void deleteCycler(Long Id);
    void deleteCycler(Cycler Entity);

}