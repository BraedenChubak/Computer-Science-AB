package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog705x {
    public static void main(String[] args) {
        try {
            var poem = new Scanner(new File("Langdat/prog512h.dat"));
            ArrayList<String[]> wordsAndLines = new ArrayList<String[]>();

            while (poem.hasNext()) {
                String[] line = poem.nextLine().split(" ");
                wordsAndLines.add(line);
            }

            poem.close();

            var code = new Scanner(new File("Langdat/prog705x.txt"));
            String answer = "";
            while (code.hasNext()) {
                int curCode = code.nextInt();
                int line = curCode / 100;
                int word = (curCode - (line * 100)) / 10;
                int chr = curCode - (line * 100) - (word * 10);
                answer += wordsAndLines.get(line-1)[word-1].substring(chr-1, chr);
            }

            System.out.println("The magic word is " + answer);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
The magic word is coolbeans
 */