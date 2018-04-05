package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;

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
        try {
            return commuter.numberOfPathsWithMaxWeight(fromCity, toCity, maxWeight);
        } catch (NoSuchRouteException ex) {
            return "NO SUCH ROUTE";
        }
    }
}
