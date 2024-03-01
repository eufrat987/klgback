package klg.backend.lukasz.repository;

import klg.backend.lukasz.examples.Customer;
import klg.backend.lukasz.model.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
