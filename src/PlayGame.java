import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {

        //boardCreation
        int[] board = new int[40];
        for (int i = 0; i < board.length; i++) {
            board[i] = i + 1;
        }

        //namesPositions
        String[] names = {"Go!", "Old Kent Road", "Community Chest", "Whitechapel Road", "INCOME TAX", "Kings Cross Station", "The Angel Islington", "CHANCE", "Euston Road", "Pentonville Road", "Visiting JAIL", "Pall Mall", "Electric Company", "Whitehall", "Northumrl'd Avenue", "Marylebone Station", "Bow street", "Community Shest", "Marlborough Street", "Vine Street", "Free Parking", "Strand", "CHANCE", "Fleet Street", "Trafalgar Square", "Fenchurch St. Station", "Leicester Square", "Coventry Street", "Water Works", "Piccadilly", "JAIL", "Regent Street", "Oxford Street", "Community Chest", "Bond Street", "Liverpool St. Station", "CHANCE", "Park Lane", "SUPER TAX", "Mayfair"};

        //haveToCreateCards
        int numberOfPlayers = 3;
        int[] players = new int[3];
        System.out.println(numberOfPlayers());

    }

    //dice
    public static int getValueOfDice() {
        Random rand = new Random();
        int diceMaxValue = 6;
        int diceMinValue = 1;

        return rand.nextInt(diceMaxValue - diceMinValue) + diceMinValue;
    }

    //getNumberOfPlayers
    public static int numberOfPlayers() {
        Scanner input = new Scanner(System.in);
        int numberOfPlayers;
        while (true) {
            try {
                do {
                    numberOfPlayers = Integer.parseInt(input.nextLine());
                } while (numberOfPlayers <= 1 || numberOfPlayers > 4);
                break;
            } catch (NumberFormatException e) {
                System.out.println("2 TO 4");
                continue;
            }
        }
        return numberOfPlayers;
    }

    public static void playGame(int[] board, String[] names, int[] players) {
        while (true) {

        }
    }
}
