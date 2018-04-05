package az.amirashad.assessment.command;

import az.amirashad.assessment.Commuter;

public class MaxWeightCommand implements Command {

    private String fromCity;
    private String toCity;
    private int maxWeight;

    public MaxWeightCommand(String fromCity, String toCity, int maxWeight) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.maxWeight = maxWeight;
    }

    @Override
    public Object execute(Commuter commuter) {
        return commuter.numberOfPathsWithMaxWeight(fromCity, toCity, maxWeight);
    }
}
