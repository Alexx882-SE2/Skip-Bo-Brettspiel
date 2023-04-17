package GameLogic.StaticParts;
/**
 * The SkipBoCard class represents a single Skip-Bo card.
 * This class ensures that no more than 12 instances of SkipBoCard can be created.
 */
public class SkipBoCard extends GameCard{
    /** The number of instances of SkipBoCard that have been created. */
    private static int instanceCount = 0;


    /**
     * Constructs a new SkipBoCard instance.
     * @throws IllegalStateException if more than 12 instances of SkipBoCard have been created.
     */

    public SkipBoCard() {
        if (instanceCount >= 12) {
            throw new IllegalStateException("Only 12 instances of SkipBoCard can be created.");
        }
        instanceCount++;
    }
}
