// 12 sep 2024 Jonas N Övning-10 ArrayList & Function: Enter points for participants

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        String input;

        // Initial message
        System.out.println("Välkommen till poängberäkningen i tävlingen!");
        System.out.println("Mata in poäng för deltagare.");

        // Loop to input points
        while (true) {
            System.out.print("Ange poäng: ");
            input = scanner.nextLine().trim();

            // If input is empty, query again
            if (input.isEmpty()) {
                System.out.println("Ogiltig inmatning. Poängen kan inte vara tom. Försök igen.");
                continue;
            }

            try {
                int score = Integer.parseInt(input); // convert input to an integer
                scores.add(score);                  // Add the score to the list
                System.out.println("Poäng inlagd: " + score);

                // Ask the user if they want to continue
                System.out.print("När du är klar, Tryck (n): ");
                String continueInput = scanner.nextLine().trim().toLowerCase();
                if (continueInput.equals("n")) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning. Vänligen ange ett giltigt heltal.");
            }
        }
        scanner.close();

        // Check if we have any points
        if (scores.isEmpty()) {
            System.out.println("Ingen poäng har registrerats.");
        } else {
            // Calculate the highest score
            int highestScore = scores.get(0); // Initialize the highest score to the first one
            for (int score : scores) {
                if (score > highestScore) {
                    highestScore = score; // Update the highest score
                }
            }

            // Calculate the average score
            int totalScore = 0; // To keep the total score
            for (int score : scores) {
                totalScore += score; // Sum all scores
            }
            // Calculate the average
            double averageScore = (double) totalScore / scores.size();

            // Print the results
            System.out.println("Den högsta poängen är: " + highestScore);
            System.out.printf("Genomsnittspoängen är: %.2f%n", averageScore);
        }
    }
}
