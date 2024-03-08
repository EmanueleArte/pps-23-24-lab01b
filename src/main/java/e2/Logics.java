package e2;

import java.util.Map;

public interface Logics {

    /**
     * Method to check if the game is won.
     *
     * @return true if the game is won, false otherwise
     */
    boolean isWin();

    /**
     * Method to check if the game is lost.
     *
     * @param pos the position of the cell to reveal
     * @return true if the game is lost, false otherwise
     */
    boolean isLost(Pair<Integer, Integer> pos);

    /**
     * Method to set the flag of a cell.
     *
     * @param pos the position of the cell to reveal
     */
    void switchCellFlag(Pair<Integer, Integer> pos);

    /**
     * Method to get the cells to show, so revealed and flagged cells.
     *
     * @param pos the position of the cell to reveal
     * @return a map with the positions of the cells as keys and as values the number of mines around the cell or
     * MINE_FOUND value if the cell is a mine
     */
    Map<Pair<Integer, Integer>, Integer> getCellsToShow();

    /**
     * Method to reveal all the cells of the board.
     */
    void revealAll();

}
