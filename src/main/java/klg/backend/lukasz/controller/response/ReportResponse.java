package klg.backend.lukasz.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {

    private Set<String> tenants = new HashSet<>();
    private HashMap<String, PropertyReport> propertyReport = new HashMap();
    private Integer numOfProperties = 0;
    private Double profit = 0.0;

    public void addToProfit(Double value) {
        profit += value;
    }

    public void addToTenants(String name) {
        tenants.add(name);
    }

    public PropertyReport getEntry(String name) {
        if (propertyReport.get(name) == null) {
            propertyReport.put(name, new PropertyReport());
        }

        return propertyReport.get(name);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PropertyReport {
        private Integer guests = 0;
        private Double profit = 0.0;

        public void addToGuests(Integer value) {
            guests += value;
        }

        public void addToProfit(Double value) {
            profit += value;
        }
    }
}
