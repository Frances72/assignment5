package RMate.services;

import RMate.domain.Chip;

import java.util.List;

/**
 * Created by User on 2015/09/13.
 */
public interface ChipService {
    List<Chip> getAllChips();
    void createChip(Chip Entity);
    void  updateChip(Chip Entity);
    Chip findChip(Long Id);
    void deleteChip(Long Id);
    void deleteChip(Chip Entity);
}

