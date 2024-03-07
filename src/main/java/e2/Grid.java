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

}
