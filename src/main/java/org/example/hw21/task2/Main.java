package org.example.hw21.task2;

import org.bson.io.BsonOutput;

public class Main {
    public static void main(String[] args) {
        Person p = Person.createPerson("dima", "lakov", 35,
                Address.createAdress("Ukraine", "Kyiv", "Doroshenko street"));
        Person d = p.shallowCopy(p);
        System.out.println("d person" + d);
        System.out.println("p person" + p);
        p.setAge(39);
        System.out.println("d person" + d);
        System.out.println("p person" + p);


        Person k = p.deepCopy();
        System.out.println("k person" + k);
        k.setAge(122);
        System.out.println("d person" + d);
        System.out.println("p person" + p);
        System.out.println("k person" + k);
    }
}
