package az.amirashad.trains.graph;

import az.amirashad.assessment.exception.NoSuchRouteException;
import az.amirashad.assessment.filter.MaxStopsPathFilter;
import az.amirashad.assessment.filter.MaxWeightPathFilter;
import az.amirashad.assessment.graph.Edge;
import az.amirashad.assessment.graph.Graph;
import az.amirashad.assessment.graph.GraphBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void initGraph() {
        graph = GraphBuilder.buildGraphFromCLI(new String[]{"Graph:", "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void addVertexShouldNotAllowNullValues() {
        graph.addVertex(null);
    }

    @Test
    public void addVertexShouldNotAllowDuplicates() {

        assertTrue(graph.addVertex("Z"));
        assertTrue(graph.getAllVertex().contains("Z"));


        assertFalse(graph.addVertex("Z"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeShouldFailWhenVertexDoesNotExist() {
        graph.addEdge("X", "A", 1);
    }

    @Test
    public void addEdgeShouldUpdateWeightIfDuplicate() {
        graph.addVertex("Z");
        assertTrue(graph.addEdge("Z", "A", 5));
        assertThat(graph.getEdge("Z", "A").getWeight(), is(equalTo(5)));

        assertTrue(graph.addEdge("Z", "A", 15));
        assertThat(graph.getEdge("Z", "A").getWeight(), is(equalTo(15)));
    }

    @Test
    public void testGetEdge() {
        graph.addVertex("Z");
        graph.addEdge("A", "Z", 15);
        final Edge azEdge = graph.getEdge("A", "Z");

        assertThat(azEdge.getStartingVertex(), is(equalTo("A")));
        assertThat(azEdge.getEndingVertex(), is(equalTo("Z")));
        assertThat(azEdge.getWeight(), is(equalTo(15)));


        assertNull(graph.getEdge("Z", "B"));
    }

    @Test
    public void testGetAllEdges() {
        assertTrue(graph.getAllVertex().toString().equals(Arrays.asList("A", "B", "C", "D", "E").toString()));
    }

    @Test(expected = NoSuchRouteException.class)
    public void getAllPathsShouldThrowExceptionWhenNoPathExists() {

        graph.getAllPaths("A", "B", new MaxWeightPathFilter(3));
    }

    @Test
    public void testGetAllPaths() {


        assertTrue(graph.getAllPaths("A", "D", new MaxStopsPathFilter(3)).size() == 3);


        assertTrue(graph.getAllPaths("A", "D", new MaxStopsPathFilter(2)).size() == 1);
    }

}
