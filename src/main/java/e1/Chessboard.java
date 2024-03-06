package e1;

/**
 * Interface that provides position generation for chess pieces.
 */
public interface Chessboard {

    /**
     * Generates a random empty position.
     * @return a pair of integers representing the position
     */
    Pair<Integer,Integer> randomEmptyPosition();

}
