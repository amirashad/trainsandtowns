package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;

public class ShortestDistanceCommand implements Command {

    private String fromCity;
    private String toCity;

    public ShortestDistanceCommand(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public static ShortestDistanceCommand buildFromCLI(String command) {
        return new ShortestDistanceCommand(
                String.valueOf(command.charAt(0)),
                String.valueOf(command.charAt(2)));
    }

    @Override
    public Object execute(Commuter commuter) {
        try {
            return commuter.shortestDistance(fromCity, toCity);
        } catch (NoSuchRouteException ex) {
            return "NO SUCH ROUTE";
        }
    }
}
