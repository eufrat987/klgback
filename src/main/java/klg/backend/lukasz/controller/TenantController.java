package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tenants")
public class TenantController {

    @Autowired
    TenantRepository tenantRepository;

    @GetMapping
    ResponseEntity<List<Tenant>> getTenants() {
        return new ResponseEntity<>(tenantRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Tenant> createProperty(@RequestBody Tenant tenant) {
        return new ResponseEntity<>(tenantRepository.save(tenant), HttpStatus.OK);
    }

}
