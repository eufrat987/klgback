package klg.backend.lukasz.controller.request;

import klg.backend.lukasz.model.Landlord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandlordRequest {
    @NonNull
    private String name;

    public Landlord map() {
        return new Landlord(name);
    }
}
