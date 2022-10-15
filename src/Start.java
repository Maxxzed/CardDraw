import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Start {
    // SETTINGS - ONLY NEED CHANGE HERE
    static int deckSize = 40 ,  amountOfFourtyTwoInTheDeck = 3, amountOfPulls = 5, amountOfTests  = 1000; // deckSize max = 40

    public static void main(String[] args) {
        Stack<Integer> deck = new Stack<>();
        ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();
        for (int i = 0; i < amountOfTests; i++) {
            createDeck(deck);
            allResults.add(pullCards(deck));
            printResults(allResults.get(i));
        }
        System.out.println("----- FIN -----");
        System.out.println("Deck size: " + deckSize);
        System.out.println("Amount of fourtyTwo in the deck: " + amountOfFourtyTwoInTheDeck);
        System.out.println("Amount of pulls: " + amountOfPulls);
        System.out.println("Count of results: " + allResults.size());
        int countfourtyTwo = countResultsWithAtLeastOnefourtyTwo(allResults);
        System.out.println("Count of fourtyTwo: " + countfourtyTwo);
        double averageOfResultsWithAtLeastOnefourtyTwo = ((double) countfourtyTwo / allResults.size()) * 100;
        System.out.println("Average of results that contain at least one fourtyTwo: " + averageOfResultsWithAtLeastOnefourtyTwo + "%");
    }

    public static int countResultsWithAtLeastOnefourtyTwo(ArrayList<ArrayList<Integer>> allResults) {
        int count = 0;
        for (ArrayList<Integer> result : allResults) {
            if (result.contains(42)) {
                count++;
            }
        }
        return count;
    }

    public static void createDeck(Stack<Integer> deck) {
        for (int i = 0; i < deckSize - amountOfFourtyTwoInTheDeck; i++) {
            deck.add(((int) (Math.random() * (40 - 0))) + 0);
        }
        for (int i = 0; i < amountOfFourtyTwoInTheDeck; i++) {
            deck.add(42);
        }
        Collections.shuffle(deck);
    }

    public static ArrayList<Integer> pullCards(Stack<Integer> deck) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < amountOfPulls; i++) {
            results.add(deck.pop());
        }
        return results;
    }

    public static void printResults(ArrayList<Integer> results) {
        for (int i : results) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
