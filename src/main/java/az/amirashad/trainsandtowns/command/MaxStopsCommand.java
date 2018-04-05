package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;

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
        try {
            return commuter.numberOfPathsWithMaxStops(fromCity, toCity, maxStops);
        } catch (NoSuchRouteException ex) {
            return "NO SUCH ROUTE";
        }
    }
}
