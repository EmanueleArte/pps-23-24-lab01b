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
     * @param x the new X of the piece into the chessboard
     */
    void setRow(final int x);

    /**
     * Setter for the Y coordinate of the piece into the chessboard.
     * @param y the new Y of the piece into the chessboard
     */
    void setColumn(final int y);


}
