import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class App {
    // Global variabel
    private static final int MIN_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 6;
    private static final int MIN_SCORE = 70;
    private static final int MAX_TRIES = 10;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // Store word that already used with HashSet<>()
        HashSet<String> usedWords = new HashSet<>();
        String Wordlevel1 = "d  e  t  t  l  i";
        String Wordlevel2 = "a  e  c  a  e  n";
        String Wordlevel3 = "h  k  r  n  e  o";
        String[] array = {
                "Coepoe Word Puzzle",
                "=================== \n",
                "Rules :",
                "1. Create a word using given characters, min 3 characters & max 6 characters.",
                "2. Each level, You have 10 chances to answer correctly.",
                "3. To get through to next level, you have to score 70 points each level"
        };
        String[] correctAnswerLevel1 = { "die", "led", "lei", "let", "lied", "lie", "lit", "tie", "deli", "diet",
                "edit", "idle", "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "tilted", "titled" };

        String[] correctAnswerLevel2 = { "sec", "can", "cane", "scan", "scene", "case", "cease", "cas", "ease", "acena",
                "caean" };

        String[] correctAnswerLevel3 = { "honk", "honker", "roe", "ore", "her", "hen", "one", "cas", "ease", "acena",
                "caean" };

        
        // String answer = "ted";

        // if (Arrays.asList(correctAnswerLevel1).contains(answer)) {
        //     System.out.println("The word is valid.");
        // } else {
        //     System.out.println("The word is not valid.");
        // }

        for (String teks : array) {
            System.out.println(teks);
        }

        // Level 1
        int lvl = 1;
        int score = 0;
        while (lvl <= 3) {
            System.out.println("\nLevel " + lvl);
            System.out.println("You have " + MAX_TRIES + " tries to reach a score of " + MIN_SCORE);

            int tries = 0;
            while (tries < MAX_TRIES) {

                System.out.print("Enter a word: ");
                String word = input.nextLine();

                if (word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH) {
                    System.out.println("Invalid input. Word must have at least " + MIN_WORD_LENGTH
                            + " characters and at most " + MAX_WORD_LENGTH + " characters.");
                    continue;
                }
                if (usedWords.contains(word)) {
                    System.out.println("Invalid input. You've already used that word.");
                    continue;
                }
                // Tambahkan kata yang digunakan ke HashSet
                usedWords.add(word);

                // Tambahkan skor jika jawaban benar
                score += 10;
                System.out.println("Correct! Your current score is " + score);

                // Cek apakah skor sudah mencukupi untuk melanjutkan ke level berikutnya
                if (score >= MIN_SCORE) {
                    System.out.println(
                            "Congratulations! You've reached the required score to move on to the next level.");
                    lvl++;
                    break;
                }
                tries++;
            }

            if (tries == MAX_TRIES && score < MIN_SCORE) {
                System.out.print("You did not reach the required score. Do you want to try again? (Y/N): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Y")) {
                    usedWords.clear();
                    continue;
                } else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Game Over. Your final score is: " + score);
                    return;
                } else {
                    System.out.println("Invalid input. Exiting game.");
                    return;
                }
            }
            // Jika user berhasil melewati level 3 dengan skor minimal 70, tampilkan nilai
            // akhir yang diakumulasi dari level 1
            System.out.println("Congratulations! You've completed all levels. Your final score is: " + score);
            input.close();

        }

    }
}
