import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class DayOnePartOne {
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
            int currMax = Integer.MIN_VALUE;

            while (scanner.hasNextLine()) {
                int currCalorieCount = 0;
                String currInput = scanner.nextLine();

                while (!currInput.isEmpty()) {
                    currCalorieCount += Integer.parseInt(currInput);
                    try {
                        currInput = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        break;
                    }
                }
                currMax = Math.max(currMax, currCalorieCount);
            }
            scanner.close();
            System.out.println("Max Calorie Count: " + currMax);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
    }
}