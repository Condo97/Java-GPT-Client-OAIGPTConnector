package oaigptconnector.fcclient.testobjects;

import com.oaigptconnector.model.JSONSchemaParameter;

import java.util.List;

public class ComplexFunctionCallRoute {

    @JSONSchemaParameter(name = "route_name", description = "The name of the route")
    private String routeName;

    @JSONSchemaParameter(name = "length_in_miles", description = "The length of the route in miles")
    private Integer routeLength;

    @JSONSchemaParameter(description = "List of arrivals for the current day")
    private List<String> arrivals;

    public ComplexFunctionCallRoute() {

    }

    public ComplexFunctionCallRoute(String routeName, Integer routeLength, List<String> arrivals) {
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