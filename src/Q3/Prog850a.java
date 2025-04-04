package Q3;

import DataStructures.Dictionary;
import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog850a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog850b.txt"));
            Dictionary<String, Integer> map = new Dictionary<>();

            while (file.hasNext()) {
                String s = file.next();
                file.nextInt();
                file.nextInt();
                file.nextInt();
                int i = file.nextInt();
                if (map.contains(s)) {
                    map.insert(s, i+map.get(s));
                } else {
                    map.insert(s, i);
                }
            }
            Set<String> keys = map.keySet();
            System.out.println("Dept\t\tHours");
            for (String s : keys) {
                int h = map.get(s);
                System.out.println(s + "   \t" + h);
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Dept		Hours
Getka   	651
Business   	583
Ryan   	1243
Number   	1246
Taylor   	715
Computer   	769
Sam   	279
 */