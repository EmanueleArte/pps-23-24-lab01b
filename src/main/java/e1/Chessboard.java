package e1;

import java.util.List;

/**
 * Interface that provides position generation for chess pieces.
 */
public interface Chessboard {

    /**
     * Generates a random empty position.
     * @return a pair of integers representing the position
     */
    Pair<Integer,Integer> randomEmptyPosition();

    /**
     * Returns the pieces on the chessboard.
     * @return the list of pieces on the chessboard
     */
    List<ChessPiece> getPieces();

    /**
     * Adds a piece to the chessboard.
     * @param piece the piece to add
     */
    void addPiece(ChessPiece piece);

}
