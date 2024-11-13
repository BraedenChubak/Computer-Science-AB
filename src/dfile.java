import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class dfile {
    public static void main(String[] args) {
        try {
            var file1 = new Scanner(new File("Langdat/bginvtry.dat"));

            while (file1.hasNext()) {

            }

            file1.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
