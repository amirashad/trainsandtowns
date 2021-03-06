package az.amirashad.trainsandtowns.exception;

public class NoSuchRouteException extends RuntimeException {

    public NoSuchRouteException(final String startingVertex, final String endingVertex) {
        super("No route exists between " + startingVertex + " and " + endingVertex);
    }
}
