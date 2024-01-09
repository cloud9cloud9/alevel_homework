package org.example.hw21.task2;

import lombok.Data;

@Data

public class Person implements Cloneable{
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    public Person(String firstName, String lastName, int age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = new Address(address.getCountryName(), address.getCityName(), address.getStreetName());
    }

    public Person deepCopy() {
        return new Person(this.firstName, this.lastName, this.age, this.address.deepCopy());
    }
    public Person shallowCopy(Person p)  {
        Person d = p;
        return d;
    }
    public static Person createPerson(String firstName, String lastName, int age, Address address) {
        return new Person(firstName, lastName, age, address);
    }
}
