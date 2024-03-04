package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Tenant;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TenantService {
    public List<Tenant> getTenants();
    public Tenant createProperty(Tenant tenant);
}
