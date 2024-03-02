package klg.backend.lukasz.tenant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TenantService {
    @Autowired
    TenantRepository tenantRepository;


    public List<Tenant> getTenants() {
        log.info("TenantService:getTenants started.");
        List<Tenant> tenants = tenantRepository.findAll();
        log.info("TenantService:getTenants ended.");
        return tenants;
    }


    public Tenant createTenant(Tenant tenant) {
        log.info("TenantService:createTenant started.");
        Tenant savedTenant = tenantRepository.save(tenant);
        log.info("TenantService:createTenant ended.");
        return savedTenant;
    }

}
