package az.amirashad.assessment.command;

import az.amirashad.assessment.Commuter;

public class ExactStopsCommand implements Command {

    private String fromCity;
    private String toCity;
    private int exactStops;

    public ExactStopsCommand(String fromCity, String toCity, int exactStops) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.exactStops = exactStops;
    }

    @Override
    public Object execute(Commuter commuter) {
        return commuter.numberOfPathsWithExactStops(fromCity, toCity, exactStops);
    }
}