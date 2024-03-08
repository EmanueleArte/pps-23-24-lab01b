package e2;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    private static final int MINES = 5;
    private Logics logics;

    @BeforeEach
    void beforeEach() {
        this.logics = new LogicsImpl(SIZE, MINES);
    }

    @Test
    void testIsNotWin() {
        assertFalse(this.logics.isWin());
    }

    @Test
    void testIsWin() {
        this.logics = new LogicsImpl(SIZE, 0);
        assertFalse(this.logics.isWin());
        this.logics.isLost(new Pair<>(0, 0));
        assertTrue(this.logics.isWin());
    }

    @Test
    void testIsLost() {
        this.logics = new LogicsImpl(1, 1);
        assertTrue(this.logics.isLost(new Pair<>(0, 0)));
    }

    @Test
    void testSwitchCellFlag() {
        this.logics = new LogicsImpl(1, 1);
        this.logics.switchCellFlag(new Pair<>(0, 0));
        assertTrue(this.logics.isWin());
    }

    @Test
    void testEmptyCellsToShow() {
        assertEquals(0, this.logics.getCellsToShow().size());
    }

    @Test
    void testRevealAllCellsNearToZeroMineCell() {
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        List<Pair<Integer, Integer>> minesPositions = List.of(
                new Pair<>(0, 2),
                new Pair<>(1, 2),
                new Pair<>(2, 2),
                new Pair<>(2, 0),
                new Pair<>(2, 1)
        );
        List<Pair<Integer, Integer>> revealedCells = List.of(
                new Pair<>(0, 0),
                new Pair<>(0, 1),
                new Pair<>(1, 0),
                new Pair<>(1, 1)
        );
        this.logics = new LogicsImpl(SIZE, 0, minesPositions);
        assertAll(
                () -> assertFalse(this.logics.isLost(position)),
                () -> assertEquals(revealedCells.size(), this.logics.getCellsToShow().size()),
                () -> assertTrue(this.logics.getCellsToShow().keySet().containsAll(revealedCells))
        );
    }

    @Test
    void testRevealAllCellsInOne() {
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        this.logics = new LogicsImpl(SIZE, 0);
        assertAll(
                () -> assertFalse(this.logics.isLost(position)),
                () -> assertTrue(this.logics.isWin()),
                () -> assertEquals(SIZE * SIZE, this.logics.getCellsToShow().size())
        );
    }

    @Test
    void testWinWithFlaggedMines() {
        final int size = 2;
        final int mines = 1;
        Pair<Integer, Integer> minePosition = new Pair<>(0, 0);
        this.logics = new LogicsImpl(size, mines, List.of(minePosition));
        this.logics.switchCellFlag(minePosition);
        assertFalse(this.logics.isWin());
        this.logics.isLost(new Pair<>(1, 1));
        this.logics.isLost(new Pair<>(0, 1));
        this.logics.isLost(new Pair<>(1, 0));
        assertTrue(this.logics.isWin());
    }

    @Test
    void testRevealAll() {
        this.logics.revealAll();
        assertEquals(SIZE * SIZE, this.logics.getCellsToShow().size());
    }

}
