package az.amirashad.trains;

import az.amirashad.trainsandtowns.Commuter;
import az.amirashad.trainsandtowns.exception.NoSuchRouteException;
import az.amirashad.trainsandtowns.graph.GraphBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CommuterTest {
    private final String[] graphArgs = new String[]{"Graph:", "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
    private final Commuter commuter = new Commuter(GraphBuilder.buildGraphFromCLI(graphArgs));

    @Test
    public void distanceForABCShouldBe9() {
        Assert.assertEquals("The distance for the route A-B-C should be 9", 9,
                commuter.routeDistance(Arrays.asList("A", "B", "C")));
    }

    @Test
    public void distanceForADShouldBe5() {
        assertEquals("The distance for the route A-D should be 5", 5,
                commuter.routeDistance(Arrays.asList("A", "D")));
    }

    @Test
    public void distanceForADCShouldBe13() {
        assertEquals("The distance for the route A-D-C should be 13", 13,
                commuter.routeDistance("A", "D", "C"));
    }

    @Test
    public void distanceForAEBCDShouldBe22() {
        assertEquals("The distance for the route A-B-C should be 22", 22,
                commuter.routeDistance("A", "E", "B", "C", "D"));
    }

    @Test(expected = NoSuchRouteException.class)
    public void distanceForAEDShouldThrowNoSuchRouteException() {
        commuter.routeDistance("A", "E", "D");
    }

    @Test
    public void numberOfTripsBetweenCAndCWithMax3StopsShouldBe2() {
        assertEquals("There should be 2 trips between C and C with a maximum of 3 stops", 2,
                commuter.numberOfPathsWithMaxStops("C", "C", 3));
    }

    @Test
    public void numberOfTripsBetweenAAndCWith4StopsShouldBe3() {
        assertEquals("There should be 3 trips between A and C with exactly 4 stops", 3,
                commuter.numberOfPathsWithExactStops("A", "C", 4));
    }

    @Test
    public void shortestDistanceFromAtoCShouldBe9() {
        assertEquals("The shortest distance from A to C should be 9", 9, commuter.shortestDistance("A", "C"));
    }

    @Test
    public void shortestDistanceFromBtoBShouldBe9() {
        assertEquals("The shortest distance from B to B should be 9", 9, commuter.shortestDistance("B", "B"));
    }

    @Test
    public void numberOfRoutesBetweenCAndCShouldBe7() {
        assertEquals("There should be 7 routes between C and C with a distance less than 30", 7,
                commuter.numberOfPathsWithMaxWeight("C", "C", 30));
    }


}
