import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Deck {
    Scanner input = new Scanner(System.in);

    public void displayDeck(Vector<Card> deck) {
        System.out.println("deck is :");
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public void shuffleDeck(Vector<Card> deck) {
        Collections.shuffle(deck);
        System.out.println("Deck shuffled");
        displayDeck(deck);
    }

    public void drawCard(Vector<Card> deck) {
        System.out.println("Enter a number to draw a card :");
        int position = input.nextInt();
        Card singleCard = deck.get(position);
        deck.remove(position);
        System.out.println("You picked " + singleCard);
    }

    public void emptyDeck(Vector<Card> deck) {
        deck.removeAllElements();
        System.out.println("Deck is empty.");
    }

    public void printCard(Vector<Card> deck) {
        System.out.println("Take position to print card");
        int position = input.nextInt();
        Card singleCard = deck.get(position);
        System.out.println(singleCard);
    }

    public void compareCard(Vector<Card> deck) {
        System.out.println("Draw 1st card ");
        int position = input.nextInt();
        Card firstCard = deck.get(position);
        System.out.println("Draw 2nd card ");
        position = input.nextInt();
        Card secondCard = deck.get(position);
        if (firstCard.getRank() > secondCard.getRank())
            System.out.println("highest " + firstCard);
        else if (firstCard.getRank() == secondCard.getRank())
            System.out.println("Equal cards");
        else
            System.out.println("Highest " + secondCard);

    }

    public void dealCard(Vector<Card> deck) {
        Card card = deck.get(0);
        deck.remove(0);
        System.out.println(card);
    }

    public void sameCard(Vector<Card> deck) {

        System.out.println("Draw 1st card ");
        int position = input.nextInt();
        Card firstCard = deck.get(position);
        System.out.println("Draw 2nd card ");
        position = input.nextInt();
        Card secondCard = deck.get(position);

        if (firstCard.getRank() == secondCard.getRank() && firstCard.getSuit() == secondCard.getSuit())
            System.out.println("cards are same");
        else
            System.out.println("cards are not same");
    }

    public void findCard(Vector<Card> deck) {
        System.out.println("Enter card details to find :");
        System.out.println("Enter rank :");
        int rank = input.nextInt();
        System.out.println("Enter Suite :");
        input.nextLine();
        String suit = input.nextLine();
        String full_card = rank + "" + " " + suit;
        for (Card card : deck) {
            int rnk = card.getRank();
            String sui = card.getSuit();
            String crd = rnk + "" + " " + sui;
            if (crd.equals(full_card)) {
                System.out.println("Card is present");
                return;
            }
        }
        System.out.println("Card not found");

    }

    public void createDeck() {

        Vector<Card> deck = new Vector<Card>(52);

        // populate the deck with cards

        for (int rank = 1; rank <= 13; rank++) {
            for (String suit : Card.suits) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }

        // display the menu
        while (true) {
            System.out.println("***************************\n");
            System.out.println("1. Display the deck of cards");
            System.out.println("2. Shuffle the deck of cards");
            System.out.println("3. Draw a card from the deck");
            System.out.println("4. Empty the deck");
            System.out.println("5. Print a card from the deck");
            System.out.println("6. Compare two cards");
            System.out.println("7. Check if two cards are same");
            System.out.println("8. Find card by rank and suit");
            System.out.println("9. Deal a hand of cards");
            System.out.println("10. Quit");
            // get user choice
            System.out.print("Enter your choice (1-10): ");
            int choice = input.nextInt();

            System.out.println("***************************\n");

            // handle user choice
            switch (choice) {
                case 1:
                    displayDeck(deck);
                    break;
                case 2:
                    shuffleDeck(deck);
                    break;
                case 3:
                    drawCard(deck);
                    break;
                case 4:
                    emptyDeck(deck);
                    break;
                case 5:
                    printCard(deck);
                    break;
                case 6:
                    compareCard(deck);
                    break;
                case 7:
                    sameCard(deck);
                    break;
                case 8:
                    findCard(deck);
                    break;
                case 9:
                    dealCard(deck);
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
