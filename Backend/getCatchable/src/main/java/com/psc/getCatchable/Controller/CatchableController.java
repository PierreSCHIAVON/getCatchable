package com.psc.getCatchable.Controller;

import com.psc.getCatchable.Entity.Catchable;
import com.psc.getCatchable.Repositories.CatchablesRepository;
import com.psc.getCatchable.Services.CatchableItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/catchables")
@RestController
@CrossOrigin(origins = "*")

public class CatchableController {

    @Autowired
    private CatchablesRepository catchableRepository;
    @Autowired
    private CatchableItemService catchableItemService;


    @PostMapping
    public void createCatchable(@RequestBody Catchable catchable){catchableRepository.save(catchable);}

    @GetMapping
    public List<Catchable> getcatchables(){return catchableRepository.findAll();}


    @GetMapping(path = "{id}")
    public Optional<Catchable> getcatchable(@PathVariable ("id")Long id){return catchableRepository.findById(id);}

    @GetMapping("/catchablenow")
    public List<Catchable> getFilteredCatchableItems() {
        List<Catchable> allCatchables = catchableRepository.findAll();
        return catchableItemService.getFilteredItems(allCatchables);
    }


    @PutMapping
    public void updateCatchable(@RequestBody Catchable catchable){catchableRepository.save(catchable);}

    @DeleteMapping(path = "{id}")
    public void deleteCatchable(@PathVariable("id")Long id){catchableRepository.deleteById(id);}


}
