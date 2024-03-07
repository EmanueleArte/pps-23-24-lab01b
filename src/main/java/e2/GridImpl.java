package e2;

import java.util.*;
import java.util.stream.IntStream;

public class GridImpl implements Grid {

    public static int MINE_FOUND = -1;
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
    public GridImpl(int size, int mines, List<Pair<Integer, Integer>> minesList) {
        int gridSize = Math.max(1, size);
        this.mines = mines < 0 ? 0 : Math.min(gridSize * gridSize, mines);
        this.cells = new HashMap<>();

        if (minesList.isEmpty()) {
            minesList = generateMines(gridSize);
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Pair<Integer, Integer> pos = new Pair<>(i, j);
                this.cells.put(pos, new CellImpl(minesList.contains(pos)));
            }
        }
    }

    /**
     * Constructor for the GridImpl class.
     *
     * @param size  the size of the grid, if less than 1, it will be set to 1
     * @param mines the number of mines, if less than 0, it will be set to 0 and if greater than the size squared,
     *              it will be set to the size squared
     */
    public GridImpl(int size, int mines) {
        this(size, mines, new ArrayList<>());
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

    @Override
    public int revealCell(Pair<Integer, Integer> pos) {
        Cell cell = this.cells.get(pos);
        cell.reveal();
        if (cell.isMine()) {
            return MINE_FOUND;
        }
        return (int) IntStream.rangeClosed(-1, 1)
                .mapToObj(i -> IntStream.rangeClosed(-1, 1)
                        .mapToObj(j -> new Pair<>(pos.getX() + i, pos.getY() + j)))
                .flatMap(p -> p)
                .filter(p -> p.getX() >= 0 && p.getX() < Math.sqrt(this.cells.size()))
                .filter(p -> p.getY() >= 0 && p.getY() < Math.sqrt(this.cells.size()))
                .filter(p -> this.cells.get(p).isMine())
                .count();
    }

    @Override
    public Cell getCell(Pair<Integer, Integer> pos) {
        return this.cells.get(pos);
    }
}
