package org.example.hw21.task5;

public class CarRouteStrategy implements RouteStrategy{
    @Override
    public String calculateRoute(String destination) {
        return "this is the fastest way to get to " + destination;
    }
}
