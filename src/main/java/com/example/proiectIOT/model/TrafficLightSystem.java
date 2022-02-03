package com.example.proiectIOT.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Document
public class TrafficLightSystem {
    @Id
    private String id;
    private final LinkedList<Integer>[] streets;
    private final List<Boolean> visited;
    private List<Integer> route;
    private int intersections;// = 0;

    public TrafficLightSystem(LinkedList<Integer>[] streets, List<Boolean> visited, List<Integer> route) {
        this.streets = streets;
        this.visited = visited;
        this.route = new ArrayList();
        this.intersections = 0;
    }

    public void addEdge(int src, int dest)
    {
        streets[src].add(dest);
    }

    public void DFS(int vertex, int stop)
    {
        visited.set(vertex, true);
        route.set(intersections++, vertex);

        if (vertex == stop)
        {
            System.out.print("Ruta calculata: ");
            for (int j = 0; j < intersections; j++)
                System.out.print(route.get(j) + " ");
            System.out.println();
        }

        for (int adj : streets[vertex])
        {
            if (!visited.get(adj))
                DFS(adj, stop);
        }
    }
}
