package az.amirashad.trainsandtowns.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EdgeTest {
    private final Edge edge = new Edge("A", "B", 15);

    @Test
    public void equalShouldNotConsiderWeight() {
        final Edge edgeWithDifferentWeight = new Edge("A", "B", 5);
        assertTrue(edgeWithDifferentWeight.equals(edge));

        final Edge differentEdge = new Edge("B", "C", 5);
        assertFalse(differentEdge.equals(edge));
    }

}
