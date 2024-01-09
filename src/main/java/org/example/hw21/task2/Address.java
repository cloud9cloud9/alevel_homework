package org.example.hw21.task2;

import lombok.Data;

@Data
public class Address implements Cloneable {

    private String countryName;
    private String cityName;
    private String streetName;

    public Address(String countryName, String cityName, String streetName) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.streetName = streetName;
    }

    public static Address createAdress(String countryName, String cityName, String streetName) {
        return new Address(countryName, cityName, streetName);
    }

    public Address deepCopy() {
        return new Address(this.countryName, this.cityName, this.streetName);
    }
}
