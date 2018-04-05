package az.amirashad.trainsandtowns.filter;

import az.amirashad.trainsandtowns.graph.Path;

public class MaxStopsPathFilter implements PathFilter {
    private final int maxHops;

    public MaxStopsPathFilter(final int maxHops) {
        super();
        this.maxHops = maxHops;
    }

    @Override
    public boolean passFilter(final Path path) {
        return path.getNumberOfHops() <= maxHops;
    }

}
