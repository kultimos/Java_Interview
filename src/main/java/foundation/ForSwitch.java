package foundation;

public class ForSwitch {
    public static void main(String[] args) {
        String a = "127";
        switch (a) {
            case "10":
                System.out.println("成功");
                break;
            case "127":
                System.out.println("失败");
                break;
            default:
                System.out.println("over");
                break;
        }
    }
}
