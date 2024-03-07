package e2;

import java.util.HashMap;
import java.util.Map;

public class GridImpl implements Grid {

    private final int size;
    private final int mines;
    private final Map<Pair<Integer, Integer>, Cell> cells;

    public GridImpl(int size, int mines) {
        this.size = Math.max(1, size);
        this.mines = mines;
        this.cells = new HashMap<>();
    }
}
