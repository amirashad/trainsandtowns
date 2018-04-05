package az.amirashad.trainsandtowns.filter;

import az.amirashad.trainsandtowns.graph.Path;

public class MaxWeightPathFilter implements PathFilter {
    private final int maxWeight;

    public MaxWeightPathFilter(final int maxWeight) {
        super();
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean passFilter(final Path path) {
        return path.getPathTotalWeight() < maxWeight;
    }

}
