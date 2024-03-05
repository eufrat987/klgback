package klg.backend.lukasz.controller.request;

import klg.backend.lukasz.model.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    @NonNull
    private String name;

    public Tenant map() {
        return new Tenant(name);
    }
}
