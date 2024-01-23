package org.example.hw21.task5;

public class WalkRouteStrategy implements RouteStrategy{
    @Override
    public String calculateRoute(String destination) {
        return "you will lose 30 min more time to get to " + destination;
    }
}
