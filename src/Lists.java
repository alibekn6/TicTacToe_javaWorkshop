import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        doSound(cat);
        doSound(dog);
    }



    public static void doSound(Zoo zoo){
        zoo.sound();
    }
}

interface Zoo{
    void sound();
}

class Dog implements Zoo{
    public void sound(){
        System.out.println("bark");
    }
}

class Cat implements Zoo{
    public void sound(){
        System.out.println("meow");
    }
}