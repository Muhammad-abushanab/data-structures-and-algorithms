package graph;

import java.util.List;

public class BusinessCalculator {
    public Integer businessTrip(Graph graph, String[] cities) {
        if (cities.length < 2) {
            return null;
        }
        int totalCost = 0;
        for (int i = 0; i < cities.length - 1; i++) {
            Vertex currentCity = new Vertex(cities[i]);
            Vertex nextCity = new Vertex(cities[i + 1]);
            List<Vertex> neighbors = graph.getNeighbors(currentCity.label);
            if (neighbors == null || !neighbors.contains(nextCity)) {
                return null;
            }
            for (Vertex neighbor : neighbors) {
                if (neighbor.equals(nextCity)) {
                    totalCost += neighbor.weight;
                }
            }
        }
        return totalCost;
    }
}
