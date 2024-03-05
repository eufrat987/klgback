package klg.backend.lukasz.controller.request;

import klg.backend.lukasz.model.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyReqeust {
    @NonNull
    private String name;
    @NonNull
    private Double unitPrice;
    @NonNull
    private Integer surface;
    @NonNull
    private String description;

    public Property map() {
        return new Property(name, unitPrice, surface, description);
    }
}
