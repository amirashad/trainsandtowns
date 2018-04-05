package az.amirashad.trainsandtowns;

import az.amirashad.trainsandtowns.filter.*;
import az.amirashad.trainsandtowns.graph.Edge;
import az.amirashad.trainsandtowns.graph.Graph;
import az.amirashad.trainsandtowns.graph.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Commuter {
    private final Graph routes;

    public Commuter(final Graph routes) {
        this.routes = routes;
    }

    public int numberOfPathsWithExactStops(final String startingCity, final String destinationCity, final int stops) {
        final List<Path> paths = routes.getAllPaths(startingCity, destinationCity, new MaxStopsPathFilter(stops));
        final List<Path> exactPaths = new ArrayList<>();

        final PathFilter exactFilter = new ExactStopsPathFilter(stops);
        for (final Path each : paths) {
            if (exactFilter.passFilter(each)) {
                exactPaths.add(each);
            }
        }

        return exactPaths.size();
    }

    public int numberOfPathsWithMaxStops(final String startingCity, final String destinationCity, final int stops) {
        return routes.getAllPaths(startingCity, destinationCity, new MaxStopsPathFilter(stops)).size();
    }

    public int numberOfPathsWithMaxWeight(final String startingCity, final String destinationCity, final int weight) {
        return routes.getAllPaths(startingCity, destinationCity, new MaxWeightPathFilter(weight)).size();
    }

    public int shortestDistance(final String startingCity, final String destinationCity) {
        final List<Path> allPaths = routes.getAllPaths(startingCity, destinationCity, new RepeatedEdgePathFilter());
        return Collections.min(allPaths).getPathTotalWeight();
    }

    public int routeDistance(final String... nodes) {
        final Path objectivePath = Path.emptyPath();

        for (int i = 1; i < nodes.length; i++) {
            objectivePath.addEdge(new Edge(nodes[i - 1], nodes[i], 0));
        }

        final List<Path> allPaths = routes.getAllPaths(nodes[0], nodes[nodes.length - 1], new ContainsPathFilter(objectivePath));

        return allPaths.get(0).getPathTotalWeight();
    }

}
