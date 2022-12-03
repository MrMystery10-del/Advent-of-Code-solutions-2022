import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// ONLY WORK FOR PART 2, I DID NOT IMPORT MY PART 1 INTO PART 2 CODE CUS LAZY LOL
public class Solution {

    private BufferedReader reader;
    private FileReader input;

    public Solution() {
        setReader();
        calculate();
    }

    private void calculate() {
        String temp, temp2, temp3;
        int sum = 0;
        try {
            while (!(temp = reader.readLine()).isEmpty()) {
                temp2 = reader.readLine();
                temp3 = reader.readLine();
                boolean stop = false;
                for (int i = 0; i < temp.length() && !stop; i++) {
                    for (int y = 0; y < temp2.length() && !stop; y++) {
                        if (temp.charAt(i) == temp2.charAt(y)) {
                            for (int x = 0; x < temp3.length() && !stop; x++) {
                                if (temp.charAt(i) == temp3.charAt(x)) {
                                    sum += temp.charAt(i) >= 97 ? temp.charAt(i) - 96 : temp.charAt(i) - 38;
                                    stop = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            System.out.println(sum);
        }
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