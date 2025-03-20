package Q3;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog595r {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/dale-chall-word-list.txt"));
            Set<String> wordList = new Set<>();
            while (file.hasNext()) {
                String word = file.nextLine();
                word = word.replaceAll("[^a-zA-Z]", ""); // only doing this because of apostrophes in contractions
                wordList.insert(word);
            }
            file.close();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your string: ");
            String text = input.nextLine();
            String[] sentences = text.split("[.?!]");
            ArrayList<String> words = new ArrayList<>();
            boolean isFirst = true;
            for (String s : sentences) {
                String[] curWords = s.split("\\s+");
                if (isFirst) { isFirst = false; }
                else { // I think sentences after the first have an empty item in index 0
                    String[] temp = new String[curWords.length-1];
                    for (int i = 1; i < curWords.length; i++) {
                        temp[i-1] = curWords[i];
                    }
                    curWords = temp;
                }
                for (String s2 : curWords) {
                    String curWord = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    int wordLength = curWord.length();
                    if (curWord.substring(wordLength-1, wordLength).equals("s")) { curWord = curWord.substring(0, wordLength-1); }
                    else if (curWord.substring(wordLength-2, wordLength).equals("ed")) { curWord = curWord.substring(0, wordLength-2); }
                    else if (curWord.substring(wordLength-2, wordLength).equals("es")) { curWord = curWord.substring(0, wordLength-2); }
                    else if (curWord.substring(wordLength-3, wordLength).equals("ing")) { curWord = curWord.substring(0, wordLength-3); }
                    words.add(curWord);
                }
            }

            double avgLength = words.size() / (double) sentences.length;
            double difficultWords = 0;
            for (String s : words) {
                if (!wordList.contains(s)) {
                    difficultWords++;
                }
            }
            difficultWords /= words.size();
            double score = 0.1579 * (difficultWords * 100) + 0.0496 * avgLength;
            if (difficultWords >= 0.05) { score += 3.6365; }

            System.out.println("The calculated score is: " + score);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Enter your string: The quick brown fox jumps over the lazy dog.  Many installations require thorough understanding.
The calculated score is: 7.367271428571428
 */