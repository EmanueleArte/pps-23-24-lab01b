package e2;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private static final int SIZE = 5;
    private static final int MINES = 5;
    private Grid grid;

    @BeforeEach
    void beforeEach() {
        this.grid = new GridImpl(SIZE, MINES);
    }

    @Test
    void testGridCreation() {
        assertAll(
                () -> assertEquals(SIZE * SIZE, this.grid.getSize()),
                () -> assertEquals(MINES, this.grid.getMines())
        );
    }

    @Test
    void testGridCreationWithInvalidParameters() {
        this.grid = new GridImpl(-1, MINES);
        assertAll(
                () -> assertEquals(1, this.grid.getSize()),
                () -> assertEquals(1, this.grid.getMines())
        );
    }

    @Test
    void testGridCreationWithInvalidMines() {
        this.grid = new GridImpl(SIZE, -1);
        assertAll(
                () -> assertEquals(SIZE * SIZE, this.grid.getSize()),
                () -> assertEquals(0, this.grid.getMines())
        );
    }

    @Test
    void testMineFound() {
        this.grid = new GridImpl(1, 1);
        assertTrue(this.grid.isMine(new Pair<>(0, 0)));
    }

    @Test
    void testMineNotFound() {
        this.grid = new GridImpl(1, 0);
        assertFalse(this.grid.isMine(new Pair<>(0, 0)));
    }

    @Test
    void testFlagCell() {
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        this.grid.switchFlag(position);
        assertTrue(this.grid.isFlagged(position));
    }

    @Test
    void testWin() {
        this.grid = new GridImpl(1, 1);
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        this.grid.switchFlag(position);
        assertEquals(0, this.grid.getMines());
    }

    @Test
    void testLose() {
        this.grid = new GridImpl(1, 1);
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        assertEquals(GridImpl.MINE_FOUND, this.grid.revealCell(position));
    }

    @Test
    void testRevealCellNoMinesAround() {
        this.grid = new GridImpl(SIZE, 0);
        assertEquals(0, this.grid.revealCell(new Pair<>(1, 1)));
    }

    @Test
    void testRevealCellMinesAround() {
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        List<Pair<Integer, Integer>> minesPositions = List.of(
                new Pair<>(0, 1),
                new Pair<>(1, 1),
                new Pair<>(1, 0)
        );
        this.grid = new GridImpl(SIZE, 0, minesPositions);
        assertAll(
                () -> assertEquals(minesPositions.size(), this.grid.revealCell(position)),
                () -> assertEquals(minesPositions.size(), this.grid.getCell(position).getMinesAround())
        );
    }

    @Test
    void testCellsAround() {
        this.grid = new GridImpl(SIZE, MINES);
        Pair<Integer, Integer> position = new Pair<>(1, 1);
        List<Pair<Integer, Integer>> cellsAround = List.of(
                new Pair<>(0, 0),
                new Pair<>(0, 1),
                new Pair<>(0, 2),
                new Pair<>(1, 0),
                new Pair<>(1, 2),
                new Pair<>(2, 0),
                new Pair<>(2, 1),
                new Pair<>(2, 2)
        );
        assertAll(
                () -> assertEquals(cellsAround.size(), this.grid.getCellsAroundPositions(position).count()),
                () -> assertTrue(this.grid.getCellsAroundPositions(position).toList().containsAll(cellsAround))
        );
    }

    @Test
    void testCellsAroundBorder() {
        this.grid = new GridImpl(SIZE, MINES);
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        List<Pair<Integer, Integer>> cellsAround = List.of(
                new Pair<>(0, 1),
                new Pair<>(1, 0),
                new Pair<>(1, 1)
        );
        assertTrue(this.grid.getCellsAroundPositions(position).toList().containsAll(cellsAround));
    }

}
