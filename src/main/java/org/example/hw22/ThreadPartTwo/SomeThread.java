package org.example.hw22.ThreadPartTwo;

public class SomeThread extends Thread{
    SomeClass someClass;
    public SomeThread(SomeClass someClass){
        this.someClass = someClass;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            someClass.increment();
        }
    }
}
