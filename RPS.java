import java.util.*;

public class RPS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("\nWELCOME TO THE Rock_Paper_Scissors GAME");
        System.out.println("\nPRESS 'EXIT' to exit the game at any time.");
        System.out.println("\nHow many rounds of Rock_Paper_Scissors would you like to play?");

        // Exit the program if the user enters "exit"
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Game exited. Goodbye!");
            sc.close();
            return;
        }

        int round;
        try {
            round = Integer.parseInt(input); // Parse the user's input to determine the number of rounds
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for the number of rounds. Exiting game.");
            sc.close();
            return;
        }

        int x = 0;
        int playersWinscount = 0;
        while (x < round) {
            boolean playerwon = playRPS(sc);
            if (playerwon) {
                playersWinscount++;
            }
            x++;
        }

        System.out.println("\nTOTAL WINS: " + playersWinscount);  // Display total wins
        sc.close(); // Close the scanner after use
    }

    // GAME START
    static Boolean playRPS(Scanner sc) {
        // INPUT USER
        String playerMove;
        while (true) {
            System.out.println("\nMake a move! (rock/paper/scissors)");
            playerMove = sc.nextLine().toLowerCase();  // Convert input to lowercase to standardize

            // CHECK FOR EXIT COMMAND
            if (playerMove.equalsIgnoreCase("exit")) {
                System.out.println("Game exited. Goodbye!");
                System.exit(0); // Exit the program
            }

            // CHECK FOR VALID INPUT
            if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
                break;
            } else {
                System.out.println("\nINVALID INPUT. PLEASE TRY AGAIN.");
            }
        }

        // COMPUTER INPUT
        Random random = new Random();
        int randomNum = random.nextInt(3);

        // CHECKING THE RANDOMNESS
        System.out.println(randomNum);

        // Assigning the value to ComputerMove
        String computerMove;
        if (randomNum == 0) {
            computerMove = "rock";
        } else if (randomNum == 1) {
            computerMove = "paper";
        } else {
            computerMove = "scissors";  // Corrected from "Scissors" to "scissors" for consistency
        }
        System.out.println("Computer Choose " + computerMove + "!");

        // RESULTS
        if (playerMove.equals(computerMove)) {
            System.out.println("AWWWW ! It's A Draw.");
            return false;
        } else if (playerWins(playerMove, computerMove)) {
            System.out.println("HURRAY ! You Win.");
            return true;
        } else {
            System.out.println("You Lost Buddy. Let's Try Again.");
            return false;
        }
    }

    // Player wins
    static boolean playerWins(String playerMove, String computerMove) {
        if (playerMove.equals("rock")) {
            return computerMove.equals("scissors");  // Corrected "scisscors" to "scissors"
        } else if (playerMove.equals("paper")) {
            return computerMove.equals("rock");
        } else {
            return computerMove.equals("paper");
        }
    }
}
