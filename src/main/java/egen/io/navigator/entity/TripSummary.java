package egen.io.navigator.entity;

import lombok.Data;

@Data
public class TripSummary {
    private String name;
    private String display_name;
    private String street_number;
    private String street_name;
    private String city;
    private String state;
    private String country;
}
