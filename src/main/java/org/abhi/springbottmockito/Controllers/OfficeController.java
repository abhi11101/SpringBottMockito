package org.abhi.springbottmockito.Controllers;

import org.abhi.springbottmockito.Entity.Office;
import org.abhi.springbottmockito.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office/")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("findAll")
    public List<Office> findAll(){
        return officeService.findAll();
    }

    @GetMapping("findAll/{episode}")
    public Office findByEpisode(@PathVariable int episode){
        return officeService.findByEpisode(episode);
    }

    @PostMapping("saveOffice")
    public Office saveOffice(@RequestBody Office office){
        return officeService.saveEpisode(office);
    }

    @PutMapping("updateOffice")
    public Office updateOffice(@RequestBody Office office){
        return officeService.updateEpisode(office);
    }
    @DeleteMapping("deleteOffice/{episode}")
    public void deleteOffice(@PathVariable int episode){
        officeService.deleteEpisode(episode);
    }

}
