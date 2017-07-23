package egen.io.navigator.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Trip {
    public String url;
    public String id;
    public String driver;
    public String user;
    public String started_at;
    public String ended_at;
    public String vehicle;
    public Double distance_m;
    public Double duration_s;
    public Map<String, Double> start_location = new HashMap<>();
    public Map<String, Double> end_location = new HashMap<>();
    public Map<String, String> start_address = new HashMap<>();
    public Map<String, String> end_address = new HashMap<>();
    public String path;
    public Double fuel_cost_usd;
    public Double fuel_volume_l;
    public Double average_kmpl;
    public Double average_from_epa_kmpl;
    public Double score_events;
    public Double score_speeding;
    public Integer hard_brakes;
    public Integer hard_accels;
    public Double duration_over_70_s;
    public Double duration_over_75_s;
    public Double duration_over_80_s;
    public List<Object> vehicle_events = new ArrayList<Object>();
    public String start_timezone;
    public String end_timezone;
    public Double city_fraction;
    public Double highway_fraction;
    public Double night_driving_fraction;
    public Double idling_time_s;
    public List<String> tags = new ArrayList<String>();
}
