package e2;

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

}
