import java.util.*;

public class RPS {

    public static void main(String[] args) {
        //INPUT USER
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWELCOME TO THE Rock_Paper_Scissors GAME");

        System.out.println("\nMake a move! (rock/paper/scissors)");
        String playerMove = sc.nextLine();

        //COMPUTER INPUT
        Random random = new Random();
        int randomNum = random.nextInt(3);
        //CHECKING THE RANDOMNESS
        System.out.println(randomNum);

            //Assigning the value to ComputerMove
        String computerMove;
        if(randomNum==0){
            computerMove = "rock";
        }else if (randomNum==1){
            computerMove = "paper";
        }else {
            computerMove = "Scissors";
        }
        System.out.println("Computer Choose "+ computerMove + "!");

        // RESULTS
        if(playerMove.equals(computerMove)){
            System.out.println("AWWWW ! It's A Draw.");
        }else if(playerWins(playerMove, computerMove)){
            System.out.println("HURRAY ! You Wins.");
        }else{
            System.out.println("You Lost Buddy. Lets's Try Again. ");
        }
    }

    //playerwins
    static boolean playerWins(String playerMove, String computerMove){
        if(playerMove.equals("rock")){
            return computerMove.equals("scisscors");
        }else if (playerMove.equals("paper")){
            return computerMove.equals("rock");
        }else{
            return computerMove.equals("paper");
        }
    }

}