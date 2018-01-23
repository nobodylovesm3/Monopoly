import java.util.Random;
import java.util.Scanner;

public class PlayGame {

    public static final int numberOfBoardSectors = 40;
    public static final int boardProperties = 7;
    public static String[] rawInformationBoard = new String[numberOfBoardSectors];
    public static String[][] readyBoard = new String[numberOfBoardSectors][boardProperties];

    public static final int numberCards = 5;
    public static final int cardsPropertiesAmount = 4;

    public static String[] rawCommunityCards = new String[numberCards];
    public static String[][] readyCommunityCards = new String[numberCards][cardsPropertiesAmount];

    public static String[] rawChanceCards = new String[numberCards];
    public static String[][] readyChanceCards = new String[numberCards][cardsPropertiesAmount];

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
    //filledAllProperties

    public static void fillProperties() {
        fillBrownProperties();
        fillLightBlueProperties();
        fillPurpleProperties();
        fillOrangeProperties();
        fillRedProperties();
        fillYellowProperties();
        fillGreenProperties();
        fillDarkBlueProperties();
    }

    public static void fillBrownProperties() {
        rawInformationBoard[1] = "OLD KENT ROAD, property, buy, 60, no owner, brown, 0";
        rawInformationBoard[3] = "WHITECHAPEL ROAD, property, buy, 60, no owner, brown, 0";
    }

    public static void fillLightBlueProperties() {
        rawInformationBoard[6] = "THE ANGEL ISLINGTON, property, buy, 100, no owner, lightblue,0";
        rawInformationBoard[8] = "EUSTON ROAD, property, buy, 100, no owner, lightblue,0";
        rawInformationBoard[9] = "PENTONVILLE ROAD, property, buy, 120, no owner, lightblue,0";
    }

    public static void fillPurpleProperties() {
        rawInformationBoard[11] = "PALL MALL, property, buy, 140, no owner, purple,0";
        rawInformationBoard[13] = "WHITEHALL, property, buy, 140, no owner, purple,0";
        rawInformationBoard[14] = "NORTHUMRL'D AVENUE, property, buy, 160, no owner, purple,0";
    }

    public static void fillOrangeProperties() {
        rawInformationBoard[16] = "BOW STREET, property, buy, 180, no owner, orange,0";
        rawInformationBoard[18] = "MARLBOROUGH STREET, property, buy, 180, no owner, orange,0";
        rawInformationBoard[19] = "VINE STREET, property, buy, 200, no owner, orange,0";
    }

    public static void fillRedProperties() {

        rawInformationBoard[21] = "STRAND, property, buy, 220, no owner, red,0";
        rawInformationBoard[23] = "FLEET STREET, property, buy, 220, no owner, red,0";
        rawInformationBoard[24] = "TRAFALGAR SQUARE, property, buy, 240, no owner, red,0";
    }

    public static void fillYellowProperties() {
        rawInformationBoard[26] = "LEICESTER SQUARE, property, buy, 260, no owner, yellow,0";
        rawInformationBoard[27] = "COVENTRY STREET, property, buy, 260, no owner, yellow,0";
        rawInformationBoard[29] = "PICCADILLY, property, buy, 280, no owner, yellow,0";
    }

    public static void fillGreenProperties() {
        rawInformationBoard[31] = "REGENT STREET, property, buy, 300, no owner, green,0";
        rawInformationBoard[32] = "OXFORD STREET, property, buy, 300, no owner, green,0";
        rawInformationBoard[34] = "BOND STREET, property, buy, 320, no owner, green,0";
    }

    public static void fillDarkBlueProperties() {
        rawInformationBoard[37] = "PARK LANE, property, buy, 350, no owner, darkblue,0";
        rawInformationBoard[39] = "MAYFAIR, property, buy, 400, no owner, darkblue,0";
    }

    public static void fillTrainStations() {
        rawInformationBoard[5] = "KINGS CROSS STATION, station, buy, 200, no owner, -,0";
        rawInformationBoard[15] = "MARYLEBONE STATION, station, buy, 200, no owner, -,0";
        rawInformationBoard[25] = "FENCHURCH ST. STATION, station, buy, 200, no owner, -,0";
        rawInformationBoard[35] = "LIVERPOOL ST. STATION, station, buy, 200, no owner, -,0";
    }

    public static void fillTaxes() {
        rawInformationBoard[4] = "INCOME TAX, station, pay, 200, -, -,0";
        rawInformationBoard[38] = "SUPER TAX, station, pay, 100, -, -,0";
    }

    public static void fillUtilityServices() {
        rawInformationBoard[12] = "ELECTRIC COMPANY, utility, buy, 150, -, -,0";
        rawInformationBoard[28] = "WATER WORKS, utility, buy, 150, -, -,0";
    }

    public static void fillCommunityChests() {
        rawInformationBoard[1] = "COMMUNITY CHEST, chest, draw, -, -, -,0";
        rawInformationBoard[17] = "COMMUNITY CHEST, chest, draw, -, -, -,0";
        rawInformationBoard[33] = "COMMUNITY CHEST, chest, draw, -, -, -,0";
    }

    public static void fillChances() {
        rawInformationBoard[7] = "CHANCE, chance, draw, -, -, -,0";
        rawInformationBoard[22] = "CHANCE, chance, draw, -, -, -,0";
        rawInformationBoard[36] = "CHANCE, chance, draw, -, -, -,0";
    }

    public static void fillStart() {
        rawInformationBoard[0] = "200$ AFTER YOU PASS, go, win, 200, -, -,0";
    }

    public static void fillParkPlace() {
        rawInformationBoard[20] = "FREE PARKING, parking, pay, 0, -, -,0";
    }

    public static void fillJail() {
        rawInformationBoard[10] = "JAIL, jail, jail options, -, -, -,0";
        rawInformationBoard[30] = "GO TO JAIL, imprison, imprison, -, -, -,0";
    }

    public static void fillCommunityCardsInformation() {
        rawCommunityCards[0] = "GET OUT OF JAIL, escape, -, -1 ";
        rawCommunityCards[1] = "ADVANCE TO GO, move, -, 0 ";
        rawCommunityCards[2] = "BANK ERROR IN YOUR FAVOR, win, 200, -1 ";
        rawCommunityCards[3] = "PAY HOSPITAL, pay, 100, -1 ";
    }

    public static void formatCommunityCards() {
        for (int i = 0; i < rawCommunityCards.length; i++) {
            for (int j = 0; j < cardsPropertiesAmount; j++) {
                readyChanceCards[i][j] = rawCommunityCards[i].split(", ")[j];
            }
        }
    }

    public static void fillChanceCardsInformation() {
        rawChanceCards[0] = "GO BACK 3 SPACES, move, -, -3";
        rawChanceCards[1] = "GO DIRECTLY TO JAIL, move, -, 30";
        rawChanceCards[2] = "GO TO PARK LANE, move, -, 37";
        rawChanceCards[3] = "BANK PAYS YOU DIVIDENT, win, 100, -1";

    }

    public static void formatChanceCards() {
        for (int i = 0; i < rawChanceCards.length; i++) {
            for (int j = 0; j < cardsPropertiesAmount; j++) {
                readyChanceCards[i][j] = rawChanceCards[i].split(", ")[j];
            }
        }
    }

    public static void formatBoard() {
        for (int i = 0; i < rawInformationBoard.length; i++) {
            for (int j = 0; j < boardProperties; j++) {
                readyBoard[i][j] = rawInformationBoard[i].split(", ")[j];
            }
        }
    }

    public static void fillTheWholeBoardWithInformation() {
        fillProperties();
        fillStart();
        fillTrainStations();
        fillUtilityServices();
        fillJail();
        fillCommunityChests();
        fillChances();
        fillTaxes();
        fillParkPlace();
    }
    //to here
}
