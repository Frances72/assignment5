package RMate.api;

import RMate.domain.Chip;
import RMate.model.ChipResource;
import RMate.services.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/13.
 */
@RestController
@RequestMapping("/chip/**")
public class ChipPage {
    @Autowired
    private ChipService service;

    @RequestMapping(value = "chipdisplay",method = RequestMethod.GET)
    public List<ChipResource> chipdisplay() {
        List<ChipResource> hateos = new ArrayList<>();
        List<Chip> chips = service.getAllChips();
        for(Chip chip: chips){
            ChipResource res = new ChipResource
                    .Builder(chip.getCyclerID())
                    .resid(chip.getChipID())
                    .build();
            Link cycler = new Link("http://localhost:8183/chip/" + res.getResid()
                    .toString()).withRel("cycler");
            res.add(cycler);
            hateos.add(res);
        }

        return hateos;
    }


    @RequestMapping(value = "getchip/{id}",method = RequestMethod.GET)
    public Chip getChips(@PathVariable Long id) {
        System.out.println("hit api" + id);
        Chip chips = service.findChip(id);
        return chips;
    }
}


