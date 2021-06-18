package main.controller;

import main.Services.RestService;
import main.Services.vehicleService;
import main.model.Rest;
import main.model.vehicle;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RestService restService;

    @Autowired
    private  vehicleService vehicleService;

    @GetMapping("/rest")
    public List<Rest> getRList() {
        return restService.getRList();
    }

    @GetMapping("/vehicle")
    public vehicle getvehicle()
    {
        return vehicleService.getvehicle();
    }

    @GetMapping("/rest/{id}")
    public Rest getrest(@PathVariable String id)
    {
        return restService.getrest(id);
    }

   @PostMapping("/rest")
    public void addRest(@RequestBody Rest rest)
    {
       restService.addRest(rest);
    }

    @PutMapping("/rest/{id}")
    public void updateRest(@RequestBody Rest rest, @PathVariable String id)
    {
        restService.updateRest(rest, id);
        System.out.print("hello_controller class");
    }

    @DeleteMapping("/rest/{id}")
    public void deleteRest(@PathVariable String id)
    {
        restService.deleteRest(id);
    }


}

