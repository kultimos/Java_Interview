package forQuote;

public class ForQuote {
    public static void main(String[] args) {
        /**
         * 执行到本段结尾处的结构应是如图step1.png
         */
        StringBuffer str1 = new StringBuffer("good");
        StringBuffer str2 = new StringBuffer("bad");
        change(str1, str2);

        /**
         * 最终结果即step5.png所示
         * 经历了上面的修改后,此时可以看到,str1和str2的堆指向始终没变,但是因为我们在过程中传递的是二者地址的拷贝,
         * 我们通过这个地址的拷贝,找到了对象的堆内的数据,并修改了,这自然会影响到我们原来的数据;
         */
        System.out.println(str1.toString());
        System.out.println(str2.toString());
    }

    private static void change(StringBuffer str11, StringBuffer str12) {
        /**
         * 刚进入方法,衍生了两个形参str11饿str12,此时的结构应该是如图step2.png
         * 需要注意的是,因为传进来的实际上是数据的拷贝,所以在栈中的地址和指向堆中指针都是完全一致的;
         */

        /**
         * 修改了str12的数据指向,此时的结构应该是如图step3.png
         */
        str12 = str11;

        /**
         * 修改了str11指向的数据的内容,此时的结构应该是如图step4.png
         */
        str11 = new StringBuffer("new world");

        /**
         * 修改了str12指向的数据的内容,此时的结构应该是如图step5.png
         */
        str12.append("new world");
    }
}
