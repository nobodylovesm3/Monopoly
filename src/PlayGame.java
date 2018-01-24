import java.util.Random;
import java.util.Scanner;

public class PlayGame {

    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);

    public static final int numberOfBoardSectors = 40;
    public static final int boardProperties = 7;
    public static String[] rawInformationBoard = new String[numberOfBoardSectors];
    public static String[][] readyBoard = new String[numberOfBoardSectors][boardProperties];

    public static final int numberCards = 4;
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

    public static int choice;

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
    public static String sectorColor;
    public static String sectorBuildingsCounter;

    public static boolean isReady = false;
    public static boolean hasWon = false;

    public static boolean[] isBankrupted = new boolean[maxAmountOfPlayers];
    public static int numberBankruptedPlayers = defaultStartPosition;

    public static boolean[] hasGetOutOfJailCard = new boolean[maxAmountOfPlayers];
    public static int[] spentRoundsInJail = {defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition, defaultStartPosition};
    public static boolean[] isInJail = new boolean[maxAmountOfPlayers];

    public static void main(String[] args) {
        prepareGameBoardInformation();
        inputPlayersNumber();
        int[] playerLocation = new int[playersAmount];
        inputPlayersNames();
        startGame(playerLocation);
    }

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
        rawInformationBoard[6] = "THE ANGEL ISLINGTON, property, buy, 100, no owner, lightblue, 0";
        rawInformationBoard[8] = "EUSTON ROAD, property, buy, 100, no owner, lightblue, 0";
        rawInformationBoard[9] = "PENTONVILLE ROAD, property, buy, 120, no owner, lightblue, 0";
    }

    public static void fillPurpleProperties() {
        rawInformationBoard[11] = "PALL MALL, property, buy, 140, no owner, purple, 0";
        rawInformationBoard[13] = "WHITEHALL, property, buy, 140, no owner, purple, 0";
        rawInformationBoard[14] = "NORTHUMRL'D AVENUE, property, buy, 160, no owner, purple, 0";
    }

    public static void fillOrangeProperties() {
        rawInformationBoard[16] = "BOW STREET, property, buy, 180, no owner, orange, 0";
        rawInformationBoard[18] = "MARLBOROUGH STREET, property, buy, 180, no owner, orange, 0";
        rawInformationBoard[19] = "VINE STREET, property, buy, 200, no owner, orange, 0";
    }

    public static void fillRedProperties() {

        rawInformationBoard[21] = "STRAND, property, buy, 220, no owner, red, 0";
        rawInformationBoard[23] = "FLEET STREET, property, buy, 220, no owner, red, 0";
        rawInformationBoard[24] = "TRAFALGAR SQUARE, property, buy, 240, no owner, red, 0";
    }

    public static void fillYellowProperties() {
        rawInformationBoard[26] = "LEICESTER SQUARE, property, buy, 260, no owner, yellow, 0";
        rawInformationBoard[27] = "COVENTRY STREET, property, buy, 260, no owner, yellow, 0";
        rawInformationBoard[29] = "PICCADILLY, property, buy, 280, no owner, yellow, 0";
    }

    public static void fillGreenProperties() {
        rawInformationBoard[31] = "REGENT STREET, property, buy, 300, no owner, green, 0";
        rawInformationBoard[32] = "OXFORD STREET, property, buy, 300, no owner, green, 0";
        rawInformationBoard[34] = "BOND STREET, property, buy, 320, no owner, green, 0";
    }

    public static void fillDarkBlueProperties() {
        rawInformationBoard[37] = "PARK LANE, property, buy, 350, no owner, darkblue, 0";
        rawInformationBoard[39] = "MAYFAIR, property, buy, 400, no owner, darkblue, 0";
    }

    public static void fillTrainStations() {
        rawInformationBoard[5] = "KINGS CROSS STATION, station, buy, 200, no owner, -, 0";
        rawInformationBoard[15] = "MARYLEBONE STATION, station, buy, 200, no owner, -, 0";
        rawInformationBoard[25] = "FENCHURCH ST. STATION, station, buy, 200, no owner, -, 0";
        rawInformationBoard[35] = "LIVERPOOL ST. STATION, station, buy, 200, no owner, -, 0";
    }

    public static void fillTaxes() {
        rawInformationBoard[4] = "INCOME TAX, station, pay, 200, -, -, 0";
        rawInformationBoard[38] = "SUPER TAX, station, pay, 100, -, -, 0";
    }

    public static void fillUtilityServices() {
        rawInformationBoard[12] = "ELECTRIC COMPANY, utility, buy, 150, -, -, 0";
        rawInformationBoard[28] = "WATER WORKS, utility, buy, 150, -, -, 0";
    }

    public static void fillCommunityChests() {
        rawInformationBoard[2] = "COMMUNITY CHEST, chest, draw community chest card, -, -, -, 0";
        rawInformationBoard[17] = "COMMUNITY CHEST, chest, draw community chest card, -, -, -, 0";
        rawInformationBoard[33] = "COMMUNITY CHEST, chest, draw community chest card, -, -, -, 0";
    }

    public static void fillChances() {
        rawInformationBoard[7] = "CHANCE, chance, draw chance card, -, -, -, 0";
        rawInformationBoard[22] = "CHANCE, chance, draw chance card, -, -, -, 0";
        rawInformationBoard[36] = "CHANCE, chance, draw chance card, -, -, -, 0";
    }

    public static void fillStart() {
        rawInformationBoard[0] = "200$ AFTER YOU PASS, go, win, 200, -, -, 0";
    }

    public static void fillParkPlace() {
        rawInformationBoard[20] = "FREE PARKING, parking, pay, 0, -, -, 0";
    }

    public static void fillJail() {
        rawInformationBoard[10] = "JAIL, jail, jail options, -, -, -, 0";
        rawInformationBoard[30] = "GO TO JAIL, imprison, imprison, -, -, -, 0";
    }

    public static void fillCommunityCardsInformation() {
        rawCommunityCards[0] = "GET OUT OF JAIL, escape, -, -1";
        rawCommunityCards[1] = "ADVANCE TO GO, move, -, 0 ";
        rawCommunityCards[2] = "BANK ERROR IN YOUR FAVOR, win, 200, -1";
        rawCommunityCards[3] = "PAY HOSPITAL, pay, 100, -1";
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

    public static void inputPlayersNumber() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of players: (max 8, min 2) ");
        int numberOfPlayers = 0;

        while (true) {
            try {
                numberOfPlayers = Integer.parseInt(input.nextLine());
                if (numberOfPlayers > 2 && numberOfPlayers < 9) {
                    break;
                } else {
                    System.out.println("Max players - 8, min players - 2. ");
                }
            } catch (Exception e) {
                System.out.println("Max players - 8, min players - 2. ");
            }
        }

        System.out.println();
    }

    public static void inputPlayersNames() {
        System.out.println("Enter your names.");
        for (int i = 0; i < playersAmount; i++) {
            System.out.println("Player " + (i + 1) + " : ");
            playersNames[i] = input.nextLine();
            System.out.println();
        }
    }


    public static int diceRoll() {
        return rand.nextInt(6) + 1;
    }

    public static void outputResultDiceOne(int index) {
        System.out.println("You rolled (first dice): " + firstDiceThrows[index]);
    }

    public static void outputResultDiceTwo(int index) {
        System.out.println("You rolled (second dice): " + secondDiceThrows[index]);
    }

    public static boolean hasMadeFullLap(int[] playerLocation, int i) {
        return playerLocation[i] + firstDiceThrows[i] + secondDiceThrows[i] >= numberOfBoardSectors;
    }

    public static void outputPlayerCurrentLocation(int[] playerLocation, int i) {
        System.out.println("Location: " + playerLocation[i] + " " + readyBoard[playerLocation[i]][0] + ", " + readyBoard[playerLocation[i]][1] + ", " + readyBoard[playerLocation[i]][2] + ", " + readyBoard[playerLocation[i]][3] + ", " + readyBoard[playerLocation[i]][4] + ", " + readyBoard[playerLocation[i]][5] + ", " + readyBoard[playerLocation[i]][6]);
    }

    public static boolean isSectorOwned() {
        return !sectorOwnership.equals("no owner");
    }

    public static boolean isSectorPurchasable() {
        return sectorAction.equals("buy");
    }

    public static boolean isGoingToJail() {
        return sectorAction.equals("imprison");
    }

    public static void getCurrentSectorInformation(int[] playerLocation, int i) {
        sectorAction = readyBoard[playerLocation[i]][2];
        sectorCost = readyBoard[playerLocation[i]][3];
        sectorOwnership = readyBoard[playerLocation[i]][4];
        sectorColor = readyBoard[playerLocation[i]][5];
        sectorBuildingsCounter = readyBoard[playerLocation[i]][6];
    }

    public static void updateIrrelevantSectorsInformation(int[] playerLocation, int i) {
        if (!sectorOwnership.equals("-") && !sectorCost.equals("-")) {
            readyBoard[playerLocation[i]][3] = sectorCost;
            readyBoard[playerLocation[i]][4] = sectorOwnership;
        }
    }

    public static void drawCommunityChestCards() {
        cardNumber = rand.nextInt(4);
        cardName = readyCommunityCards[cardNumber][0];
        cardAction = readyCommunityCards[cardNumber][1];
        cardLoseWinMoney = readyCommunityCards[cardNumber][2];
        cardChangePlayerPosition = readyCommunityCards[cardNumber][3];
    }

    public static void drawChanceCards() {
        cardNumber = rand.nextInt(4);
        cardName = readyChanceCards[cardNumber][0];
        cardAction = readyChanceCards[cardNumber][1];
        cardLoseWinMoney = readyChanceCards[cardNumber][2];
        cardChangePlayerPosition = readyChanceCards[cardNumber][3];
    }

    public static void winMoneyCard(int i) {
        if (cardAction.equals("win")) {
            System.out.println("You won " + cardLoseWinMoney + "$.");
            playersMoney[i] += Integer.parseInt(cardLoseWinMoney);
        }
    }


    public static void loseMoneyCard(int i) {
        if (cardAction.equals("pay")) {
            System.out.println("You lost " + cardLoseWinMoney + "$.");
            playersMoney[i] -= Integer.parseInt(cardLoseWinMoney);
        }
    }

    public static void escapeOutOfJailCardDraw(int i) {
        if (cardAction.equals("escape")) {
            hasGetOutOfJailCard[i] = true;
        }
    }

    public static void payMoneyOutput(int i) {
        if (sectorAction.equals("pay")) {
            System.out.println(playersNames[i] + " paid " + sectorCost + "$.");
            playersMoney[i] -= Integer.parseInt(sectorCost);
        }
    }

    public static void winMoneyOutput(int i) {
        if (sectorAction.equals("win")) {
            System.out.println(playersNames[i] + " won " + sectorCost + "$.");
            playersMoney[i] += Integer.parseInt(sectorCost);
        }
    }

    private static void rowTheDices(int i) {
        System.out.println("Press enter to row the dice: ");
        String readString = null;
        readString = input.nextLine();
        while (readString != null) {
            if (readString.isEmpty()) {
                int hello = 3;
                System.out.println(hello);
                break;
            }

            if (input.hasNextLine()) {
                readString = input.nextLine();
            } else {
                readString = null;
            }
        }
    }

    public static void checkBankruptedPlayer(int i) {
        if (playersMoney[i] < 0) {
            if (!isBankrupted[i]) {
                numberBankruptedPlayers++;
            }
            isBankrupted[i] = true;
        }

        if (isBankrupted[i]) {
            System.out.println(playersNames[i] + "'s bankrupted and cannot play anymore.");
            System.out.println();
        }
    }

    public static boolean checkWhetherAllPlayersHaveBankrupted() {
        boolean isEveryPlayerBankrupted = true;
        for (int i = 0; i < playersAmount; i++) {
            if (playersMoney[i] >= 0) {
                isEveryPlayerBankrupted = false;
                break;
            }
        }

        return isEveryPlayerBankrupted;
    }

    public static void calculatePositionAfterThrownDice(int[] playerLocation, int i) {
        if (!hasMadeFullLap(playerLocation, i)) {
            playerLocation[i] += firstDiceThrows[i] + secondDiceThrows[i];
        } else {
            playerLocation[i] = (-1) * (numberOfBoardSectors - (playerLocation[i] + firstDiceThrows[i] + secondDiceThrows[i]));
        }
    }

    public static void printMoney(int i) {
        System.out.println("Money: " + playersMoney[i] + "$.");
    }

    public static void prepareGameBoardInformation() {
        fillTheWholeBoardWithInformation();
        formatBoard();

        fillCommunityCardsInformation();
        formatCommunityCards();

        fillChanceCardsInformation();
        formatChanceCards();
    }

    public static void isOnlyOnePlayerLeft(int i) {
        if (playersAmount - numberBankruptedPlayers <= 1) {
            for (int index = 0; index < playersAmount; index++) {
                if (!isBankrupted[index]) {
                    System.out.println("Congrats! " + playersNames[index] + " has won the game!");
                    break;
                }
            }
            System.out.println();
            hasWon = true;
        }
    }

    public static void proceedWithTurns(int[] playerLocation, int i) {
        calculatePositionAfterThrownDice(playerLocation, i);
        outputPlayerCurrentLocation(playerLocation, i);
        printMoney(i);
        decideWhatToDo(playerLocation, i);
    }

    public static void goToJail(int[] playerLocation, int i) {
        System.out.println(playersNames[i] + " has been in jail for " + spentRoundsInJail[i] + " turns.");
        System.out.println("You can:\n(1) try to throw a pair;\n(2) bribe the guard with 100$;\n(3) wait it out(released after " + (3 - spentRoundsInJail[i]) + " turns);\n(4) use a 'Get Out Of Jail' card if you have one.");

        int decision;
        do {
            while (true) {
                try {
                    decision = Integer.parseInt(input.nextLine());
                    if (decision > 0) {
                        break;
                    } else {
                        System.out.println("Input either 1, 2, 3 or 4 (option).");
                    }
                } catch (Exception e) {
                    System.out.println("Input either 1, 2, 3 or 4 (option).");
                }
            }
            switch (decision) {
                case 1: {
                    rowTheDices(i);
                    if (firstDiceThrows[i] == secondDiceThrows[i]) {
                        System.out.println(playersNames[i] + " threw a pair and successfully escaped!");
                        isInJail[i] = false;
                        spentRoundsInJail[i] = 0;
                        proceedWithTurns(playerLocation, i);
                    } else {
                        spentRoundsInJail[i]++;
                    }
                }
                break;
                case 2: {
                    if (playersMoney[i] >= 100) {
                        System.out.println(playersNames[i] + " successfully bribed the guard and escaped!");
                        playersMoney[i] -= 100;
                        isInJail[i] = false;
                        spentRoundsInJail[i] = 0;

                        rowTheDices(i);

                        //check for pair
                        proceedWithTurns(playerLocation, i);
                    } else {
                        System.out.println(playersNames[i] + " doesn't have enough money. ");
                        spentRoundsInJail[i]++;
                    }
                    break;
                }

                case 3: {
                    spentRoundsInJail[i]++;
                    break;
                }
                case 4: {
                    if (hasGetOutOfJailCard[i]) {
                        System.out.println(playersNames[i] + " used the 'Get Out Of Jail' card and escaped!");
                        isInJail[i] = false;
                        spentRoundsInJail[i] = 0;
                        hasGetOutOfJailCard[i] = false;

                        rowTheDices(i);

                        proceedWithTurns(playerLocation, i);
                    } else {
                        System.out.println(playersNames[i] + " doesn't have the 'Get Out Of Jail Card'.");
                        spentRoundsInJail[i]++;
                    }
                    break;
                }
            }

        }
        while (decision != 1 && (decision != 2 && playersMoney[i] < 100) && decision != 3 && (decision != 4 && !hasGetOutOfJailCard[i]));

        playerLocation[i] = 10;

        if (spentRoundsInJail[i] >= maxRoundsInJail) {
            isInJail[i] = false;
            spentRoundsInJail[i] = 0;

            rowTheDices(i);

            proceedWithTurns(playerLocation, i);
        }
    }

    private static void decideWhatToDo(int[] playerLocation, int i) {
        getCurrentSectorInformation(playerLocation, i);

        if (isGoingToJail() || isInJail[i]) {
            goToJail(playerLocation, i);
        }

        if (!isInJail[i]) {
            if (sectorAction.equals("draw community chest card")) {
                drawCommunityChestCards();

                System.out.println(playersNames[i] + " drew the " + cardName + " card.");

                winMoneyCard(i);
                loseMoneyCard(i);
                escapeOutOfJailCardDraw(i);
                positionChangeCardDraw(playerLocation, i);
            }

            if (sectorAction.equals("draw chance card")) {
                drawChanceCards();

                System.out.println(playersNames[i] + " drew the " + cardName + " card.");

                winMoneyCard(i);
                loseMoneyCard(i);
                escapeOutOfJailCardDraw(i);
                positionChangeCardDraw(playerLocation, i);
            }
        }

        if (!isInJail[i]) {
            winMoneyOutput(i);

            payMoneyOutput(i);
        }

        if (!isInJail[i]) {
            purchasableSectorsOptions(i);
        }
        System.out.println("What will you decide:\n(1)proceed further\n(2)check your current options");
        isReady = false;

        proceedFurtherOrCheckOptions(i);

        updateIrrelevantSectorsInformation(playerLocation, i);
        System.out.println("*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!");
        System.out.println();
    }

    public static void proceedFurtherOrCheckOptions(int i) {
        do {
            while (true) {
                try {
                    choice = input.nextInt();
                    if (choice == 1 || choice == 2) {
                        break;
                    } else {
                        System.out.println("Input either:\n(1) to proceed further;\n(2) to check your current options");
                    }
                } catch (Exception e) {
                    System.out.println("Input either:\n(1) to proceed further;\n(2) to check your current options");
                }
                System.out.println();
            }

            if (choice == 1) {
                isReady = true;
            } else if (choice == 2) {
                System.out.println("The available options for building and selling houses (shown if you own all properties from at least one color):");
                goThroughOptions(i);
                isReady = false;
            }
        } while (!isReady);


    }

    private static void goThroughOptions(int i) {
        System.out.println("not yet");
    }

    public static void positionChangeCardDraw(int[] playerLocation, int i) {
        if (cardAction.equals("move")) {
            if (Integer.parseInt(cardChangePlayerPosition) > -1) {
                playerLocation[i] = Integer.parseInt(cardChangePlayerPosition);

                if (playerLocation[i] == 30) {
                    goToJail(playerLocation, i);
                }
            } else if (Integer.parseInt(cardChangePlayerPosition) < -1) {
                playerLocation[i] += Integer.parseInt(cardChangePlayerPosition);
            }
        }
    }

    public static void checkForSeriesMatchingDices(int[] playerLocation, int i) {
        if (firstDiceThrows[i] == secondDiceThrows[i]) {
            System.out.println(playersNames[i] + " threw a pair!");
            countDicePairsThrownInRow[i]++;
        } else {
            countDicePairsThrownInRow[i] = defaultStartPosition;
        }

        if (countDicePairsThrownInRow[i] == maxTimesDiceThrows) {
            System.out.println(playersNames[i] + " threw 3 pairs in a row and is being sent to jail.");
            countDicePairsThrownInRow[i] = defaultStartPosition;
            goToJail(playerLocation, i);
        } else if (countDicePairsThrownInRow[i] < maxTimesDiceThrows && countDicePairsThrownInRow[i] >= 1) {
            System.out.println(playersNames[i] + " can throw again.");
        }
    }

    public static void makeTurn(int[] playerLocation) {
        for (int i = 0; i < playersAmount; i++) {
            if (checkWhetherAllPlayersHaveBankrupted()) {
                System.out.println("All players have bankrupted - no winner.");
                hasWon = true;
                break;
            }
            checkBankruptedPlayer(i);

            if (isBankrupted[i]) {
                continue;
            }

            isOnlyOnePlayerLeft(i);

            if (hasWon) {
                break;
            }

            System.out.println(playersNames[i] + " 's turn: ");

            for (int repeats = 0; repeats <= countDicePairsThrownInRow[i]; repeats++) {
                if (countDicePairsThrownInRow[i] < 3) {
                    if (!isInJail[i]) {
                        rowTheDices(i);
                        checkForSeriesMatchingDices(playerLocation, i);
                        calculatePositionAfterThrownDice(playerLocation, i);
                    }

                    outputPlayerCurrentLocation(playerLocation, i);
                    printMoney(i);
                    decideWhatToDo(playerLocation, i);
                }
            }
        }
    }

    public static void printNextTurn() {
        System.out.println("******************************************************************************************************************");
        System.out.println();

        System.out.println("Turn: " + (++allTurns));
    }

    public static void startGame(int[] playerLocation) {
        while (!hasWon) {
            printNextTurn();
            makeTurn(playerLocation);
        }
    }

    public static void doAuction() {
        boolean[] isPlayerNotParticipatingInTheAuction = new boolean[playersAmount];
        int[] bids = new int[playersAmount];
        for (int i = 0; i < isPlayerNotParticipatingInTheAuction.length; i++) {
            isPlayerNotParticipatingInTheAuction[i] = false;
            bids[i] = 0;
        }
        int highestBid = defaultStartPosition;
        int decision = -1;
        int amountOfParticipatingPlayers = playersAmount;
        boolean isWinnerFound = false;
        while (amountOfParticipatingPlayers != 1 || !isWinnerFound) {
            for (int i = 0; i < playersAmount; i++) {
                if (isPlayerNotParticipatingInTheAuction[i] == false) {
                    System.out.println(playersNames[i] + "'s turn.");
                    System.out.println("Currently bidding: " + amountOfParticipatingPlayers);
                    if (amountOfParticipatingPlayers <= 1) {
                        System.out.println("Only 1 player is bidding - " + playersNames[i] + " won the property for " + highestBid + ".");
                        playersMoney[i] -= highestBid;
                        sectorOwnership = playersNames[i];
                        isWinnerFound = true;
                        break;
                    }
                    System.out.println("Would you like to:\n(1) bid;\n(2) leave?");
                    while (true) {
                        try {
                            decision = Integer.parseInt(input.nextLine());
                            if (decision == 0 || decision == 1) {
                                break;
                            } else {
                                System.out.println("Input either 1 or 0.");
                            }
                        } catch (Exception e) {
                            System.out.println("Input either 1 or 0.");
                        }
                    }
                    if (decision == 1) {
                        System.out.println("Enter your bid (has to be over " + highestBid + ", you can bail out by bidding below 0): ");
                        do {
                            while (true) {
                                try {
                                    bids[i] = Integer.parseInt(input.nextLine());
                                    if (bids[i] < 0 || bids[i] > highestBid) {
                                        break;
                                    } else {
                                        System.out.println("Input a number smaller than 0 to bail out or a number higher than " + highestBid + " to bid.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Input a number smaller than 0 to bail out or a number higher than " + highestBid + " to bid.");
                                }
                            }
                            if (bids[i] < 0) {
                                amountOfParticipatingPlayers--;
                                isPlayerNotParticipatingInTheAuction[i] = true;
                                System.out.println(playersNames[i] + " left the auction.");
                            } else {
                                System.out.println(playersNames[i] + " bid " + bids[i]);
                            }
                        } while (bids[i] <= highestBid && !isPlayerNotParticipatingInTheAuction[i]);
                        if (highestBid < bids[i]) {
                            highestBid = bids[i];
                        }
                    } else if (decision == 0) {
                        amountOfParticipatingPlayers--;
                        isPlayerNotParticipatingInTheAuction[i] = true;
                        System.out.println(playersNames[i] + " left the auction.");
                    }
                }
            }
        }
    }

    public static void purchasableSectorsOptions(int i) {
        if (isSectorPurchasable()) {
            if (!isSectorOwned()) {
                System.out.println("You can either:\n (1) buy the property for " + sectorCost + "$;\n(2) start an auction for it.");
                while (true) {
                    try {
                        choice = Integer.parseInt(input.nextLine());
                        if (choice == 1 || choice == 2) {
                            break;
                        } else {
                            System.out.println("Input either:\n(1) to purchase the property;\n(2) to start an auction.");
                        }
                    } catch (Exception e) {
                        System.out.println("Input either:\n(1) to purchase the property;\n(2) to start an auction.");
                    }
                }
                if (choice == 1) {
                    playersMoney[i] -= Integer.parseInt(sectorCost);
                    sectorOwnership = playersNames[i];
                } else if (choice == 2) {
                    System.out.println("Auction!");
                    doAuction();
                }
            } else {
                if (!sectorOwnership.equals(playersNames[i])) {
                    playersMoney[i] -= (Integer.parseInt(sectorCost) / 10) + ((Integer.parseInt(readyBoard[i][6]) * (Integer.parseInt(sectorCost) / 2)));

                    int sectorOwnerIndex = 0;
                    while (playersNames[sectorOwnerIndex] != sectorOwnership) {
                        sectorOwnerIndex++;
                    }
                    System.out.println(playersNames[i] + " paid " + playersNames[sectorOwnerIndex] + " " + (Integer.parseInt(sectorCost) / 10) + ((Integer.parseInt(readyBoard[i][6]) * (Integer.parseInt(sectorCost) / 2))) + "$");
                    playersMoney[i] += (Integer.parseInt(sectorCost) / 10);
                } else {
                    System.out.println(playersNames[i] + " is waiting for their next turn on their property.");
                }
            }
        }
    }
//to here
}
