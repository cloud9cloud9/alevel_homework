package org.example.hw21.task5;

public class BusRouteStrategy implements RouteStrategy{
    @Override
    public String calculateRoute(String destination) {
        return "you will lose 10 min more time to get to " + destination;
    }
}
