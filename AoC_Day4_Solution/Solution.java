import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;

// ONLY WORK FOR PART 2, I DID NOT IMPORT MY PART 1 INTO PART 2 CODE CUS LAZY LOL
public class Solution {

    private NumberFilter filter = new NumberFilter();

    private BufferedReader reader;
    private FileReader input;

    private int call = 0;

    public Solution() {
        setReader();
        calculate();
    }

    private void calculate() {
        String temp;
        int score = 0;
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        try {
            while (!(temp = reader.readLine()).isEmpty()) {
                p1.setLocation(filter.getNumberFromString(String.valueOf(numUntilChar(temp))),
                        filter.getNumberFromString(String.valueOf(numUntilChar(temp))));
                p2.setLocation(filter.getNumberFromString(String.valueOf(numUntilChar(temp))),
                        filter.getNumberFromString(String.valueOf(numUntilChar(temp))));
                call = 0;
                if (p1.x <= p2.x && p1.y >= p2.x) {
                    score++;
                } else if (p2.x <= p1.x && p2.y >= p1.x) {
                    score++;
                }
            } // 30-30,30-32
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            System.out.println(score);
        }
    }

    private char[] numUntilChar(String temp) {

        char[] c = new char[temp.length()];
        int x = 0;
        while (call < temp.length()) {
            if (temp.charAt(call) == '-' || temp.charAt(call) == ',') {
                call++;
                return c;
            } else {
                c[x] = temp.charAt(call);
            }
            call++;
            x++;
        }
        return c;
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