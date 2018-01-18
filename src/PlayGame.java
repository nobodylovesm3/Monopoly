import java.util.Random;
import java.util.Scanner;

public class PlayGame {

    public static final int numberOfBoardSectors = 40;
    public static final int BoardProperties = 7;
    public static String[] rawInformationBoard = new String[numberOfBoardSectors];
    public static String[][] readyBoard = new String[numberOfBoardSectors][BoardProperties];

    public static final int numberCards = 5;
    public static final int cardsProperties = 4;

    public static String[] emptyCommunityCards = new String[numberCards];
    public static String[][] readyCommunityCards = new String[numberCards][cardsProperties];

    public static String[] emptyLuckyCards = new String[numberCards];
    public static String[][] readyLuckyCards = new String[numberCards][cardsProperties];

    public static final int maxAmountOfPlayers = 8;
    public static final int minAmountOfPlayers = 2;
    public static int playersAmount;
    public static String[] playersNames = new String[maxAmountOfPlayers];
    public static final int startingMoney = 1500;
    public static int[] playersMoney = {startingMoney, startingMoney, startingMoney, startingMoney, startingMoney, startingMoney, startingMoney, startingMoney};

    public static int cardNumber;
    public static String cardName;
    public static String cardAction;
    public static String cardLoseWinMoney;
    public static String cardChangePlayerPosition;

    public static char choice;

    public static final int defaultStartPosition = 0;
    public static final int maxRoundsInJail = 3;
    public static final int maxTimesDiceThrows = 3;

    public static int allTurns;
    public static int[] firstDiceThrows = new int[maxAmountOfPlayers];
    public static int[] secondDiceThrows = new int[maxAmountOfPlayers];
    public static int[] countDicePairsThrownInRow = {defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition};

    public static String sectorAction;
    public static String sectorOwnership;
    public static String sectorCost;
    public static String sectorBuildingsCounter;

    public static boolean isReady = false;
    public static boolean hasWon = false;

    public static boolean[] isBankrupted = new boolean[maxAmountOfPlayers];
    public static int numberBankruptedPlayers = defaultStartPosition;

    public static boolean[] hasGetOutOfJailCard = new boolean[maxAmountOfPlayers];
    public static int[] spentRoundsInJail = {defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition};
    public static boolean[] isInJail = new boolean[maxAmountOfPlayers];

    public static void main(String[] args) {

    }

    //dice
    public static int getValueOfDice() {
        Random rand = new Random();
        int diceMaxValue = 12;
        int diceMinValue = 2;

        return rand.nextInt(diceMaxValue - diceMinValue + 1) + diceMinValue;
    }


}
