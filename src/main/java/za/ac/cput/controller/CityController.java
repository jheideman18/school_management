package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.address.City;
import za.ac.cput.service.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school/city/")
@Slf4j
public class CityController {

    private final ICityService iCityService;

    @Autowired
    public CityController( ICityService iCityService){
        this.iCityService = iCityService;
    }
    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city){
        log.info("Save request: {}", city);
        City saved = iCityService.save(city);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id){
        City city = this.iCityService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));
        return ResponseEntity.ok(city);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Save request: {}", id);
        this.iCityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findCountryID/{countryId}")
    public ResponseEntity<List<City>> findByCountryId(@PathVariable String countryId){
        log.info("Save request: {}", countryId);
        List<City> cityList = this.iCityService.findByCountryId(countryId);
        return ResponseEntity.ok(cityList);
    }
    @GetMapping("findAll")
    public ResponseEntity<List<City>> findAll(){
        //log.info("Save request: {}", city);
        List<City> cityList = this.iCityService.findAll();
        return ResponseEntity.ok(cityList);
    }

}
