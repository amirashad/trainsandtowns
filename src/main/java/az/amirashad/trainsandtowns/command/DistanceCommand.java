package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;

import java.util.Arrays;
import java.util.List;

public class DistanceCommand implements Command {

    private String[] nodes;

    public DistanceCommand(String... nodes) {
        this.nodes = nodes;
    }

    public static DistanceCommand buildFromCLI(String command) {
        return new DistanceCommand(command.split("-"));
    }

    @Override
    public Object execute(Commuter commuter) {
        try {
            return commuter.routeDistance(nodes);
        } catch (NoSuchRouteException ex) {
            return "NO SUCH ROUTE";
        }
    }
}