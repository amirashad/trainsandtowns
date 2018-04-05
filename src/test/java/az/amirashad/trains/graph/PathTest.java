package az.amirashad.trains.graph;

import az.amirashad.assessment.graph.Edge;
import az.amirashad.assessment.graph.Path;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PathTest {
    private final Edge abEdge = new Edge("A", "B", 5);
    private final Edge bcEdge = new Edge("B", "C", 15);
    private final Edge cdEdge = new Edge("C", "D", 5);
    private Path path;

    @Before
    public void initPath() {
        path = Path.emptyPath();
        path.addEdge(abEdge);
        path.addEdge(bcEdge);
        path.addEdge(cdEdge);
    }

    @Test
    public void addEdgeShouldIncreaseWeightAndHops() {
        final Edge newEdge = new Edge("D", "E", 5);
        path.addEdge(newEdge);

        assertThat(path.getPathTotalWeight(), is(equalTo(30)));
        assertThat(path.getNumberOfHops(), is(equalTo(4)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeShouldFailWhenEdgeIsNotConsecutive() {

        final Edge nonConsecutiveEdge = new Edge("E", "A", 1);
        path.addEdge(nonConsecutiveEdge);
    }

    @Test
    public void getPathTotalWeightShouldEqualEdgesSum() {
        assertThat(path.getPathTotalWeight(), is(equalTo(25)));
    }

    @Test
    public void getNumberOfHopsShouldEqualEdgeNumber() {
        assertThat(path.getNumberOfHops(), is(equalTo(3)));
    }

    @Test
    public void getLastNodeShouldReturnLastEdgeEndingVertex() {
        assertThat(path.getLastNode(), is(equalTo("D")));
    }

    @Test
    public void getLastNodeWhenPathIsEmptyShouldReturnNull() {
        path = Path.emptyPath();
        assertThat(path.getLastNode(), is(nullValue()));
    }

    @Test
    public void removeLastEdgeShouldDecreaseWeightAndHops() {
        path.removeLastEdge();

        assertThat(path.getPathTotalWeight(), is(equalTo(20)));
        assertThat(path.getNumberOfHops(), is(equalTo(2)));
    }


    @Test
    public void testHasRepeatedEdges() {

        assertFalse(path.hasRepeatedEdges());


        final Edge daEdge = new Edge("D", "A", 5);
        path.addEdge(daEdge);
        path.addEdge(abEdge);
        assertTrue(path.hasRepeatedEdges());
    }

    @Test
    public void testCompareTo() {

        final Path otherPath = Path.copyPath(path);
        assertEquals(otherPath.compareTo(path), 0);


        final Edge daEdge = new Edge("D", "A", 5);
        otherPath.addEdge(daEdge);
        assertTrue(otherPath.compareTo(path) > 0);
        assertTrue(path.compareTo(otherPath) < 0);

    }

}
