package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DataStructures.Bag;
import DataStructures.Set;

class WordAndCount {
    String word;
    int count;
    public WordAndCount(String w, int c) {
        word = w;
        count = c;
    }
}
public class MultisetLab {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/words"));
            var bag = new Bag<String>();
            var rnd = new java.util.Random(42);

            while (file.hasNext()) {
                String word = file.next().toLowerCase();
                for (int i = 0; i < rnd.nextInt(1, 101); i++) {
                    bag.insert(word);
                }
            }
            file.close();

            bag.enumerate();

            Set<String> wordSet = bag.getSet();
            var iter = wordSet.iterator();
            WordAndCount[] top10 = new WordAndCount[10];
            for (int i = 0; i < 10; i++) {
                top10[i] = new WordAndCount("", -1);
            }
            while (iter.hasNext()) {
                WordAndCount curWord = new WordAndCount(iter.next(), 0);
                curWord.count = bag.count(curWord.word);
                for (int i = 0; i < 10; i++) {
                    if (curWord.count > top10[i].count) {
                        for (int j = 9; j > i; j--) {
                            top10[j] = top10[j-1];
                        }
                        top10[i] = curWord;
                        break;
                    }
                }
            }

            System.out.println("These are the top 10 most common words:");
            for (int i = 0; i < 10; i++) {
                System.out.println(top10[i].word + ": (" + top10[i].count + ")");
            }



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
