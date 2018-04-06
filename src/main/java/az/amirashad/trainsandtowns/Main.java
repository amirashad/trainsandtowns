package az.amirashad.trainsandtowns;

import az.amirashad.trainsandtowns.command.*;
import az.amirashad.trainsandtowns.graph.Graph;
import az.amirashad.trainsandtowns.graph.GraphBuilder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase(GraphBuilder.CLI_GRAPH_TEXT)) {
            System.out.println("Command is not valid.\n\tUsage: java -jar trainsandtowns.jar Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
            return;
        }

        final Graph graph = GraphBuilder.buildFromCLI(args);
        final Commuter commuter = new Commuter(graph);

        while (true) {
            try {
                System.out.println("********************TRAINS*AND*TOWNS**************************\n" +
                        "Type one of the following:\n" +
                        "\t1) To measure distance type 1 from keyboard and press enter\n" +
                        "\t2) To find number of trips (with max stops) type 2 from keyboard and press enter\n" +
                        "\t3) To find number of trips (with exact stops) type 3 from keyboard and press enter\n" +
                        "\t4) To find number of different routes (with max distance) type 4 from keyboard and press enter\n" +
                        "\t5) To find shortest path type 5 from keyboard and press enter\n" +
                        "\t6) To run default scenario type 6 from keyboard and press enter\n" +
                        "\t0) To exit type 0 from keyboard and press enter" +
                        "");

                Scanner scanner = new Scanner(System.in);
                int commandType = scanner.nextInt();
                Command command = null;
                switch (commandType) {
                    case 1:
                        System.out.println("Type towns you want to measure distance (e.g: A-B-C): ");
                        command = DistanceCommand.buildFromCLI(scanner.next());
                        break;
                    case 2:
                        System.out.println("Type max stops count, starting and ending cities (e.g: 3,C-C): ");
                        command = MaxStopsCommand.buildFromCLI(scanner.next());
                        break;
                    case 3:
                        System.out.println("Type exact stops count, starting and ending cities (e.g: 3,C-C): ");
                        command = ExactStopsCommand.buildFromCLI(scanner.next());
                        break;
                    case 4:
                        System.out.println("Type max weight, starting and ending cities (e.g: 3,C-C): ");
                        command = MaxWeightCommand.buildFromCLI(scanner.next());
                        break;
                    case 5:
                        System.out.println("Type starting and ending cities (e.g: A-C): ");
                        command = ShortestDistanceCommand.buildFromCLI(scanner.next());
                        break;
                    case 6:
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
                        break;
                    case 0:
                        System.out.println("Thanks for using our service! Good bye!");
                        System.exit(0);
                    default:
                        throw new Exception();
                }

                System.out.println("Output: " + command.execute(commuter));
            } catch (Exception ex) {
                System.out.println("Something went wrong, Please, try again.");
            }
        }
    }

}
