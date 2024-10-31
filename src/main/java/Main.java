import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Random().nextInt(11));
    }
}


class Person{
    public void eat(){
        System.out.println("eating with mouth");
    }
}


class Chinese extends Person{
    public Chinese(){

    }

    public Chinese(String name) {
        this();
    }

    public void eat(){

    }
    public void shadowBoxing(){
        System.out.println("practice shadowBoxing every morning");
    }
}
