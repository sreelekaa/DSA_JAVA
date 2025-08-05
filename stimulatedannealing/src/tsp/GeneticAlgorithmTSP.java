package tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithmTSP {
    private static final int NUM_CITIES = 5;
    private static final int MAX_GENERATIONS = 100;
    private static final int POPULATION_SIZE = 10;
    private static final double MUTATION_RATE = 0.1;
    private static final Random random = new Random();

    public static double calculateDistance(City city1, City city2) {
        int dx = city1.x - city2.x;
        int dy = city1.y - city2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Route generateRandomRoute() {
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < NUM_CITIES; i++) {
            path.add(i);
        }
        Collections.shuffle(path, random);
        return new Route(path);
    }

    public static void calculateFitness(Route route, List<City> cities) {
        double totalDistance = 0.0;
        for (int i = 0; i < NUM_CITIES - 1; i++) {
            int cityIndex1 = route.path.get(i);
            int cityIndex2 = route.path.get(i + 1);
            totalDistance += calculateDistance(cities.get(cityIndex1), cities.get(cityIndex2));
        }
        int lastCityIndex = route.path.get(NUM_CITIES - 1);
        totalDistance += calculateDistance(cities.get(lastCityIndex), cities.get(route.path.get(0)));
        route.setFitness(totalDistance);
    }

    public static Route crossover(Route parent1, Route parent2) {
        Route child = new Route();
        for (int i = 0; i < NUM_CITIES; i++) {
            child.path.add(-1);
        }

        int startPos = random.nextInt(NUM_CITIES);
        int endPos = random.nextInt(NUM_CITIES);

        for (int i = 0; i < NUM_CITIES; i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.path.set(i, parent1.path.get(i));
            } else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.path.set(i, parent1.path.get(i));
                }
            }
        }

        for (int i = 0; i < NUM_CITIES; i++) {
            if (!child.path.contains(parent2.path.get(i))) {
                for (int j = 0; j < NUM_CITIES; j++) {
                    if (child.path.get(j) == -1) {
                        child.path.set(j, parent2.path.get(i));
                        break;
                    }
                }
            }
        }

        return child;
    }

    public static void mutate(Route route) {
        for (int i = 0; i < NUM_CITIES; i++) {
            if (random.nextDouble() < MUTATION_RATE) {
                int swapIndex = random.nextInt(NUM_CITIES);
                Collections.swap(route.path, i, swapIndex);
            }
        }
    }

    public static Route findBestRoute(List<Route> population) {
        Route bestRoute = population.get(0);
        for (Route route : population) {
            if (route.getFitness() < bestRoute.getFitness()) {
                bestRoute = route;
            }
        }
        return bestRoute;
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City(60, 200));
        cities.add(new City(180, 200));
        cities.add(new City(80, 180));
        cities.add(new City(140, 180));
        cities.add(new City(20, 160));
        // Add more cities similarly (if needed)

        List<Route> population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Route route = generateRandomRoute();
            calculateFitness(route, cities);
            population.add(route);
        }

        double initialDistance = 0.0;
        Route firstRoute = population.get(0);
        for (int i = 0; i < NUM_CITIES - 1; i++) {
            initialDistance += calculateDistance(cities.get(firstRoute.path.get(i)), cities.get(firstRoute.path.get(i + 1)));
        }
        initialDistance += calculateDistance(cities.get(firstRoute.path.get(NUM_CITIES - 1)), cities.get(firstRoute.path.get(0)));
        System.out.println("Initial Distance: " + initialDistance);

        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            List<Route> newPopulation = new ArrayList<>();

            for (int i = 0; i < POPULATION_SIZE; i++) {
                Route parent1 = findBestRoute(population);
                Route parent2 = findBestRoute(population);
                Route child = crossover(parent1, parent2);
                mutate(child);
                calculateFitness(child, cities);
                newPopulation.add(child);
            }

            population = newPopulation;
        }

        Route bestRoute = findBestRoute(population);
        System.out.println("FINISHED");

        double finalDistance = 0.0;
        for (int i = 0; i < NUM_CITIES - 1; i++) {
            finalDistance += calculateDistance(cities.get(bestRoute.path.get(i)), cities.get(bestRoute.path.get(i + 1)));
        }
        finalDistance += calculateDistance(cities.get(bestRoute.path.get(NUM_CITIES - 1)), cities.get(bestRoute.path.get(0)));
        System.out.println("Final Distance: " + finalDistance);

        StringBuilder solution = new StringBuilder();
        for (int i : bestRoute.path) {
            solution.append(cities.get(i).y).append("|").append(cities.get(i).x).append(",");
        }
        System.out.println("Solution:");
        System.out.println(solution.substring(0, solution.length() - 1)); // Remove the trailing comma
    }
}
