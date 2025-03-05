package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prog570aRegEx {
    private static void printCharSet(boolean[] set, char baseChar) {
        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                System.out.print((char) (baseChar + i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog570a.dat"));

            // Arrays to track common lowercase and uppercase characters
            var commonLower = new boolean[26];
            var commonUpper = new boolean[26];
            boolean isFirstLine = true; // For initializing the common sets for the first line

            var lowerCasePattern = Pattern.compile("[a-z]");
            var upperCasePattern = Pattern.compile("[A-Z]");
            var nonAlphaPattern = Pattern.compile("[^a-zA-z\\s]"); // Excludes whitespace & letters

            while (file.hasNext()) {
                String line = file.nextLine();
                System.out.println("Line: " + line);

                var lowerCaseSet = new boolean[26];
                var upperCaseSet = new boolean[26];
                var nonAlphaSet = new StringBuilder();

                var lcMatcher = lowerCasePattern.matcher(line);
                while (lcMatcher.find()) {
                    char lowerChar = lcMatcher.group().charAt(0);
                    lowerCaseSet[lowerChar - 'a'] = true;
                }
                var ucMatcher = upperCasePattern.matcher(line);
                while (ucMatcher.find()) {
                    char upperChar = ucMatcher.group().charAt(0);
                    upperCaseSet[upperChar - 'A'] = true;
                }

                var naMatcher = nonAlphaPattern.matcher(line);
                while (naMatcher.find()) {
                    nonAlphaSet.append(naMatcher.group());
                }

                // Print line results
                System.out.print("Lowercase: ");
                printCharSet(lowerCaseSet, 'a');
                System.out.print("Uppercase: ");
                printCharSet(upperCaseSet, 'A');
                System.out.println("Odds and Ends: " + nonAlphaSet);

                if (isFirstLine) {
                    commonLower = lowerCaseSet;
                    commonUpper = upperCaseSet;
                    isFirstLine = false;
                } else {
                    for (int i = 0; i < 26; i++) {
                        commonLower[i] = commonLower[i] && lowerCaseSet[i];
                        commonUpper[i] = commonUpper[i] && upperCaseSet[i];
                    }
                }
                System.out.println();
            }

            file.close();

            System.out.print("Characters in every line (lowercase): ");
            printCharSet(commonLower, 'a');
            System.out.print("Characters in every line (uppercase): ");
            printCharSet(commonUpper, 'A');

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Line: Many computer installations are now confronted with a
Lowercase: acdefhilmnoprstuwy
Uppercase: M
Odds and Ends:

Line: threat akin to germ warfare, which could disable their
Lowercase: abcdefghiklmnorstuw
Uppercase:
Odds and Ends: ,

Line: largest machines.  A computer "virus" attacks a computer
Lowercase: aceghiklmnoprstuv
Uppercase: A
Odds and Ends: .""

Line: system in essentially the same way a biological virus
Lowercase: abceghilmnorstuvwy
Uppercase:
Odds and Ends:

Line: attacks the human body.
Lowercase: abcdehkmnostuy
Uppercase:
Odds and Ends: .

Line: A computer virus is actually a small undetected program
Lowercase: acdegilmnoprstuvy
Uppercase: A
Odds and Ends:

Line: that, over time, infects other programs and eventurlly
Lowercase: acdefghilmnoprstuvy
Uppercase:
Odds and Ends: ,,

Line: disables the entire system.  A typical virus in a host program
Lowercase: abcdeghilmnoprstuvy
Uppercase: A
Odds and Ends: .

Line: might contain the follow instructions:
Lowercase: acefghilmnorstuw
Uppercase:
Odds and Ends: :

Line: 1.  Temporarily suspend execution of host program.
Lowercase: acdefghilmnoprstuxy
Uppercase: T
Odds and Ends: 1..

Line: 2.  Search the computer's memory for other likely uninfected programs.
Lowercase: acdefghiklmnoprstuy
Uppercase: S
Odds and Ends: 2.'.

Line: 3.  If found, insert a copy of these instructions.
Lowercase: acdefhinoprstuy
Uppercase: I
Odds and Ends: 3.,.

Line: 4.  Return control of computer back to host program.
Lowercase: abcefghklmnoprstu
Uppercase: R
Odds and Ends: 4..

Line: This virus would take less than a second to execut, would
Lowercase: acdehiklnorstuvwx
Uppercase: T
Odds and Ends: ,

Line: be virtually undetected, and could attack indefinitely.  It can
Lowercase: abcdefiklnortuvy
Uppercase: I
Odds and Ends: ,.

Line: even spread to other computers, when an infected program
Lowercase: acdefghimnoprstuvw
Uppercase:
Odds and Ends: ,

Line: is swapped or copied for another user.
Lowercase: acdefhinoprstuw
Uppercase:
Odds and Ends: .

Characters in every line (lowercase): acenotu
Characters in every line (uppercase):

Process finished with exit code 0

 */