package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Tenant;

import java.util.List;

public interface TenantService {
    public List<Tenant> getTenants();
    public Tenant createTenant(Tenant tenant);
}
