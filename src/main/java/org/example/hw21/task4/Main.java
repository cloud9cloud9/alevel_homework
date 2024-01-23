package org.example.hw21.task4;

import jdk.swing.interop.SwingInterOpUtils;
import org.example.hw21.task4.Type.ComputerType;
import org.example.hw21.task4.Type.HardDriveType;

public class Main {
    public static void main(String[] args) {
        Computer comp = Computer.builder()
                .computerType(ComputerType.LAPTOP)
                .processor("INTEL core i3 12100")
                .hardDriveType(HardDriveType.SSD)
                .build();
        System.out.println(comp);
    }
}
