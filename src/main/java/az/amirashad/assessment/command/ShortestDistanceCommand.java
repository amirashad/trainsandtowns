package az.amirashad.assessment.command;

import az.amirashad.assessment.Commuter;

public class ShortestDistanceCommand implements Command {

    private String fromCity;
    private String toCity;

    public ShortestDistanceCommand(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    @Override
    public Object execute(Commuter commuter) {
        return commuter.shortestDistance(fromCity, toCity);
    }
}
