package tsp;

import java.util.ArrayList;
import java.util.List;

public class Route {
    List<Integer> path;
    double fitness;

    public Route() {
        this.path = new ArrayList<>();
    }

    public Route(List<Integer> path) {
        this.path = path;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }
}
