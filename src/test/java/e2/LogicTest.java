package e2;

import org.junit.jupiter.api.*;

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
        assertFalse(logics.isWin());
    }

    @Test
    void testIsWin() {
        this.logics = new LogicsImpl(SIZE, 0);
        assertTrue(logics.isWin());
    }

    @Test
    void testIsLost() {
        this.logics = new LogicsImpl(1, 1);
        Pair<Integer, Integer> position = new Pair<>(0, 0);
        assertTrue(logics.isLost(this.logics.revealCell(position)));
    }


}
