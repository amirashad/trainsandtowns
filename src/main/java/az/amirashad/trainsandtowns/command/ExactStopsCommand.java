package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;

public class ExactStopsCommand implements Command {

    private String fromCity;
    private String toCity;
    private int exactStops;

    public ExactStopsCommand(String fromCity, String toCity, int exactStops) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.exactStops = exactStops;
    }

    public static ExactStopsCommand buildFromCLI(String command) {
        String exactStops = command.split(",")[0];
        String[] cities = command.split(",")[1].split("-");
        return new ExactStopsCommand(cities[0], cities[1], Integer.valueOf(exactStops));
    }

    @Override
    public Object execute(Commuter commuter) {
        try {
            return commuter.numberOfPathsWithExactStops(fromCity, toCity, exactStops);
        } catch (NoSuchRouteException ex) {
            return "NO SUCH ROUTE";
        }
    }
}
