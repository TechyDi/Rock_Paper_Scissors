import java.util.*;
public class RPS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("\nWELCOME TO THE Rock_Paper_Scissors GAME");
        System.out.println("\nHow many rounds of Rock_Paper_Scissors would you like to play?");

            int round = Integer.parseInt(sc.nextLine());
                int x = 0;
                int playersWinscount = 0;
                while(x<round){
                boolean playerwon = playRPS(sc);
                    if(playerwon){
                        playersWinscount++;
                    }
                x++;
                }
        
    }
    //GAME START
    static Boolean playRPS(Scanner sc){

        //INPUT USER
    String playerMove;
    while (true) {
        
        System.out.println("\nMake a move! (rock/paper/scissors)");
            playerMove = sc.nextLine();

        //CHECK FOR VALID INPUT
        
        if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
            break;
        } else {
            System.out.println("\nINVALID INPUT. PLEASE TRY AGAIN.");
        }
    }
       
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

        if(playerMove.equalsIgnoreCase(computerMove)){
            System.out.println("AWWWW ! It's A Draw.");
            return false;
        }else if(playerWins(playerMove, computerMove)){
            System.out.println("HURRAY ! You Wins.");
            return true;
        }else{
            System.out.println("You Lost Buddy. Lets's Try Again. ");
            return false;
        }
    }

    //playerwins
    static boolean playerWins(String playerMove, String computerMove){
        if(playerMove.equalsIgnoreCase("rock")){
            return computerMove.equals("scisscors");
        }else if (playerMove.equalsIgnoreCase("paper")){
            return computerMove.equals("rock");
        }else{
            return computerMove.equals("paper");
        }
    }
}