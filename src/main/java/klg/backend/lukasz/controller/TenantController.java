package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tenants")
public class TenantController {

    @Autowired
    TenantRepository tenantRepository;

    @GetMapping
    List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }

    @PostMapping
    Tenant createProperty(@RequestBody Tenant tenant) {
        return tenantRepository.save(tenant);
    }

}
