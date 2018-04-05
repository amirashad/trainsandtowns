package az.amirashad.assessment.filter;

import az.amirashad.assessment.graph.Path;

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
