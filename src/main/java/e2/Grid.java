package e2;

import java.util.stream.Stream;

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

    /**
     * Reveals the cell at the given position.
     *
     * @param pos the position of the cell to be revealed
     * @return a number between 0 and 8, representing the number of mines around the cell, or a default MINE_FOUND value
     * if the cell is a mine
     */
    int revealCell(Pair<Integer, Integer> pos);

    /**
     * Returns the cell at the given position.
     *
     * @param pos the position of the cell to be returned
     * @return the cell at the given position
     */
    Cell getCell(Pair<Integer, Integer> pos);

    /**
     * Returns a stream of the positions of the cells around the given position.
     *
     * @param pos the position of the cell to be checked
     * @return a stream of the positions of the cells around the given position
     */
    Stream<Pair<Integer, Integer>> getCellsAroundPositions(Pair<Integer, Integer> pos);

}
