package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Tenant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TenantService {
    public List<Tenant> getTenants();
    public Tenant createTenant(Tenant tenant);
}
