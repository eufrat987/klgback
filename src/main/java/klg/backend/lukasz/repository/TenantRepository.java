package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Tenant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends ListCrudRepository<Tenant, Long> {
}
