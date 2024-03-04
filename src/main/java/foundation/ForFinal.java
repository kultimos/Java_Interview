package foundation;

public class ForFinal {

    public static void main(String[] args) {
        /**
         * 用final修饰一个对象
         */
         final Tree tree = new Tree("yao",11);

        /**
         * 该对象的引用指向的内容可以被修改
         */
        tree.name = "sa";

        /**
         * 但是引用不可以被更换为其他对象
         */
//        tree = new Tree("S", 30);
        System.gc();
    }


    static class Tree {
        public Tree(String name, int age) {
            this.age = age;
            this.name = name;
        }
        String name;
        int age;
    }
}
