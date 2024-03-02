package klg.backend.lukasz.tenant;

import klg.backend.lukasz.tenant.Tenant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends ListCrudRepository<Tenant, Long> {
}
