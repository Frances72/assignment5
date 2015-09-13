package RMate.services.impl;

import RMate.domain.Chip;
import RMate.repository.ChipRepository;
import RMate.services.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/13.
 */
@Service
public class ChipServiceImpl implements ChipService {
    @Autowired
    ChipRepository repository;


    public List<Chip> getAllChips() {
        List<Chip> allChips = new ArrayList<Chip>();

        Iterable<Chip> chips = repository.findAll();
        for(Chip chip:chips){
            allChips.add(chip);
        }
        return allChips;
    }



    public void createChip(Chip Entity){}
    public void  updateChip(Chip Entity){}
    public Chip findChip(Long Id){
        Chip  chip = repository.findOne(Id);
        return chip;
    }
    public void deleteChip(Long Id){}
    public void deleteChip(Chip Entity){}
}

