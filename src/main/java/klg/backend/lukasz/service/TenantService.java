package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TenantService {
    @Autowired
    TenantRepository tenantRepository;


    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }


    public Tenant createProperty(@RequestBody Tenant tenant) {
        return tenantRepository.save(tenant);
    }

}
