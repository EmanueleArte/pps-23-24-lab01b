package e2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return this.revealCell(pos) == GridImpl.MINE_FOUND;
    }

    @Override
    public void switchCellFlag(Pair<Integer, Integer> pos) {
        this.grid.switchFlag(pos);
    }

    @Override
    public Map<Pair<Integer, Integer>, Integer> getCellsToShow() {
        return IntStream.range(0, (int) Math.sqrt(this.grid.getSize()))
                .boxed()
                .flatMap(i -> IntStream.range(0, (int) Math.sqrt(this.grid.getSize()))
                        .mapToObj(j -> new Pair<>(i, j)))
                .filter(p -> this.grid.isFlagged(p) || this.grid.isRevealed(p))
                .collect(Collectors.toMap(p -> p, p -> this.grid.getCell(p).getMinesAround()));
    }

    private int revealCell(Pair<Integer, Integer> pos) {
        int nearMines = this.grid.revealCell(pos);
        if (nearMines == 0) {
            this.grid.getCellsAroundPositions(pos)
                    .filter(p -> !this.grid.isFlagged(p) && !this.grid.isRevealed(p))
                    .forEach(this::revealCell);
        }
        return nearMines;
    }


}
