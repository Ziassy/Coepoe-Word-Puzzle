import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class App {
    // Global variabel
    private static final int MIN_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 6;
    private static final int MIN_SCORE = 70;
    private static final int MAX_TRIES = 11;
    private static final int MAX_TRIES1 = 10;

    static void wordLevel(int lvl, String worldLevel1, String worldLevel2, String worldLevel3) {
        if (lvl == 1) {
            System.out.println("\n\nLevel " + lvl);
            System.out.println(worldLevel1);
        } else if (lvl == 2) {
            System.out.println("\n\nLevel " + lvl);
            System.out.println(worldLevel2);
        } else {
            System.out.println("\n\nLevel " + lvl);
            System.out.println(worldLevel3);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int overalScore = 0;

        // Store word that already used with HashSet<>()
        HashSet<String> usedWords = new HashSet<>();
        String wordLevel1 = "d  e  t  t  l  i";
        String wordLevel2 = "a  e  c  a  e  n";
        String wordLevel3 = "h  k  r  n  e  o";
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

        for (String teks : array) {
            System.out.println(teks);
        }

        // Level 1
        int lvl = 1;
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        while (lvl <= 3) {

            wordLevel(lvl, wordLevel1, wordLevel2, wordLevel3);

            int tries = 1;
            int rightAnswer = 0;
            while (tries < MAX_TRIES) {

                System.out.print(tries + "> Your Answer: ");
                String word = input.nextLine();

                if (word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH) {
                    System.out.println("Invalid input. Word must have at least " + MIN_WORD_LENGTH
                            + " characters and at most " + MAX_WORD_LENGTH + " characters.");
                    continue;
                }
                if (usedWords.contains(word)) {
                    System.out.println("You had already type this word before..");
                    continue;
                }
                // Tambahkan kata yang digunakan ke HashSet
                usedWords.add(word);

                // Cek apakah data yang di input ada
                if (lvl == 1 && Arrays.asList(correctAnswerLevel1).contains(word)) {
                    // Tambahkan skor jika jawaban benar
                    score1 += 10;
                    rightAnswer += 1;
                    System.out.println("#Right. Score : " + score1);
                } else if (lvl == 2 && Arrays.asList(correctAnswerLevel2).contains(word)) {
                    // Tambahkan skor jika jawaban benar
                    score2 += 10;
                    rightAnswer += 1;
                    System.out.println("#Right. Score : " + score2);
                } else if (lvl == 3 && Arrays.asList(correctAnswerLevel3).contains(word)) {
                    // Tambahkan skor jika jawaban benar
                    score3 += 10;
                    rightAnswer += 1;
                    System.out.println("#Right. Score : " + score3);
                } else {
                    score1 += 0;
                    score2 += 0;
                    score3 += 0;
                }

                // Cek apakah skor sudah mencukupi untuk melanjutkan ke level berikutnya
                if (lvl == 1 && tries == MAX_TRIES1 && score1 >= MIN_SCORE
                        || lvl == 2 && tries == MAX_TRIES1 && score2 >= MIN_SCORE || lvl == 3 && tries == MAX_TRIES1
                                && score3 >= MIN_SCORE) {
                    System.out.println(tries);
                    System.out.println("You had answered 10 With " + rightAnswer + " right answers..");

                    System.out.println("\nCorrect Answers :");
                    if (lvl == 1) {
                        for (String element : correctAnswerLevel1) {
                            System.out.print(element + " ");
                            usedWords.clear();
                        }
                    } else if (lvl == 2) {
                        for (String element : correctAnswerLevel2) {
                            System.out.print(element + " ");
                            usedWords.clear();

                        }
                    } else {
                        for (String element : correctAnswerLevel2) {
                            System.out.print(element + " ");
                            usedWords.clear();

                        }

                    }

                    lvl++;
                    break;
                }

                tries++;
            }
            overalScore = score1 + score2 + score3;

            if (tries == MAX_TRIES && score1 < MIN_SCORE || tries == MAX_TRIES && score2 < MIN_SCORE
                    || tries == MAX_TRIES && score3 < MIN_SCORE) {
                System.out.println("You lose !! Try Again..");
                System.out.println("Do you want to try again? (Y/T): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Y")) {
                    usedWords.clear();
                    score1 = 0;
                    score2 = 0;
                    score3 = 0;
                    continue;
                } else if (choice.equalsIgnoreCase("T")) {
                    System.out.println("Game Over. Your final score is: " + overalScore);
                    return;
                } else {
                    System.out.println("Invalid input. Exiting game.");
                    return;
                }
            }

        }
        System.out.println("\n\nOverall score : " + overalScore);
        System.out.println("You Win!!");
        System.out.println("Press enter to exit");
        input.nextLine();
        System.exit(0);

        input.close();

    }
}
