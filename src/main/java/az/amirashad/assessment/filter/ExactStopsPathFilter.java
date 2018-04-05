package az.amirashad.assessment.filter;

import az.amirashad.assessment.graph.Path;

public class ExactStopsPathFilter implements PathFilter {
    private final int hopsNumber;

    public ExactStopsPathFilter(final int hopsNumber) {
        super();
        this.hopsNumber = hopsNumber;
    }

    @Override
    public boolean passFilter(final Path path) {
        return path.getNumberOfHops() == hopsNumber;
    }

}
