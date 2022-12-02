import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    private BufferedReader reader;
    private FileReader input;

    private int[] player = new int[2];

    public Solution() {
        setReader();
        calculate();
    }

    private void calculate() {
        String temp;
        int score = 0;
        try {
            while (!(temp = reader.readLine()).isEmpty()) {
                player[0] = (int) temp.charAt(0);
                player[1] = ((int) temp.charAt(2)) - 23;
                score += strat(false);
                score += choicePoints();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            System.out.println(score);
        }
    }

    // This method calculate the points based on the part | true = part1 | false =
    // part2
    private int strat(boolean part1) {
        if (part1) {
            return player[0] == player[1] - 1 || player[0] + player[1] == 132 && player[0] > player[1] ? 6
                    : player[0] == player[1] ? 3 : 0;
        } else {
            if (player[1] == 65) {
                player[1] = player[0] == 65 ? 67 : player[0] == 66 ? 65 : 66;
            } else if (player[1] == 66){
                player[1] = player[0] == 65 ? 65 : player[0] == 66 ? 66 : 67;
            } else {
                player[1] = player[0] == 65 ? 66 : player[0] == 66 ? 67 : 65;
            }
            return strat(true);
        }
    }

    // This method gives extra points based on the choice
    private int choicePoints() {
        return switch (player[1]) {
            case 65 -> 1;
            case 66 -> 2;
            default -> 3;
        };
    }

    // This method gets the input from a txt file
    private void setReader() {
        try {
            input = new FileReader(new File("INPUT.txt"));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        reader = new BufferedReader(input);
    }

    public static void main(String[] args) {
        new Solution();
    }
}