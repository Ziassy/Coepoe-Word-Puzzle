import java.util.Scanner;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        String[] array = {
                "Coepoe Word Puzzle",
                "=================== \n",
                "Rules :",
                "1. Create a word using given characters, min 3 characters & max 6 characters.",
                "2. Each level, You have 10 chances to answer correctly.",
                "3. To get through to next level, you have to score 70 points each level"
        };

        for (String teks : array) {
            System.out.println(teks);
        }
    }
}
