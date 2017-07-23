package egen.io.navigator.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Vehicle {

    public String id;

    public String name;

    public String url;

    public String vin;

    public String created_at;

    public String updated_at;

    public String make;

    public String model;

    public String year;

    public String submodel;

    public String display_name;

    public String fuel_grade;

    public Double fuel_level_percent;

    public Double battery_voltage;

    public List<Active_dtcs> active_dtcs = new ArrayList<>();

    public static class Active_dtcs {
        private String code;
        private Date created_at;
        private String description;
    }
}
