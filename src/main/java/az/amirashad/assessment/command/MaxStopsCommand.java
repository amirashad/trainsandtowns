package az.amirashad.assessment.command;

import az.amirashad.assessment.Commuter;

public class MaxStopsCommand implements Command {

    private String fromCity;
    private String toCity;
    private int maxStops;

    public MaxStopsCommand(String fromCity, String toCity, int maxStops) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.maxStops = maxStops;
    }

    @Override
    public Object execute(Commuter commuter) {
        return commuter.numberOfPathsWithMaxStops(fromCity, toCity, maxStops);
    }
}
