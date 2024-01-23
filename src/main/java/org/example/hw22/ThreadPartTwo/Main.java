package org.example.hw22.ThreadPartTwo;

/**після старту потоку в іншому потоці(мейн), там де ви створювали і запускали його, виведіть на консоль
/значення змінної “counter”, але зробіть це так, щоб потік main ЗАЧЕКАВ на виконання створеного потоку.
Бо якщо ви одразу після старту нового потоку виведете значення змінної, там буде не повністю інкрементоване значення.
Тому потрібно використати дещо, що ми проходили на лекції
 **/
public class Main {
    public static void main(String[] args)  {
        SomeClass someClass = new SomeClass();

        Thread someThread = new SomeThread(someClass);
        someThread.start();

        try {
            someThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("from main" + someClass.getValue());
    }
}
