package e2;

public interface Cell {

    /**
     * @return true if the cell is a mine, false otherwise
     */
    boolean isMine();

    /**
     * @return true if the cell is flagged, false otherwise
     */
    boolean isFlagged();

    /**
     * Switch the flag status of the cell
     */
    void switchFlag();

    /**
     * @return true if the cell is revealed, false otherwise
     */
    boolean isRevealed();

    /**
     * Reveal the cell
     */
    void reveal();
}
