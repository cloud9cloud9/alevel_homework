package org.example.hw21.task5;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new BusRouteStrategy());
        System.out.println(navigator.executeRouteStrategy("Doroshenko street"));
    }
}
