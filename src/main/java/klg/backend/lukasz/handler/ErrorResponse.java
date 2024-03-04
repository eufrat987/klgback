package klg.backend.lukasz.handler;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponse {

    @NonNull
    String message;

    @NonNull
    String type;

    public ErrorResponse(@NonNull RuntimeException ex) {
        this.message = ex.getMessage();
        this.type = ex.getClass().getTypeName();
    }
}
