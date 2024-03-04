package e1;

/**
 * Interface that represents a chess piece.
 */
public interface ChessPiece {

    /**
     * Getter for the X coordinate of the piece into the chessboard.
     * @return the X of the piece into the chessboard
     */
    int getRow();

    /**
     * Getter for the Y coordinate of the piece into the chessboard.
     * @return the Y of the piece into the chessboard
     */
    int getColumn();

    /**
     * Setter for the X coordinate of the piece into the chessboard.
     * @param row the new X of the piece into the chessboard
     */
    void setRow(final int row);

    /**
     * Setter for the Y coordinate of the piece into the chessboard.
     * @param column the new Y of the piece into the chessboard
     */
    void setColumn(final int column);

    /**
     * Moves the piece to the specified position.
     * @param row the X to move to into the chessboard
     * @param column the Y to move to into the chessboard
     * @param size the size of the chessboard
     * @return true if the move is done else false
     */
    boolean move(final int row, final int column, final int size);


}
