package GameLogic.DynamicParts;

import android.util.Log;

import java.util.ArrayList;
import GameLogic.StaticParts.Card;
import GameLogic.StaticParts.GameCard;
import GameLogic.StaticParts.SkipBoCard;

/**
 * The Stacks class represents a stack of cards in the game.
 * It contains a list of GameCards, which can be either SkipBoCards or Cards.
 */
public class Stacks {

    /** The list of GameCards in the stack. */
    private ArrayList<GameCard> playerStack = new ArrayList<>();

    /**
     * Returns the list of GameCards in the stack.
     * @return the list of GameCards in the stack.
     */
    public ArrayList<GameCard> getPlayerStack() {
        return playerStack;
    }

    /**
     * Returns the top card of the stack.
     * If the top card is a SkipBoCard, it is cast to a SkipBoCard and returned.
     * If the top card is a Card, it is cast to a Card and returned.
     * @return the top card of the stack.
     */
    public GameCard getTopCard() {
        try {
            GameCard card = playerStack.get(playerStack.size() - 1);
            if (card instanceof SkipBoCard) {
                return (SkipBoCard) card;
            } else {
                return (Card) card;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("PlayerStack empty");
            return null; // or some better value
        }
    }


    /**
     * Prints the size of the stack and the top card.
     */
    public String getPlayerStackAsString() {
        String playerStackString = "";
        try {
            playerStackString = "Size of stack:" + getPlayerStackSize() + "\t Top card:" + getTopCard().toString();
        } catch (IndexOutOfBoundsException e) {
            Log.e("getPlayerStackAsString", "Index out of bounds exception occurred", e);
        } catch (Exception e) {
            Log.e("getPlayerStackAsString", "Exception occurred", e);
        }
        return playerStackString;
    }


    public int getPlayerStackSize(){
        return playerStack.size();
    }


}
