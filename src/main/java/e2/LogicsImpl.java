package e2;

import java.util.List;

public class LogicsImpl implements Logics {

    private final Grid grid;

    /**
     * Constructor for the GridImpl class.
     *
     * @param size           the size of the grid, if less than 1, it will be set to 1
     * @param mines          the number of mines, if less than 0, it will be set to 0 and if greater than the size squared,
     *                       it will be set to the size squared
     * @param minesPositions the positions of the mines
     */
    public LogicsImpl(int size, int mines, List<Pair<Integer, Integer>> minesPositions) {
        this.grid = new GridImpl(size, mines, minesPositions);
    }

    /**
     * Constructor for the GridImpl class.
     *
     * @param size  the size of the grid, if less than 1, it will be set to 1
     * @param mines the number of mines, if less than 0, it will be set to 0 and if greater than the size squared,
     *              it will be set to the size squared
     */
    public LogicsImpl(int size, int mines) {
        this.grid = new GridImpl(size, mines);
    }

    @Override
    public boolean isWin() {
        return this.grid.getMines() == 0;
    }

    @Override
    public boolean isLost(Pair<Integer, Integer> pos) {
        return this.grid.revealCell(pos) == GridImpl.MINE_FOUND;
    }

    @Override
    public int revealCell(Pair<Integer, Integer> pos) {
        return this.grid.revealCell(pos);
    }
}
