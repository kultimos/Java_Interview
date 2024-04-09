package java_eight;

import java.util.function.Function;

public class TestFunctionInterface {
    public static void main(String[] args) {
        /**
         * 首先我们定义了一个自己的函数式接口,该接口里只有一个抽象方法method;
         * 首先,我们用我们常用的方式去创建这个接口实例,重写方法,调用方法
         */
//        MyFunctionalInterface functionalInterface1 = new MyFunctionalInterface() {
//            @Override
//            public void method() {
//                System.out.println("我重写了方法");
//            }
//        };
//        System.out.println("我在前");
//        functionalInterface1.method();

        /**
         * ok 那看一下我们使用lambda表达式以后代码的样子
         * 简洁了很多
         */
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("哈哈,纽币");
        System.out.println("我在前");
        myFunctionalInterface.method();

        /**
         * 此外,函数式接口中也可以传入参数,这里我们用java里自带的函数式接口Function试一下
         */
        Function f = s -> s+"aa";
        Object result = f.apply("你好");
        System.out.println("看一下吧" + result);
    }
}
