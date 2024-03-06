package e1;

import java.util.List;

/**
 * Interface that provides position generation for chess pieces.
 */
public interface Chessboard {

    /**
     * Generates a random empty position.
     * @return a pair of integers representing the position
     * @throws IllegalStateException if the chessboard is full
     */
    Pair<Integer,Integer> randomEmptyPosition() throws IllegalStateException;

    /**
     * Returns the pieces on the chessboard.
     * @return the list of pieces on the chessboard
     */
    List<ChessPiece> getPieces();

    /**
     * Adds a piece to the chessboard.
     * @param piece the piece to add
     * @throws IllegalStateException if the chessboard is full
     */
    void addPiece(ChessPiece piece) throws IllegalStateException;

    /**
     * Removes a piece from the chessboard.
     * @param row the row of the piece
     * @param column the column of the piece
     * @return the removed piece
     * @throws IllegalArgumentException if the piece is not found
     */
    ChessPiece removePiece(int row, int column) throws IllegalArgumentException;

}
