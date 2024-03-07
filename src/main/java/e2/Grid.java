package e2;

public interface Grid {

    /**
     * Returns the number of mines not already flagged in the grid.
     *
     * @return the number of not flagged mines in the grid
     */
    int getMines();

    /**
     * Returns the size of the grid.
     *
     * @return the size of the grid
     */
    int getSize();

    /**
     * Checks if the cell at the given position is a mine.
     *
     * @param pos the position of the cell to be selected
     * @return true if a mine was found, false otherwise
     */
    boolean isMine(Pair<Integer, Integer> pos);

    /**
     * Switches the flag status of the cell at the given position.
     *
     * @param pos the position of the cell to be flagged
     */
    void switchFlag(Pair<Integer, Integer> pos);

    /**
     * Checks if the cell at the given position is flagged.
     *
     * @param pos the position of the cell to be checked
     * @return true if the cell is flagged, false otherwise
     */
    boolean isFlagged(Pair<Integer, Integer> pos);

}
