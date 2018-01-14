import java.util.Random;

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



    }

    public static int getValueOfDice() {
        Random rand = new Random();
        int diceMaxValue = 6;
        int diceMinValue = 1;

        return rand.nextInt(diceMaxValue - diceMinValue) + diceMinValue;
    }
}
