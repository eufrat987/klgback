package klg.backend.lukasz.service.impl;

import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.TenantRepository;
import klg.backend.lukasz.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    TenantRepository tenantRepository;

    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }

    public Tenant createProperty(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

}
