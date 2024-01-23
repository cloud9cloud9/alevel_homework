package org.example.hw21.task5;

public class Navigator {
    RouteStrategy routeStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public String executeRouteStrategy(String destination){
        return  routeStrategy.calculateRoute(destination);
    }
}
