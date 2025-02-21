package Q3;

import java.util.*;

public class Pelican45_3 {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Bill");
        s1.add("Larry");
        s1.add("Adolph");
        s1.add("Regina");
        s1.add("Susie");
        Set<String> s2 = new HashSet<>();
        s2.add("Larry");
        s2.add("Jack");
        s2.add("Alice");
        s2.add("June");
        s2.add("Benny");
        s2.add("Susie");
        s1.retainAll(s2);

        Iterator<String> iter = s1.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
/*
Susie Larry
 */