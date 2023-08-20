package oaigptconnector.fcclient.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

import java.util.List;

@FunctionCall(name = "bus_schedule", functionDescription = "Generates a bus schedule for a town bus route")
public class SimpleFunctionCall {

    @FCParameter(name = "route_name", description = "The name of the route")
    private String routeName;

    @FCParameter(name = "length_in_miles", description = "The length of the route in miles")
    private Integer routeLength;

    @FCParameter(description = "List of arrivals for the current day")
    private List<String> arrivals;

    public SimpleFunctionCall() {

    }

    public SimpleFunctionCall(String routeName, Integer routeLength, List<String> arrivals) {
        this.routeName = routeName;
        this.routeLength = routeLength;
        this.arrivals = arrivals;
    }

    public String getRouteName() {
        return routeName;
    }

    public Integer getRouteLength() {
        return routeLength;
    }

    public List<String> getArrivals() {
        return arrivals;
    }

}
