package e2;

import org.junit.jupiter.api.*;

import java.util.List;

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

    

}
