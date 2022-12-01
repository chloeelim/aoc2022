import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DayOnePartTwo {
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
            PriorityQueue<Integer> topThree = new PriorityQueue<>(3);

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
                
                // check if in top 3
                if (topThree.size() < 3) {
                    topThree.add(currCalorieCount);
                } else if (currCalorieCount > topThree.peek()) {
                    topThree.poll();
                    topThree.add(currCalorieCount);
                } else {
                }
            }
            scanner.close();
            int sumTopThree = topThree.stream().reduce(0, Integer::sum);
            System.out.println("Sum of top three: " + sumTopThree);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
