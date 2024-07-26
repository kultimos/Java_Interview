package foundation.forTransient;

import java.io.*;

public class FtMain {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.setHobby("骑马");
        test.setName("王琦");
        test.setNumber(12);
        System.out.println(test.toString());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\t-wushuai\\Desktop\\w.txt"));
        oos.writeObject(test);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\t-wushuai\\Desktop\\w.txt"));
        Test o = (Test)ois.readObject();
        System.out.println(o.toString());
    }
}

class Test implements Serializable {
    private String name;
    private transient int number;
    private  String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}