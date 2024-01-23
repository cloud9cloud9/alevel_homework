package org.example.hw21.task4;

import org.example.hw21.task4.Type.ComputerType;
import org.example.hw21.task4.Type.HardDriveType;
import org.example.hw21.task4.Type.RAMType;

public class Computer {
    private ComputerType computerType;
    private String motherBoard;
    private String processor;
    private String videoAdapter;
    private String box;
    private HardDriveType hardDriveType;
    private int SizeOfHardDrive;
    private RAMType ramType;
    private int sizeRAM;
    private String powerSupply;
    private String processorCooling;
    public Computer(ComputerType computerType, String motherBoard, String processor, String videoAdapter, String box, HardDriveType hardDriveType, int sizeOfHardDrive, RAMType ramType, int sizeRAM, String powerSupply, String processorCooling) {
        this.computerType = computerType;
        this.motherBoard = motherBoard;
        this.processor = processor;
        this.videoAdapter = videoAdapter;
        this.box = box;
        this.hardDriveType = hardDriveType;
        SizeOfHardDrive = sizeOfHardDrive;
        this.ramType = ramType;
        this.sizeRAM = sizeRAM;
        this.powerSupply = powerSupply;
        this.processorCooling = processorCooling;
    }

    public static ComputerBuilder builder(){
        return  new ComputerBuilder();
    }

    public static class ComputerBuilder {
        private ComputerType computerType;
        private String motherBoard;
        private String processor;
        private String videoAdapter;
        private String box;
        private HardDriveType hardDriveType;
        private int SizeOfHardDrive;
        private RAMType ramType;
        private int sizeRAM;
        private String powerSupply;
        private String processorCooling;



        public ComputerBuilder computerType(ComputerType computerType) {
            this.computerType = computerType;
            return this;
        }

        public ComputerBuilder motherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        public ComputerBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public ComputerBuilder videoAdapter(String videoAdapter) {
            this.videoAdapter = videoAdapter;
            return this;
        }

        public ComputerBuilder box(String box) {
            this.box = box;
            return this;
        }

        public ComputerBuilder hardDriveType(HardDriveType hardDriveType) {
            this.hardDriveType = hardDriveType;
            return this;
        }

        public ComputerBuilder SizeOfHardDrive(int SizeOfHardDrive) {
            this.SizeOfHardDrive = SizeOfHardDrive;
            return this;
        }

        public ComputerBuilder ramType(RAMType ramType) {
            this.ramType = ramType;
            return this;
        }

        public ComputerBuilder sizeRAM(int sizeRAM) {
            this.sizeRAM = sizeRAM;
            return this;
        }

        public ComputerBuilder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public ComputerBuilder processorCooling(String processorCooling) {
            this.processorCooling = processorCooling;
            return this;
        }
        public Computer build(){
            return new Computer(computerType, motherBoard, processor, videoAdapter, box, hardDriveType, SizeOfHardDrive,
                    ramType, sizeRAM, powerSupply, processorCooling);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Computer{");
        appendField(stringBuilder, "computerType", computerType);
        appendField(stringBuilder, "motherBoard", motherBoard);
        appendField(stringBuilder, "processor", processor);
        appendField(stringBuilder, "videoAdapter", videoAdapter);
        appendField(stringBuilder, "box", box);
        appendField(stringBuilder, "hardDriveType", hardDriveType);
        appendField(stringBuilder, "SizeOfHardDrive", SizeOfHardDrive);
        appendField(stringBuilder, "ramType", ramType);
        appendField(stringBuilder, "sizeRAM", sizeRAM);
        appendField(stringBuilder, "powerSupply", powerSupply);
        appendField(stringBuilder, "processorCooling", processorCooling);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private void appendField(StringBuilder stringBuilder, String fieldName, Object fieldValue) {
        if (fieldValue != null) {
            stringBuilder.append(fieldName).append("='").append(fieldValue).append("', ");
        }
    }
}
