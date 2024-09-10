package com.psc.getCatchable.Controller;

import com.psc.getCatchable.Entity.Catchable;
import com.psc.getCatchable.Entity.CatchableType;
import com.psc.getCatchable.Repositories.CatchablesRepository;
import com.psc.getCatchable.Services.CatchableItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("")
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CatchableController {

    @Autowired
    private CatchablesRepository catchableRepository;
    @Autowired
    private CatchableItemService catchableItemService;


    @PostMapping
    public void createCatchable(@RequestBody Catchable catchable){catchableRepository.save(catchable);}

    @GetMapping("/allcatchableitems")
    public List<Catchable> getcatchables(){return catchableRepository.findAll();}


    @GetMapping(path = "{id}")
    public Optional<Catchable> getcatchable(@PathVariable ("id")Long id){return catchableRepository.findById(id);}

    @GetMapping("/catchablenow")
    public List<Catchable> getFilteredCatchableItems() {
        List<Catchable> allCatchables = catchableRepository.findAll();
        return catchableItemService.getFilteredItems(allCatchables);
    }

    @GetMapping("/fishes")
    public List<Catchable> getFishes() {
        return catchableRepository.findByType(CatchableType.FISH);
    }

    @GetMapping("/bugs")
    public List<Catchable> getBugsList() {
        return catchableRepository.findByType(CatchableType.BUG);
    }


    @GetMapping("/seacreatures")
    public List<Catchable> getSeaCreatures() {
        return catchableRepository.findByType(CatchableType.SEA_CREATURE);
    }


    @PutMapping
    public void updateCatchable(@RequestBody Catchable catchable){catchableRepository.save(catchable);}

    @DeleteMapping(path = "{id}")
    public void deleteCatchable(@PathVariable("id")Long id){catchableRepository.deleteById(id);}


}
