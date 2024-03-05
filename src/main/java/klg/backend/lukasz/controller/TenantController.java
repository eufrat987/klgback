package klg.backend.lukasz.controller;

import com.fasterxml.jackson.annotation.JsonView;
import klg.backend.lukasz.controller.view.View;
import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tenants")
public class TenantController {

    @Autowired
    TenantService tenantService;

    @GetMapping
    @JsonView(View.Internal.class)
    ResponseEntity<List<Tenant>> getTenants() {
        return new ResponseEntity<>(tenantService.getTenants(), HttpStatus.OK);
    }

    @PostMapping
    @JsonView(View.Internal.class)
    ResponseEntity<Tenant> createProperty(@RequestBody Tenant tenant) {
        return new ResponseEntity<>(tenantService.createTenant(tenant), HttpStatus.OK);
    }

}
