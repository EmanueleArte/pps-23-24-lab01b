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


}
