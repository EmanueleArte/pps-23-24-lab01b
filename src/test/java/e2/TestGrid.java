package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestGrid {

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
        Pair<Integer, Integer> pos = new Pair<>(0, 0);
        this.grid.switchFlag(pos);
        assertTrue(this.grid.isFlagged(pos));
    }

}
