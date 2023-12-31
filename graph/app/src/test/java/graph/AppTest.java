/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void addNode() {
        Graph graph = new Graph();

        graph.addVertex("Mohammad");
        graph.addVertex("Mohammad2");

        assertNotNull(graph.getVertices());
        assertEquals(2, graph.getVertices().size());
        assertTrue(graph.getVertices().contains(new Vertex("Mohammad")));
    }

    @Test
    public void addEdge() {
        Graph graph = new Graph();

        graph.addVertex("Mohammad");
        graph.addVertex("Mohammad2");

        graph.addEdge("Mohammad", "Mohammad2");

        assertNotNull(graph.getVertices());
        assertEquals(2, graph.getVertices().size());
        assertTrue(graph.getNeighbors("Mohammad").contains(new Vertex("Mohammad2")));
        assertTrue(graph.getNeighbors("Mohammad2").contains(new Vertex("Mohammad")));
    }

    @Test
    public void allNodes() {
        Graph graph = new Graph();

        graph.addVertex("Mohammad");
        graph.addVertex("Mohammad2");
        graph.addVertex("Mohammad3");

        assertEquals(3, graph.getVertices().size());
        assertTrue(graph.getVertices().contains(new Vertex("Mohammad")));
        assertTrue(graph.getVertices().contains(new Vertex("Mohammad2")));
        assertTrue(graph.getVertices().contains(new Vertex("Mohammad3")));
        assertFalse(graph.getVertices().contains(new Vertex("Mohammad4")));
    }

    @Test
    public void nodeNeighbors() {
        Graph graph = new Graph();

        graph.addVertex("Mohammad");
        graph.addVertex("Mohammad2");

        graph.addEdge("Mohammad", "Mohammad2");

        assertEquals(1, graph.getNeighbors("Mohammad").size());
        assertTrue(graph.getNeighbors("Mohammad").contains(new Vertex("Mohammad2")));
        assertTrue(graph.getNeighbors("Mohammad2").contains(new Vertex("Mohammad")));
    }

    @Test
    public void nodeNeighborsWeight() {
        Graph graph = new Graph();

        graph.addVertex("Mohammad");
        graph.addVertex("Mohammad2");
        graph.addVertex("Mohammad3");

        graph.addEdge("Mohammad", "Mohammad2", 3);
        graph.addEdge("Mohammad", "Mohammad3", 2);

        assertEquals(2, graph.getNeighbors("Mohammad").size());
        assertEquals(3, graph.getNeighbors("Mohammad").get(0).weight);
        assertEquals(2, graph.getNeighbors("Mohammad").get(1).weight);
    }

    @Test
    public void emptyGraph() {
        Graph graph = new Graph();

        assertNull(graph.getNeighbors("Mohammad"));
    }

    @Test
    public void oneNodeOneEdge() {
        Graph graph = new Graph();
        graph.addVertex("Mohammad");
        graph.addEdge("Mohammad", "Mohammad");

        System.out.println(graph.getNeighbors("Mohammad"));

        assertEquals(2, graph.getNeighbors("Mohammad").size());
        assertTrue(graph.getNeighbors("Mohammad").contains(new Vertex("Mohammad")));
        assertEquals(1, graph.getVertices().size());

    }

    @Test
    public void testValidTripWithCost() {
        Graph citiesGraph = new Graph();
        citiesGraph.addVertex("London");
        citiesGraph.addVertex("Paris");
        citiesGraph.addVertex("Berlin");
        citiesGraph.addVertex("Rome");

        citiesGraph.addEdge("London", "Paris", 50);
        citiesGraph.addEdge("Paris", "Berlin", 40);
        citiesGraph.addEdge("Berlin", "Rome", 30);

        BusinessCalculator calculator = new BusinessCalculator();
        String[] trip = {"London", "Paris", "Berlin", "Rome"};
        Integer cost = calculator.businessTrip(citiesGraph, trip);
        assertEquals(Integer.valueOf(120), cost);
    }

    @Test
    public void testInvalidTripNoConnection() {
        Graph citiesGraph = new Graph();
        citiesGraph.addVertex("London");
        citiesGraph.addVertex("Paris");
        citiesGraph.addVertex("Berlin");
        citiesGraph.addVertex("Rome");

        citiesGraph.addEdge("London", "Paris", 50);
        citiesGraph.addEdge("Berlin", "Rome", 30);

        BusinessCalculator calculator = new BusinessCalculator();
        String[] trip = {"London", "Rome"};
        Integer cost = calculator.businessTrip(citiesGraph, trip);
        assertEquals(null, cost);
    }

    @Test
    public void testInvalidTripInsufficientCities() {
        Graph citiesGraph = new Graph();
        citiesGraph.addVertex("London");
        citiesGraph.addVertex("Paris");
        citiesGraph.addVertex("Berlin");
        citiesGraph.addVertex("Rome");

        BusinessCalculator calculator = new BusinessCalculator();
        String[] trip = {"Berlin"};
        Integer cost = calculator.businessTrip(citiesGraph, trip);
        assertEquals(null, cost);

    }
    public void breadthFirstTraversal () {
        Graph testGraph = new Graph();
        Vertex v1 = testGraph.addVertex("A");
        testGraph.addVertex("B");
        testGraph.addVertex("C");
        testGraph.addVertex("D");
        testGraph.addEdge("A", "B");
        testGraph.addEdge("A", "C");
        testGraph.addEdge("B", "D");
        testGraph.addEdge("C", "D");
        assertEquals(4, testGraph.size());
        assertEquals(4, testGraph.getVertices().size());
        List<Vertex> bfsResult = testGraph.breadthFirst(v1);
        assertEquals("A", bfsResult.get(0).label);
        assertEquals("B", bfsResult.get(1).label);
        assertEquals("C", bfsResult.get(2).label);
        assertEquals("D", bfsResult.get(3).label);
    }
    @Test
    public void testDepthFirstTraverse(){
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A","D");
        graph.addEdge("A","B");
        graph.addEdge("B","D");
        graph.addEdge("B","C");
        graph.addEdge("C","G");
        graph.addEdge("D","F");
        graph.addEdge("D","H");
        graph.addEdge("D","E");
        graph.addEdge("F","H");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("G");
        list.add("D");
        list.add("E");
        list.add("H");
        list.add("F");

        Set<String> result = graph.depthFirstTraverse("A");

        assertTrue(result.contains(list.get(0)));
        assertTrue(result.contains(list.get(1)));
        assertTrue(result.contains(list.get(2)));
        assertTrue(result.contains(list.get(3)));
        assertTrue(result.contains(list.get(4)));
        assertTrue(result.contains(list.get(5)));
        assertTrue(result.contains(list.get(6)));
        assertTrue(result.contains(list.get(7)));
    }
}
