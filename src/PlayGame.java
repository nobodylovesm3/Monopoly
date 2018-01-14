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

        //buySector
        boolean[] numberOfBoughtSectors = new boolean[board.length];

        int[] playerPosition = new int[numberOfPlayers()];

    }

    //dice
    public static int getValueOfDice() {
        Random rand = new Random();
        int diceMaxValue = 12;
        int diceMinValue = 2;

        return rand.nextInt(diceMaxValue - diceMinValue + 1) + diceMinValue;
    }

    //getNumberOfPlayers
    public static int numberOfPlayers() {
        Scanner input = new Scanner(System.in);
        int numberOfPlayers;
        while (true) {
            try {
                do {
                    numberOfPlayers = Integer.parseInt(input.nextLine());
                } while (numberOfPlayers < 2 || numberOfPlayers > 8);
                break;
            } catch (NumberFormatException e) {
                System.out.println("2 TO 8");
                continue;
            }
        }
        return numberOfPlayers;
    }

    public static boolean buySector(int index, boolean[] numberOfBoughtSectors) {
        numberOfBoughtSectors[index] = true;
        return numberOfBoughtSectors[index];
    }

    //    public static void movePlayers(int[] playerPosition, int[] board) {
//        return movePlayer();
//    }

    public static void receiveOwnership(int index, boolean[] numberOfSectors) {
        Scanner input = new Scanner(System.in);
        String answer;
        if (!isBought(index, numberOfSectors)) {
            while (true) {
                answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    buySector(index, numberOfSectors);
                    break;
                } else if (answer.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }
    }

    public static boolean isBought(int index, boolean[] numberOfBoughtSectors) {
        return numberOfBoughtSectors[index];
    }

    public static int startMoney() {
        return 2 * 500 + 2 * 100 + 2 * 50 + 6 * 20 + 10 * 5 + 5 * 5 + 1 * 5;
    }

    //notready
    public static int countMoney(int[] playerPosition, int index, boolean[] numberOfBoughtSectors) {
        int currentMoney = startMoney();

        if (isBought(index, numberOfBoughtSectors) && playerPosition[index] == (index - 1)) {
        //    currentMoney -= (index + 1) *;
        }
    }

    public static int taxAmountSectors(int[] board, int index) {
    }

//    public static boolean isBrokeOut() {
//        return countMoney() < 0;
//    }

//    public static void playGame(int[] board, String[] names, int[] players) {
//        while (true) {
//
//        }
//    }


}
