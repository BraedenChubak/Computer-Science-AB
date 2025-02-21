package Q3;

import java.util.Locale;

public class Pelican56_6 {
    public static int hashCode(String s) {
        s = s.toUpperCase();
        int code = s.charAt(0) * 1000;
        code += s.charAt(1) * 100;
        code += s.charAt(s.length()-2) * 10;
        code += s.charAt(s.length()-1);
        return code % 180;
    }
    public static void main(String[] args) {
        int bushCode = hashCode("Bush, George");
        System.out.println("Bush, George >> " + bushCode);
        int billCode = hashCode("Clinton, Bill");
        System.out.println("Clinton, Bill >> " + billCode);
        int abeCode = hashCode("Lincoln, Abraham");
        System.out.println("Lincoln, Abraham >> " + abeCode);
        int georgeCode = hashCode("Washington, George");
        System.out.println("Washington, George >> " + georgeCode);
    }
}
/*
Bush, George >> 39
Clinton, Bill >> 16
Lincoln, Abraham >> 147
Washington, George >> 139
 */