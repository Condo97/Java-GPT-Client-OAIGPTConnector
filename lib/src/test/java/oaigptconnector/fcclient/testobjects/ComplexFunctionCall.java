package oaigptconnector.fcclient.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

import java.util.List;

@FunctionCall(name = "train_schedule", functionDescription = "Generates a train schedule for multiple town train routes")
public class ComplexFunctionCall {

    @FCParameter(name = "city_name", description = "The name of the city the train is in")
    private String cityName;

    @FCParameter(description = "The sub routes the train will take")
    private List<ComplexFunctionCallRoute> subroutes;

    @FCParameter(name = "main_route", description = "The main route the train will take")
    private ComplexFunctionCallRoute mainRoute;

    @FCParameter(name = "all_train_numbers", description = "List of all train numbers")
    private List<Integer> allTrainNumbers;

//    @FCParameter()

    public ComplexFunctionCall() {

    }

    public ComplexFunctionCall(String cityName, List<ComplexFunctionCallRoute> subroutes, ComplexFunctionCallRoute mainRoute, List<Integer> allTrainNumbers) {
        this.cityName = cityName;
        this.subroutes = subroutes;
        this.mainRoute = mainRoute;
        this.allTrainNumbers = allTrainNumbers;
    }

    public String getCityName() {
        return cityName;
    }

    public List<ComplexFunctionCallRoute> getSubroutes() {
        return subroutes;
    }

    public ComplexFunctionCallRoute getMainRoute() {
        return mainRoute;
    }

    public List<Integer> getAllTrainNumbers() {
        return allTrainNumbers;
    }

}
