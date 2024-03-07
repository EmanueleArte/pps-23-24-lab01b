package e2;

import java.util.*;
import java.util.stream.IntStream;

public class GridImpl implements Grid {

    private final int mines;
    private final Map<Pair<Integer, Integer>, Cell> cells;
    private final Random random = new Random();

    /**
     * Constructor for the GridImpl class.
     *
     * @param size  the size of the grid, if less than 1, it will be set to 1
     * @param mines the number of mines, if less than 0, it will be set to 0 and if greater than the size squared,
     *              it will be set to the size squared
     */
    public GridImpl(int size, int mines) {
        int gridSize = Math.max(1, size);
        this.mines = mines < 0 ? 0 : Math.min(gridSize * gridSize, mines);
        this.cells = new HashMap<>();

        List<Pair<Integer, Integer>> minesList = generateMines(gridSize);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Pair<Integer, Integer> pos = new Pair<>(i, j);
                this.cells.put(pos, new CellImpl(minesList.contains(pos)));
            }
        }
    }

    private List<Pair<Integer, Integer>> generateMines(int size) {
        int gridSize = size * size;
        List<Pair<Integer, Integer>> mines = new ArrayList<>();
        for (int i = 0; i < this.mines; i++) {
            Pair<Integer, Integer> mine;
            do {
                mine = new Pair<>(random.nextInt(gridSize), random.nextInt(gridSize));
            } while (mines.contains(mine));
            mines.add(mine);
        }
        return mines;
    }

    @Override
    public int getMines() {
        return (int) (this.mines - this.cells.values().stream().filter(Cell::isMine).filter(Cell::isFlagged).count());
    }

    @Override
    public int getSize() {
        return this.cells.size();
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.cells.get(pos).isMine();
    }

    @Override
    public void switchFlag(Pair<Integer, Integer> pos) {
        this.cells.get(pos).switchFlag();
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return this.cells.get(pos).isFlagged();
    }
}
