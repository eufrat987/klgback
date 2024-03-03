package klg.backend.lukasz.property.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate start;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate end;

}