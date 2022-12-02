import java.io.*;
import java.util.ArrayList;

public class Solution {

  private BufferedReader reader;
  private FileReader input;

  private ArrayList<Integer> elfs = new ArrayList<>();
  private Boolean finsihed = false;
  private int index = -1;

  public Solution() {
    setReader();
    while (!finsihed) {
      count();
    }
    elfs.sort(null);
    System.out.println("Result for top 1: " + elfs.get(index));
    System.out.println("Result for top 3 total: " + (elfs.get(index) + elfs.get(index - 1) + elfs.get(index - 2)));
  }

  // Count all the calories from each elf
  private void count() {
    String calories = "";
    int temp = 0;
    try {
      while (!(calories = reader.readLine()).isEmpty()) {
        temp += Integer.parseInt(calories);
      }
      elfs.add(temp);
      index++;
    } catch (IOException exception) {
      exception.printStackTrace();
    } catch (NullPointerException nullPointerException) {
      finsihed = true;
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
