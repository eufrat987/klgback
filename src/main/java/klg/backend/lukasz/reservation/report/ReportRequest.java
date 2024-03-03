package klg.backend.lukasz.reservation.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {

    private long id;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate start;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate end;

}
