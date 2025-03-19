package Q3;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog595r {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/dale-chall-word-list.txt"));
            Set<String> wordList = new Set<>();
            while (file.hasNext()) {
                wordList.insert(file.next());
            }

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
