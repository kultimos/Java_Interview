import java.io.IOException;
import java.util.TimeZone;

public class ForThrow {

    public static void main(String[] args) {
        TimeZone localZone = TimeZone.getDefault();
        System.out.println("Local Time Zone: " + localZone.getDisplayName());
    }

    public void str2int(String str) throws NumberFormatException, NumberFormatException { //这里将得到的异常向外抛出
        try {
            System.out.println(Integer.parseInt(str));
        } catch(NumberFormatException e) {

            //TODO 这里可以做一些处理，处理完成后将异常报出，让外层可以得到异常信息

            throw new NumberFormatException("格式化异常");
        }
    }
}
