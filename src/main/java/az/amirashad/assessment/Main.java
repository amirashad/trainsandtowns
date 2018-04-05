package az.amirashad.assessment;

import az.amirashad.assessment.command.*;
import az.amirashad.assessment.graph.Graph;
import az.amirashad.assessment.graph.GraphBuilder;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase(GraphBuilder.CLI_GRAPH_TEXT)) {
            System.out.println("Command is not valid.\n\tUsage: java -jar trains.jar Graph: AB2 BC1 CD4");
            return;
        }

        final Graph graph = GraphBuilder.buildGraphFromCLI(args);
        final Commuter commuter = new Commuter(graph);
        System.out.println("Output #1: " + new DistanceCommand("A", "B", "C").execute(commuter));
        System.out.println("Output #2: " + new DistanceCommand("A", "D").execute(commuter).toString());
        System.out.println("Output #3: " + new DistanceCommand("A", "D", "C").execute(commuter).toString());
        System.out.println("Output #4: " + new DistanceCommand("A", "E", "B", "C", "D").execute(commuter).toString());
        System.out.println("Output #5: " + new DistanceCommand("A", "E", "D").execute(commuter).toString());

        System.out.println("Output #6: " + new MaxStopsCommand("C", "C", 3).execute(commuter).toString());
        System.out.println("Output #7: " + new ExactStopsCommand("A", "C", 4).execute(commuter).toString());
        System.out.println("Output #8: " + new ShortestDistanceCommand("A", "C").execute(commuter).toString());
        System.out.println("Output #9: " + new ShortestDistanceCommand("B", "B").execute(commuter).toString());
        System.out.println("Output #10: " + new MaxWeightCommand("C", "C", 30).execute(commuter).toString());
    }

}