package za.ac.cput.controller;
/*
Jody Heideman 219307725
CountryController.java
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.address.Country;
import za.ac.cput.service.address.ICountryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school/country/")
@Slf4j
public class CountryController {

    private final ICountryService iCountryService;

    @Autowired
    public CountryController( ICountryService iCountryService){
        this.iCountryService = iCountryService;
    }
    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        log.info("Save request: {}", country);
        Country saved = iCountryService.save(country);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        Country country = this.iCountryService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
        return ResponseEntity.ok(country);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Save request: {}", id);
        this.iCountryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countryList = this.iCountryService.findAll();
        return ResponseEntity.ok(countryList);
    }

}
