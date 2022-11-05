import java.util.Scanner;

public class Blackjack {

    public static void printMenu() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit" + "\n");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {

        P1Random rng = new P1Random();
        Scanner scnr = new Scanner(System.in);

        int menuChoice = 1;
        int gameNumber = 0;
        int numWins = 0;
        int dealerWins = 0;
        int numTies = 0;
        int currentHand = 0;
        int dealerHand = 0;
        int cardNumber = 0;
        float winRate = 0;

        while (menuChoice != 4) {

            if (currentHand == 0) {
                System.out.println("START GAME #" + (gameNumber + 1) + "\n");
            }

            if (menuChoice == 1) {

                cardNumber = rng.nextInt(13) + 1;

                if (cardNumber > 1 && cardNumber < 11) {
                    currentHand = currentHand + cardNumber;
                    System.out.println("Your card is a " + cardNumber + "!");
                    System.out.println("Your hand is: " + currentHand + "\n");
                }
                else if (cardNumber == 1) {
                    currentHand = currentHand + cardNumber;
                    System.out.println("Your card is a ACE!");
                    System.out.println("Your hand is: " + currentHand + "\n");
                }
                else if (cardNumber == 11) {
                    currentHand = currentHand + 10;
                    System.out.println("Your card is a JACK!");
                    System.out.println("Your hand is: " + currentHand + "\n");
                }
                else if (cardNumber == 12) {
                    currentHand = currentHand + 10;
                    System.out.println("Your card is a QUEEN!");
                    System.out.println("Your hand is: " + currentHand + "\n");
                }
                else if (cardNumber == 13) {
                    currentHand = currentHand + 10;
                    System.out.println("Your card is a KING!");
                    System.out.println("Your hand is: " + currentHand + "\n");
                }

                if (currentHand == 21) {
                    System.out.println("BLACKJACK! You win!" + "\n");
                    numWins = numWins + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }
                else if (currentHand > 21) {
                    System.out.println("You exceeded 21! You lose." + "\n");
                    dealerWins = dealerWins + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }
                else if (currentHand < 21) {
                    printMenu();
                    menuChoice = scnr.nextInt();
                    System.out.println("");
                }

            }

            else if (menuChoice == 2) {

                dealerHand = rng.nextInt(11) + 16;

                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + currentHand + "\n");

                if (dealerHand > 21) {
                    System.out.println("You win!" + "\n");
                    numWins = numWins + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }
                else if (currentHand > dealerHand) {
                    System.out.println("You win!" + "\n");
                    numWins = numWins + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }
                else if (currentHand < dealerHand) {
                    System.out.println("Dealer wins!" + "\n");
                    dealerWins = dealerWins + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }
                else if (currentHand == dealerHand) {
                    System.out.println("It's a tie! No one wins!" + "\n");
                    numTies = numTies + 1;
                    gameNumber = gameNumber + 1;
                    currentHand = 0;
                    dealerHand = 0;
                }

                menuChoice = 1;

            }

            else if (menuChoice == 3) {

                winRate = ((float) (numWins) / (float) (gameNumber)) * (100);

                System.out.println("Number of Player wins: " + numWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + numTies);
                System.out.println("Total # of games played is: " + gameNumber);
                System.out.print("Percentage of Player wins: ");
                System.out.printf("%.1f", winRate);
                System.out.println("%" + "\n");

                printMenu();
                menuChoice = scnr.nextInt();
                System.out.println("");

            }

            else if (menuChoice < 1 || menuChoice > 4) {

                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4." + "\n");

                printMenu();
                menuChoice = scnr.nextInt();
                System.out.println("");

            }

        }

    }

}
